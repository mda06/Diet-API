# Diet API Documention
This document contains the documention about this API

## Sumary
* [Authentication](#authentication)
* [Structure of the project](#structure-of-the-project)
* [Environments](#environments)
* [Extra](#extra)
* [Test users](#test-users)
* [Migrations](#migrations)
* [Models](#models)
* [Dto's](#dtos)
* [Repositories](#repositories)
* [Services](#services)
* [Controllers](#controllers)

## Authentication
The authorization server used is **Auth0**.
The keys needed for connecting with Auth0 is in /src/main/resources/development.properties

## Structure of the project
* Api
    - Main of the application
* Batch
    - Files for add products in batch
* Controllers
    - All the controllers are located here
* Model
    - All the models are located here
* Repositories
    - All the repositories are located here
* Dto
    - All the dto's are located here
* Service
    - All the services are located here
* Static
    - Web app builded with npm
    -/products
        - Temporary json files that will be batched
        
## Environments
There are 3 properties files each one for another environment.
Theses files are located in /src/main/resources/*

* Production
    - prod.properties: This file is not on git, only on the local PC
* Development
    - development.properties
* Test
    - test.properties
    
## Extra
* Dates are written as yyyy-mm-dd

## Test users
There currently 3 test users
* Patient
    - Username: _caline@patient.com_
    - Password: _caline_
* Dietetist
    - Username: _momo@diet.com_
    - Password: _momo_
* Admin
    - Username: _mda@admin.com_
    - Password: _mda_
    
## Migrations
*Flyway* is used as migration tool.
The migrations files are located in /src/main/resources/db/migration

## Models
### Address
Basic information about an address

### Customer
Base class for the users

### Patient
Contains information about a patient

### Dietetist
The main user of this application

### Admin
The owner of the API

### AnthropometricParameter
Data from a patient on a certain date

### Product
Contains product id and url of a picture

### ProductTranslation
Name about a product in a certain language

### Nutriment
Nutriments information about a product in a certain language

### Menu
The list of all the meals that a patient needs to take ona certain date

### Meal
Information about one meal of the day(lunch, diner, ...)
A patient can score and comment this meal. 
Contains a list of mealproducts
A dietetist can add extra info about this meal
Is inside a menu or a diet (template)

### MealProduct
Contains a product and his quantity for a certain meal

## Dto's
### Auth0TokenAskDto
Class that contains the data that need to be send to auth0 to get the token

### Auth0TokenReturnDto
Class that contains the data that be returned by auth0

### Auth0SignupAskDto
Class that contains data that need to be send to auth0 to signup
* customerId 
    - The id of an existing customer
    - email/password the email and password for the user

### Auth0SignupReturnDto
Class that contains the data that be returned by auth0
* _id
    - Id of the user

### RoleDto
Enum used in /auth/role to know which role the user is
* PATIENT
* ADMIN
* DIET

### DietetistAttachPatientDto
Used with attach or detach a patient to a dietetist 
* Patient_id
    - Id of the patient that’s going to be attached to a dietetist
* Diet_id
    - Id of the dietetist where to patient is going to be attached

### ProductNameDto
* Only name, id and is favourite 
* Returned by getAll products

### ProductDto
* All the product information with 1 language 

### DietetistDto
* Used to return without products

### DietetistNameDto
* Return only firstname, lastname & id

### MealProductDto
* Contains the quantity and the productId of a meal

### MealDto
* Holds an array of mealproductsdto

### MenuDto
* Has the id of a patient instead of the object

### MenuDateDto
* Contains only id, date and the patientId


## Repositories
### ProductRepository
* FindByTranslationsLanguageEqualsAndTranslationsNameLike
    - First way to retrieve products with paging and filtering
    - Don’t use it anymore use ProductTranslationRepository instead
        - It’s more efficient

### ProductTranslationRepository
* FindByLanguageAndNameLike
    - Better way to find products

## Services
### LoginAccessService
Maintenance and activity dates are in UTC.

## Controllers
### DietetistController

### PatientController

### AnthropometricParameterController

### AuthenticationController

### ProductController

### MenuController

### MealController

### MealProductController

### ReportController

