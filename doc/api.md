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
* [Dto's](#dto's)
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

### MealPicture
Contains all the information about a mealpicture

* id: Long = _Id of the picture_
* date: LocalDate = _Date of the picture_
* filname: String = _Name of the picture_
* patient: Patient = _The patient of that picture_
                   

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

* customerId: Long = _Id of the user_,
* email: String = _Email of the user_,
* password: String = _Password of the user_,
* connection: String = _Connection type for the token_,
* client_id: String? = _ID of the API_

### Auth0TokenReturnDto
Class that contains the data that be returned by auth0

* _id: String = _Id of Auth0_,
* email_verified: Boolean = _Boolean that say if the email is verified_,
* email: String = _Email of the user_

### Auth0SignupAskDto
Class that contains data that need to be send to auth0 to signup

* grant_type: String = _Type of grant_,
* scope: String = _Scope for the token_,
* audience: String? = _Audience of the API_,
* client_id: String? = _ID of the API_,
* client_secret: String? = _Secret key of the API_,
* username: String = _Username of the user_,
* password: String = _Password of the user_

### Auth0SignupReturnDto
Class that contains the data that be returned by auth0

* access_token: String = _Access token to be used for the API_,
* id_token: String = _Id of that token_,
* scope: String? = _Scope for that token_,
* expires_in: Int = _Expires time for that token_,
* token_type: String = _Type of that token_

### DietetistAttachPatientDto
Used with attach or detach a patient to a dietetist 

* patient_id: Long = _Id of the patient that’s going to be attached to a dietetist_
* diet_id: Long = _Id of the dietetist where to patient is going to be attached_

### DietetistDto
Used to return without products

* id: Long = _Id of the dietetist_,
* authId: String? = _Auth ID of the dietetist_,
* firstName: String = _First name of the dietetist_,
* middleName: String = _Middle name of the dietetist_,
* lastName: String = _Last name of the dietetist_,
* email: String = _Email of the dietetist_,
* phone: String = _Phone of the dietetist_,
* address: Address = _Addres of the dietetist_,
* gender: Gender? = _Gender of the dietetist_,
* created: LocalDate? = _Created date of the dietetist_,
* birthday: LocalDate? = _Birthday of the dietetist_,
* vat: String = _VAT of the dietetist_,
* patients: MutableList<Patient> = _Patients of the dietetist_

### DietetistNameDto
Return only firstname, lastname & id

* id: Long = _ID of the dietetist_,
* firstName: String = _First name of the dietetist_,
* lastName: String = _Last name of the dietetist_

### DietFavProduct
Used for adding or removing product favourites

* prod_id: Long? = _Id of the product_
* diet_id: Long? = _of the dietetist_

### LoginBlacklistDto
Used to blacklist a user

* id: String = _Auth ID of the user that will be blacklisted_

### MaintenanceDto
Used to put the API in maintenance

* reason: String = _The reason why the API will be in maintenance_

### MealDto
Use a mealproductdto instead of the POJO class

* id: Long = _Id of the meal_,
* dietId: Long = _Diet id of the meal_,
* menuId: Long = _Menu id of the meal_,
* name: String = _Name of the meal_,
* extraInfo: String = _Extra information about the meal_,
* score: Int = _Score of the meal_,
* comment: String = _Comment of the meal_,
* mealProducts:  List<MealProductDto> = _List of all his meal products_

### MealPictureDto
Contains basic information about a mealpicture

* id: Long = _Id of the picture_
* date: LocalDate = _Date of the picture_
* filname: String = _Name of the picture_
                   
### MealProductDto
Contains the quantity and the productId of a meal  

* id: Long = _Id of the mealproduct_,
* quantity: Int = _Quantity of the mealproduct_ ,
* productId: Long = _ProductId of the mealproduct_ ,
* mealId: Long = _Meal id of the mealproduct_

### MenuDateDto
Contains only id, date and the patientId

* id: Long = _Id of the menu_
* patientId: Long = _Of the the patient_
* date: LocalDate? = _Date of the menu_

### MenuDto
Has the id of a patient instead of the object

* id: Long = _Id of the menu_,
* patientId: Long = _Id of the patient_,
* date: LocalDate? = _Date of the menu_,
* meals: List<MealDto> = _List of the meals in the menu_

### NutrimentDto
Used to return all the nutriment information in one language 

* name: String = _Name of the nutriment_,
* value: Double = _Value of the nutriment_,
* unit: String = _Unit of the nutriment_

### ProductDto
Used to return all the product information in one language 

* id: Long = _Id of the product_,
* imgUrl: String = _Image URL of the product_,
* name: String = _Name of the product_,
* units: List<Nutriment> = _Units of the product_,
* macros: List<Nutriment> = _Macros of the product_,
* micros: List<Nutriment> = _Micros of the product_,
* favorite: Boolean = _Is the product a favourite_
        
### ProductNameDto
Used to return only the id and the name of a product

* id: Long = _Id of the product_
* name: String = _Name of that product_

### ReportMenuDto
Used to return a report about a menu

* date: LocalDate? = _Date of the menu_,
* macros: List<NutrimentDto> = _Total of all the macro nutriments of the menu_,
* micros: List<NutrimentDto> = _Total of all the micro nutriments of the menu_
                         
### RoleDto
Enum used in /auth/role to know which role the user is

* PATIENT
* ADMIN
* DIET


## Repositories
All the repositories extends from **CrudRepository<Model, Long>**.
The long is the ID of the model
CrudRepository contains all the basics CRUD methods.

### AddressRepository
Use the address as model

### AdminRepository
Use the admin as model

### AnthropometricParameterRepository
Use the anthropometricparameter as model

- **getAllByPatientId**
    * Take an _patient id_ as parameter
    * Returns a _list of anthropometricparameter_ for that specific patient

### CustomerRepository
Use the customer as model

- **getByAuthId**
    * Take the _authid_ as parameter
    * Returns the _customer_ associated with this id

### DietetistRepository
Use the dietetist as model

### LoginAccessRepository
Use the loginaccess as model

### MaintenanceRepository
Use the maintenance as model

- **findFirstByOrderByIdDesc**
    * Returns the _latest Maintenance_
    
### MealPictureRepository
Use the MealPicture as model

### MealProductRepository
Use the mealproduct as model

- **countByProductId**
    * Take an _product id_ as parameter
    * Returns the _total times of this product is used_
    

- **findFirstByOrderByIdDesc**
    * Returns the _latest Maintenance_

### MealRepository
Use the meal as model

- **findByMenuId**
    * Take the _id of a menu_ as parameter
    * Returns a _list of meals for this menu_

- **findByDietId**
    * Take the _id of a diet_ as parameter
    * Returns a _list of meals for this diet_

### MenuRepository
Use the menu as model

- **findByPatientId**
    * Take the _id of a patient_ as parameter
    * Returns all _his menus_

- **findByDate**
    * Take a _month_, _year_ and _patient id_ as parameter
    * Returns a _list of menus associated to this patient for a certain month_
 
- **findByDateAndPatientIdIs**
    * Take a _date_ and _patient id_ as parameter
    * Return a _menu for this date_

### PatientRepository
Use the patient as model

- **getAllByDietetistId**
    * Take the _id of an diet_ as parameter
    * Returns a _list of his patients_

### ProductRepository
Use the product as model

- **findByTranslationsLanguageEqualsAndTranslationsNameLike**
    * _Not used any more_
    * First way to retrieve products with paging and filtering
    * Don’t use it anymore use ProductTranslationRepository instead
        - It’s more efficient

- **findByIdAndTranslationsLanguageEquals**
    * Take an _id of a product_ and the _desired language_ as parameter
    * Return the _product in the desired language_

- **findByDietetistsIdIs**
    * Take an _id of a diet_ and a _pageable_ object(used for pagination) as parameter
    * Return a _page(used for pagination) of products_
        
### ProductTranslationRepository
Use the producttranslation as model

- **findByLanguageAndNameLike**
    * _Better way to find products_
    * Take a _language_, _name_ and _pageable_ object as parameter
        - The _language_ is the desired language
        - The _name_ of the product that will be searched (SQL notation: where productname like '%name%')
        - The _page_ is used for pagination
    * Returns a _page(used for pagination) of products_

## Services
### AddressService

<details>
<summary>findAll()</summary>

##### Returns
* Returns a _list of all the addresses_
</details>

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: The id of the address

##### Throws
* _CustomNotFoundException_: if no address is found with that id

##### Returns
* The _address_ that match this id
</details>

<details>
<summary>addAddress(address)</summary>

##### Parameters
* _address_: Address that will be saved

##### Returns
* Returns the saved _address_
</details>

<details>
<summary>updateAddress(id, address)</summary>

##### Parameters
* _id_: The ID of the address that will be updated
* _address_: The address that will be updated

##### Return
* Returns the saved _address_
</details>

<details>
<summary>deleteAddress(id)</summary>
 
##### Parameters
* _id_: The id of the address that will be deleted
</details>

---

### AdminService

<details>
<summary>findAll()</summary>

##### Returns
* Returns a _list of all the admins_
</details>

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: The id of the admin

##### Throws
* _CustomNotFoundException_: if no admin is found with that id

##### Returns
* The _admin_ that match this id
</details>

<details>
<summary>addAdmin(admin)</summary>

##### Parameters
* _admin_: Admin that will be saved

##### Returns
* Returns the saved _admin_
</details>

<details>
<summary>updateAdmin(id, admin)</summary>

##### Parameters
* _id_: The ID of the admin that will be updated
* _admin_: The admin that will be updated

##### Return
* Returns the saved _admin_
</details>

<details>
<summary>deleteAdmin(id)</summary>
 
##### Parameters
* _id_: The id of the admin that will be deleted
</details>

---

### AnthropometricParameterService
> AP: Anthropometric Parameter

<details>
<summary>findAll()</summary>

##### Return
* Returns a _list of all the AP_
</details>

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: The id of the AP

##### Throws
* _CustomNotFoundException_: if no AP is found with that id

##### Returns
* The _AP_ that match this id
</details>

<details>
<summary>getByPatient(id)</summary>

##### Parameters
* _id_: The id of the patient

##### Throws
* _CustomNotFoundException_: if no patient is found with that id

##### Returns
* A _list of AP_ for that specified patient
</details>

<details>
<summary>addAP(AP)</summary>

##### Parameters
* _AP_: Admin that will be saved

##### Return
* Returns the saved _AP_
</details>

<details>
<summary>updateAP(id, AP)</summary>

##### Parameters
* _id_: The ID of the AP that will be updated
* _AP_: The AP that will be updated

#### Returns
* Returns the saved _AP_
</details>

<details>
<summary>deleteAP(id)</summary>

##### Parameters
* _id_: The id of the AP that will be deleted
</details>

---

### AuthenticationService

<details>
<summary>getManagementToken()</summary>

##### Throw
* _IllegalArgumentException_: if an exception occurs

##### Returns
* Returns the _management token_
</details>

<details>
<summary>existUsername(email)</summary>

##### Parameters
* _email_: The email that wil be checked if it already exists 

##### Throw
* _IllegalArgumentException_: if an exception occurs

##### Returns
* Return a _boolean_ to indicate of the username already exists 
</details>

<details>
<summary>getToken(token)</summary>

##### Parameters
* _token_: An Auth0TokenAskDto for asking a bearer token

##### Throw
* _IllegalArgumentException_ if an exception occurs

##### Returns
* Returns a _Auth0TokenReturnDto_ with the token inside of it
</details>

<details>
<summary>getUser()</summary>

##### Returns
* If the user is a Dietetist it returns a _DietetistDto_ else il will return a _Customer_
</details>

<details>
<summary>getRole()</summary>

##### Throw
* _CustomerNotFoundException_: If no customer is found

##### Returns
* Returns a _RoleDto_ to indicate the role of a user
</details>

<details>
<summary>getId()</summary>

##### Returns
* Returns the _id_ of a user
</details>

<details>
<summary>deleteUser(id)</summary>

##### Parameters
* _id_: The id of a user that will be deleted

##### Throws
* _CustomNotFoundException_: If no user is found with that id
* _IllegalArgumentException_: If an network error occurs
</details>

<details>
<summary>logout()</summary>

##### Description
* Use the loginservice to logout an user
</details>

---

### DietetistService

<details>
<summary>findAll()</summary>

##### Returns
* Return all the _DietetistNameDto_
</details>

<details>
<summary>addDietetist(dietetist)</summary>

##### Parameters
* _dietetist_: The dietetist that will be added

##### Returns
* Returns the saved _dietetist_
</details>

<details>
<summary>deleteDietetist(id)</summary>

##### Parameters
* _id_: Id of the dietetist that will be deleted

</details>

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: If of the dietetist

##### Throws
* _CustomNotFoundException_: If no diet is found

##### Returns
* Returns the _DietetistDto_
</details>

<details>
<summary>attachPatient(dto)</summary>

##### Parameters
* _dto_: DietetistAttachPatientDto that contains the id of the diet and 

##### Throws
* _CustomNotFoundException_: If no diet or patient is found

##### Returns
* Returns the _dietetist_
</details>

<details>
<summary>detachPatient(dto)</summary>

##### Parameters
* _dto_: DietetistAttachPatientDto that contains the id of the diet and 

##### Throws
* _CustomNotFoundException_: If no diet or patient is found

##### Returns
* Returns the _dietetist_
</details>

---

### LoginAccessService
Maintenance and activity dates are in UTC.

<details>
<summary>isInMaintenance()</summary>

##### Returns
* A _boolean_ that indicated if the API is in maintenance
</details>

<details>
<summary>putInMaintenance(reason)</summary>

##### Parameters
* _reason_: The reason why the API is in maintenance

##### Throws
* _LoginException_: If it's already in maintenance

##### Returns
* Returns a _Maintenance_ with the appropriate data
</details>

<details>
<summary>removeMaintenance()</summary>

##### Throws
* _LoginException_: If it's not in maintenance

##### Returns
* Returns a _Maintenance_ with the appropriate data
</details>

<details>
<summary>getAll()</summary>

##### Returns
* Returns all _LoginAccess_
</details>

<details>
<summary>onLogin(token)</summary>

##### Parameters
* _token_: The token of the user that' loggin in

##### Throws
* _LoginException_: If the token is not valid

##### Returns
* Returns a _LoginAccess_ with the appropriate data
</details>

<details>
<summary>toLocalDateTime(timestamp)</summary>

##### Parameters
* _timestamp_: The current timestamp in a Date object

##### Returns
* Returns the _java.sql.Timestamp_ of the timestamp
</details>

<details>
<summary>onLogout(id)</summary>

##### Parameters
* _id_: The id of the LoginAccess 

##### Throws
* _CustomNotFoundException_: If no loginaccess with this id exist

##### Returns
* Returns the _LoginAccess_ for this id
</details>

<details>
<summary>addActivity(id)</summary>

##### Parameters
* _id_: The id of the LoginAccess where the lastactivity datetime will be changed

##### Throws
* _CustomNotFoundException_: If no loginaccess with this id exist

##### Returns
* Returns the _LoginAccess_ for this id
</details>

<details>
<summary>getMaintenanceStatus()</summary>

##### Returns
* Returns the _Maintenance_ status
</details>

<details>
<summary>blacklistLogin(blacklistDto)</summary>

##### Parameters
* _blacklistDto_: The LoginBlacklistDto for blacklist a user

##### Throws
* _CustomNotFoundException_: If no loginaccess with this id exist

##### Returns
* Returns a _LoginAccess_ for that user
</details>

<details>
<summary>unBlacklistLogin(blacklistDto)</summary>

##### Parameters
* _blacklistDto_: The LoginBlacklistDto for unblacklist a user

##### Throws
* _CustomNotFoundException_: If no loginaccess with this id exist

##### Returns
* Returns a _LoginAccess_ for that user
</details>

<details>
<summary>isBlacklisted(id)</summary>

##### Parameters
* id: The id of an loginaccess

##### Throws
* _CustomNotFoundException_: If no loginaccess with this id exist

##### Returns
* Returns a _boolean_ that indicated if that loginaccess id blacklisted
</details>

---

### MealProductService

<details>
<summary>addMealProduct(dto)</summary>

##### Parameters
* _dto_: A MealProductDto that will be added to an existing meal

##### Throws
* _CustomNotFoundException_: If a product or meal doesn't exist

##### Returns
* Returns the _MealProductDto_ that's added to a meal
</details>

<details>
<summary>deleteMealProduct(id)</summary>

##### Parameters
* _id_: The id of an existing MealProduct 
</details>

<details>
<summary>countByProductId(id)</summary>

##### Parameters
* _id_: The id of an existing MealProduct 

##### Returns
* Returns the total times of this products is used in every meal
</details>

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: The id of a MealProduct 

##### Throws
* _CustomNotFoundException_: If no mealproduct exist

##### Returns
* Returns the _MealProductDto_ for the id
</details>

---

### MealService

<details>
<summary>addMeal(dto)</summary>

##### Parameters
* _dto_: The MealDto that will be added

##### Throws
* _CustomNotFoundException_: If no product, menu or diet exist

##### Returns
* Returns the saved _MealDto_
</details>

<details>
<summary>updatePatientInfo(dto)</summary>

##### Parameters
* _dto_: The MealDto for comment and score for a patient

##### Throws
* _CustomNotFoundException_: If no meal exsist with this id

##### Returns
* Returns the updated _MealDto_
</details>

<details>
<summary>deleteMeal(id)</summary>

##### Parameters
* _id_: The meal id that will be deleted
</details>

<details>
<summary>getByMenuId(id)</summary>

##### Parameters
* _id_: The id of a Menu 

##### Returns
* Returns the _MealDto_ of the menu id
</details>

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: The id of a meal 

##### Throws
* _CustomNotFoundException_: If no meal exist

##### Returns
* Returns the _MealDto_ with that id
</details>

<details>
<summary>getByDietId(id)</summary>

##### Parameters
* _id_: The id of a Diet 

##### Returns
* Returns the _MealDto_ of the diet id
</details>

---

### MenuService

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: The of a Menu 

##### Throws
* _CustomNotFoundException_: If no menu exist with that id

##### Returns
* Returns the _MenuDto_ for that id
</details>

<details>
<summary>getByPatientId(id)</summary>

##### Parameters
* _id_: The id of that patient

##### Returns
* Returns the _MenuDto_ for that patient id
</details>

<details>
<summary>addMenu(menuDto)</summary>

##### Parameters
* _menuDto_: The Menu that will be saved 

##### Throws
* _CustomNotFoundException_: If no patient or product exist

##### Returns
* Returns the saved _MenuDto_
</details>

<details>
<summary>deleteMenu(id)</summary>

##### Parameters
* _id_: The id of the Menu that will be deleted
</details>

<details>
<summary>getByDate(month, year, patientId)</summary>

##### Parameters
* _month_: The month for the menu
* _year_: The year of the menu 
* _patientId_: The patientId of the menu 

##### Returns
* Returns the _MenuDateDto_ for that specified month, year and patient id
</details>

<details>
<summary>getByDate(date, id)</summary>

##### Parameters
* _date_: The date of the menu
* _id_: The patient id for the menu 

##### Throws
* _CustomNotFoundException_: If no menu exist

##### Returns
* Returns the _MenuDto_
</details>

----

### PatientService

<details>
<summary>findAll()</summary>

##### Returns
* Returns all the _Patients_
</details>

<details>
<summary>getById(id)</summary>

##### Parameters
* _id_: The id of the patient

##### Throws
* _CustomNotFoundException_: If no patient exist with this id

##### Returns
* Returns the _patient_ with this id
</details>

<details>
<summary>getByDiet(id)</summary>

##### Parameters
* _id_: Id of a dietetist 

##### Returns
* Returns all the _Patients_ of the dietetist
</details>

<details>
<summary>addPatient(patient)</summary>

##### Parameters
* _patient_: The patient that need to be added

##### Returns
* Returns the saved _Patient_
</details>

<details>
<summary>deletePatient(id)</summary>

##### Parameters
* _id_: The id of the deleted patient
</details>

### PictureService

<details>
<summary>handleFileUpload(pictures, date)</summary>

##### Parameters
* _pictures_: A array of MultipartFile that contains the pictures
* _date_: The date when the pictures are taken

##### Throws
* _UploadFileException_: If date is null, pictures is empty, the current user is no patient, 
there's already a file named like this or a upload exception

##### Returns
* Returns a list of the saved _MealPictures_
</details>

<details>
<summary>getMealPicturesModel(patientId)</summary>

##### Parameters
* _patientId_: A optional long parameter for the patient id. If no parameter is given, the current user id is used

##### Throws
* _UploadFileException_: If the patientId given is no patient, or if the patientId is null and the current user is no patient

##### Returns
* Returns a list of the saved _MealPictures_
</details>
---

### ProductService

<details>
<summary>getProductById(id, language, diet)</summary>

##### Parameters
* _id_: The id of the product
* _language_: The language of this product
* _diet_: The id of the diet

##### Throws
* _CustomNotFoundException_: If no product is found with this id

##### Returns
* Returns a _ProductDto_
</details>

<details>
<summary>getSize()</summary>

##### Returns
* Returns the total _number_ of products
</details>

<details>
<summary>getProducts(pageable, name, language)</summary>

##### Parameters
* _pageable_: A pageable object for pagination
* _name_: The name of the product
* _language_: The language of the product

##### Throws
* _ProductSortException_: If the product cannot be sorted

##### Returns
* Returns a page of _ProductNameDto_
</details>

<details>
<summary>getProductsFromFav(language, diet, pageable)</summary>

##### Parameters
* _language_: The language of the product
* _diet_: The diet id for favorites
* _pageable_: A pageable object for pagination

##### Returns
* Returns a page of _ProductDto_
</details>

<details>
<summary>deleteProducts()</summary>

##### Description
* Delete all the products

</details>

<details>
<summary>deleteProduct(id)</summary>

##### Parameters
* _id_: The id of the product that will be deleted 
</details>

<details>
<summary>uploadBatch(uploadFile)</summary>

##### Parameters
* _uploadFile_: A json file with a list of products 

##### Throws
* _UploadFileException_: If the filename is not correct or if the language is different then fr or en

##### Returns
* Returns a _CompletableFuture<ResponseEntity<String>>_
</details>

<details>
<summary>addProdToFav(fav)</summary>

##### Parameters
* _fav_: The DietFavProduct for adding a product to the diet fav

##### Throws
* _FavException_: If no diet or product exist

##### Returns
* Returns a _boolean_ to indicates if the product is added to the fav
</details>

<details>
<summary>removeProdFromFav(fav)</summary>

##### Parameters
* _fav_: The DietFavProduct for removing a product from the diet fav

##### Throws
* _FavException_: If no diet or product exist

##### Returns
* Returns a _boolean_ to indicates if the product is removed from the fav
</details>

---

### ReportService

<details>
<summary>getMenuReport(id, lang)</summary>

##### Parameters
* _id_: The id of a menu
* _lang_: The language of the products

##### Throws
* _CustomNotFoundException_: If a menu or product doesn't exist

##### Returns
* Returns a _ReportMenuDto_ for that menu
</details>

<details>
<summary>getPatientPdf(id)</summary>

##### Parameters
* _id_: The id of a patient 

##### Throws
* _CustomNotFoundException_: If no patient exist

##### Returns
* Returns a _ResponseEntity<InputStreamResource>_(pdf) for that patient
</details>


---

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

