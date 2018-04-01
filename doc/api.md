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
    - /products
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

* id: long = _Id of the address_
* country: String = _Country of the address_
* postcode: Int = _Postcode of the address_
* city: String = _City of the address_
* street: String = _Street of the address_
* number: String = _Number of the address_

### Admin
The owner of the API, extends from *Customer*

* nickname: String = _Nickname of the admin_

### AnthropometricParameter
Data from a patient on a certain date

* id: Long = _Id of the anthropometric parameter_
* length: Int = _Length in CM of the anthropometric parameter_
* weight: Double = _Weight in CM of the anthropometric parameter_
* bodyFat: Double = _Body fat in % of the anthropometric parameter_
* waistCircumference: Double = _Waist circumference in CM of the anthropometric parameter_
* date: LocalDate? = _Date of the anthropometric parameter_
* patientId: Long? = _The id of the patient of the anthropometric parameter_
        
### Customer
Base class for all the users

* id: Long = _Id of the customer_
* firstName: String = _First name of the customer_
* middleName: String = _Middle name of the customer_
* lastName: String = _Last name of the customer_
* email: String = _Email of the customer_
* phone: String = _Phone of the customer_
* address: Address = _Address of the customer_
* gender: Gender? = _Gender of the customer_
* created: LocalDate? = _Creation date of the customer_
* birthday: LocalDate? = _Birthday of the customer_
* authId: String? = _Id of the authorization server for the customer_


### Dietetist
The main user of this application, extends from *Customer*

* id: Long = _Id of the dietetist_
* vat: String = _Vat of the dietetist_
* patients: MutableList<Patient> = _List of the patients of the dietetist_
* favoriteProducts: MutableList<Product> = _List of the favorites products of the dietetist_
* mealTemplates: MutableList<Meal> = _List of the meal templates of the dietetist_

### Gender
Enum for a customer

* FEMALE = _Female gender_
* MALE = _Male gender_
* OTHER = _Other gender_

### LoginAccess
Contains information about the login access for a user based on his auth id
* authId: String = _Id of the authorization server_
* loginTime: LocalDateTime = _Last login time for a customer_
* logOutTime: LocalDateTime? = _Last logout time for a customer_
* expirationTime: LocalDateTime = _Expiration time of a token for a customer_
* lastActivityTime: LocalDateTime = _Last activity time for a customer_
* isBlacklisted: Boolean = _Boolean to know if a customer is blacklisted_
        
### Maintenance
Contains information about a maintenance of the API

* id: Long = _Id of the maintenance_
* reason: String = _The reason why there's a maintenance_
* beginDate: LocalDateTime? = _The begin date of a maintenance_
* endDate: LocalDateTime? = _The end date of a maintenance_
* state: MaintenanceState = _The state of the maintenance_
        
### MaintenanceState
Enum for the state of a maintenance

* BEGIN = Maintenance is at the beginning
* END = Maintenance is finish
* CORRUPTED = Maintenance is corrupted
* NONE = There's no maintenance


### Meal
Information about one meal of the day(lunch, diner, ...)

* id: Long = _Id of this meal_
* name: String = _Name of this meal_
* extraInfo: String = _Comment of the dietetist for this meal_
* score: Int = _Score that a patient has write_
* comment: String = _Extra information that the patient has write_
* menu: Menu? = _This meal contains to that meal, it's null when it's a template meal_
* mealProducts: MutableList<MealProduct> = _List of all the products inside this meal_,
* diet: Dietetist? = _That meal contains to the dietetist_        


### MealProduct
Contains a product and his quantity for a certain meal

* id: Long = _Id of this meal product_
* meal: Meal? = _Meal of which this meal product contains_
* product: Product? = _Product of this meal product_
* quantity: Int = _Quantity of this product, based on his units_


### Menu
The list of all the meals that a patient needs to take ona certain date

* id: Long = _Id of the menu_
* date: LocalDate? = _Date of the menu_
* meals: MutableList<Meal> = _List of meals for the menu_
* patient: Patient? = _Patient that needs to take this menu_


### Nutriment
Nutriments information about a product in a certain language

* id: Long = _Id of the nutriment_
* name: String = _Name of the nutriment_
* value: Double = _Value of the nutriment_
* unit: String = _Unit of the nutriment_
        
        
### Patient
Contains information about a patient, extends from *Customer*

* extraInfo: String = _Extra information about this patient_
* dietetistId: Long? = _Id of the dietetist that handles this patient_
* anthropometricParameters: MutableList<AnthropometricParameter> = _List of the parameters of the patient_

### Product
Base class of a product

* id: Long = _Id of a product_
* translations: MutableList<ProductTranslation> = _List of all the translation of the product_
* dietetists: MutableList<Dietetist> = _List of dietetist that have this product in their favorites_
* mealProducts: List<MealProduct> = _List of meal products that contains this product_

### ProductTranslation
Contains the translation about a product

* id: Long = _Id of the product translation_
* language: String = _Language of the product translation_
* name: String = _Name of the product translation_
* productId: Long = _Product id of the product translation_
* units: MutableList<Nutriment> = _List of the units for the product translation_
* macros: MutableList<Nutriment> = _List of the macro nutriments of the product translation_
* micros: MutableList<Nutriment> = _List of the micro nutriments of the product translation_

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
All the repositories extends from CrudRepository<Model, Long>.
The long is the ID of the model
CrudRepository contains all the basics CRUD methods.

### AddressRepository
Use the address as model

### AdminRepository
Use the admin as model

### AnthropometricParameterRepository
Use the anthropometricparameter as model

**getAllByPatientId**
* Take an _patient id_ as parameter
* Returns a _list of anthropometricparameter_ for that specific patient

### CustomerRepository
Use the customer as model

**getByAuthId**
* Take the _authid_ as parameter
* Returns the _customer_ associated with this id

### DietetistRepository
Use the dietetist as model

### LoginAccessRepository
Use the loginaccess as model

### MaintenanceRepository
Use the maintenance as model

**findFirstByOrderByIdDesc**
* Returns the _latest Maintenance_

### MealProductRepository
Use the mealproduct as model

**countByProductId**
* Take an _product id_ as parameter
* Returns the _total times of this product is used_

### MealRepository
Use the meal as model

**findByMenuId**
* Take the _id of a menu_ as parameter
* Returns a _list of meals for this menu_

**findByDietId**
* Take the _id of a diet_ as parameter
* Returns a _list of meals for this diet_

### MenuRepository
Use the menu as model

**findByPatientId**
* Take the _id of a patient_ as parameter
* Returns all _his menus_

**findByDate**
* Take a _month_, _year_ and _patient id_ as parameter
* Returns a _list of menus associated to this patient for a certain month_
 
**findByDateAndPatientIdIs**
* Take a _date_ and _patient id_ as parameter
* Return a _menu for this date_

### PatientRepository
Use the patient as model

**getAllByDietetistId**
* Take the _id of an diet_ as parameter
* Returns a _list of his patients_

### ProductRepository
Use the product as model

**findByTranslationsLanguageEqualsAndTranslationsNameLike**
* _Not used any more_
* First way to retrieve products with paging and filtering
* Don’t use it anymore use ProductTranslationRepository instead
    - It’s more efficient

**findByIdAndTranslationsLanguageEquals**
* Take an _id of a product_ and the _desired language_ as parameter
* Return the _product in the desired language_

**findByDietetistsIdIs**
* Take an _id of a diet_ and a _pageable_ object(used for pagination) as parameter
* Return a _page(used for pagination) of products_
        
### ProductTranslationRepository
Use the producttranslation as model

**FindByLanguageAndNameLike**
* _Better way to find products_
* Take a _language_, _name_ and _pageable_ object as parameter
    - The _language_ is the desired language
    - The _name_ of the product that will be searched (SQL notation: where productname like '%name%')
    - The _page_ is used for pagination
* Returns a _page(used for pagination) of products_

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

