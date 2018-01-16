package com.mda.diet.error

import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.HttpStatus
import java.util.ArrayList
import org.springframework.web.context.request.WebRequest
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class CustomRestExceptionHandler: ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
            ex: MethodArgumentNotValidException,
            headers: HttpHeaders,
            status: HttpStatus,
            request: WebRequest) : ResponseEntity<Any> {
        val errors = ex.bindingResult.fieldErrors.mapTo(ArrayList()) { it.field + ": " + it.defaultMessage }
        ex.bindingResult.globalErrors.mapTo(errors) { it.objectName + ": " + it.defaultMessage }

        val apiError = ApiError(HttpStatus.BAD_REQUEST, ex.localizedMessage, errors)
        return handleExceptionInternal(ex, apiError, headers, apiError.status, request)
    }

    override fun handleMissingServletRequestParameter(
            ex: MissingServletRequestParameterException, headers: HttpHeaders,
            status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val error = ex.parameterName + " parameter is missing"

        val apiError = ApiError(HttpStatus.BAD_REQUEST, ex.localizedMessage, error)
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(
            ex: ConstraintViolationException, request: WebRequest): ResponseEntity<Any> {
        val errors = ex.constraintViolations.map {
            it.rootBeanClass.name + " " + it.propertyPath + ": " + it.message
        }

        val apiError = ApiError(HttpStatus.BAD_REQUEST, ex.localizedMessage, errors)
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatch(
            ex: MethodArgumentTypeMismatchException, request: WebRequest): ResponseEntity<Any> {
        val error = ex.name + " should be of type " + ex.requiredType.name

        val apiError = ApiError(HttpStatus.BAD_REQUEST, ex.localizedMessage, error)
        return ResponseEntity(apiError, HttpHeaders(), apiError.status!!)
    }

    override fun handleNoHandlerFoundException(
            ex: NoHandlerFoundException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val error = "No handler found for " + ex.httpMethod + " " + ex.requestURL

        val apiError = ApiError(HttpStatus.NOT_FOUND, ex.localizedMessage, error)
        return ResponseEntity(apiError, HttpHeaders(), apiError.status!!)
    }

    @ExceptionHandler(CustomNotFoundException::class)
    fun handleNotFoundException(ex: CustomNotFoundException): ResponseEntity<Any> {
        val error = ApiError(HttpStatus.NOT_FOUND, ex.localizedMessage)
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(ProductSortException::class)
    fun handleProductSortException(ex: ProductSortException): ResponseEntity<Any> {
        val error = ApiError(HttpStatus.BAD_REQUEST, ex.localizedMessage)
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(UploadFileException::class)
    fun handleUploadFileException(ex: UploadFileException): ResponseEntity<Any> {
        val error = ApiError(HttpStatus.OK, ex.localizedMessage)
        return ResponseEntity(error, error.status)
    }
}