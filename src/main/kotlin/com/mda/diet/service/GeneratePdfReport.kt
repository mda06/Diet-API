package com.mda.diet.service

import com.mda.diet.error.CustomerNotFoundException
import com.mda.diet.model.Patient
import java.io.ByteArrayInputStream

import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.Element
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.ByteArrayOutputStream

class GeneratePdfReport {

    fun patientReport(patient: Patient): ByteArrayInputStream {

        val document = Document()
        val out = ByteArrayOutputStream()

        try {

            val table = PdfPTable(3)
            table.widthPercentage = 60f
            table.setWidths(intArrayOf(1, 3, 3))

            val headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD)

            var hcell: PdfPCell
            hcell = PdfPCell(Phrase("Id", headFont))
            hcell.horizontalAlignment = Element.ALIGN_CENTER
            table.addCell(hcell)

            hcell = PdfPCell(Phrase("First name", headFont))
            hcell.horizontalAlignment = Element.ALIGN_CENTER
            table.addCell(hcell)

            hcell = PdfPCell(Phrase("Last name", headFont))
            hcell.horizontalAlignment = Element.ALIGN_CENTER
            table.addCell(hcell)


            var cell: PdfPCell
            cell = PdfPCell(Phrase(patient.id.toString()))
            cell.verticalAlignment = Element.ALIGN_MIDDLE
            cell.horizontalAlignment = Element.ALIGN_CENTER
            table.addCell(cell)

            cell = PdfPCell(Phrase(patient.firstName))
            cell.paddingLeft = 5f
            cell.verticalAlignment = Element.ALIGN_MIDDLE
            cell.horizontalAlignment = Element.ALIGN_LEFT
            table.addCell(cell)

            cell = PdfPCell(Phrase(patient.lastName))
            cell.verticalAlignment = Element.ALIGN_MIDDLE
            cell.horizontalAlignment = Element.ALIGN_RIGHT
            cell.paddingRight = 5f
            table.addCell(cell)

            PdfWriter.getInstance(document, out)
            document.open()
            document.add(table)

            document.close()

        } catch (ex: DocumentException) {
            throw CustomerNotFoundException("Document Exception ! Create a new exception for this...")
        }

        return ByteArrayInputStream(out.toByteArray())
    }
}