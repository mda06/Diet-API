webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/admin/admin-dashboard/admin-dashboard.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/admin/admin-dashboard/admin-dashboard.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\n  admin-dashboard works!\n</p>\n"

/***/ }),

/***/ "../../../../../src/app/admin/admin-dashboard/admin-dashboard.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AdminDashboardComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AdminDashboardComponent = (function () {
    function AdminDashboardComponent() {
    }
    AdminDashboardComponent.prototype.ngOnInit = function () {
    };
    AdminDashboardComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-admin-dashboard',
            template: __webpack_require__("../../../../../src/app/admin/admin-dashboard/admin-dashboard.component.html"),
            styles: [__webpack_require__("../../../../../src/app/admin/admin-dashboard/admin-dashboard.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], AdminDashboardComponent);
    return AdminDashboardComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__login_login_component__ = __webpack_require__("../../../../../src/app/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__admin_admin_dashboard_admin_dashboard_component__ = __webpack_require__("../../../../../src/app/admin/admin-dashboard/admin-dashboard.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__patient_patient_dashboard_patient_dashboard_component__ = __webpack_require__("../../../../../src/app/patient/patient-dashboard/patient-dashboard.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__guard_patient_guard_service_service__ = __webpack_require__("../../../../../src/app/guard/patient-guard-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__guard_admin_guard_service_service__ = __webpack_require__("../../../../../src/app/guard/admin-guard-service.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var routes = [
    { path: 'login', component: __WEBPACK_IMPORTED_MODULE_2__login_login_component__["a" /* LoginComponent */] },
    { path: 'admin/dashboard', component: __WEBPACK_IMPORTED_MODULE_3__admin_admin_dashboard_admin_dashboard_component__["a" /* AdminDashboardComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_6__guard_admin_guard_service_service__["a" /* AdminGuardServiceService */]] },
    { path: 'patient/dashboard', component: __WEBPACK_IMPORTED_MODULE_4__patient_patient_dashboard_patient_dashboard_component__["a" /* PatientDashboardComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_5__guard_patient_guard_service_service__["a" /* PatientGuardServiceService */]] },
    { path: '', redirectTo: "/login", pathMatch: 'full' },
    { path: '**', redirectTo: "/login" }
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */].forRoot(routes, { enableTracing: false })],
            exports: [__WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<!--<div class=\"container-fluid\">\n  <div class=\"row\">\n    <div class=\"col\">\n      <h1>{{title}}</h1>\n      <hr class=\"col-xs-12\">\n    </div>\n  </div>\n</div>-->\n\n<router-outlet></router-outlet>\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'Diet Pro';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ng_bootstrap_ng_bootstrap__ = __webpack_require__("../../../../@ng-bootstrap/ng-bootstrap/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__auth0_angular_jwt__ = __webpack_require__("../../../../@auth0/angular-jwt/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__app_routing_module__ = __webpack_require__("../../../../../src/app/app-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__guard_patient_guard_service_service__ = __webpack_require__("../../../../../src/app/guard/patient-guard-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__guard_admin_guard_service_service__ = __webpack_require__("../../../../../src/app/guard/admin-guard-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__admin_admin_dashboard_admin_dashboard_component__ = __webpack_require__("../../../../../src/app/admin/admin-dashboard/admin-dashboard.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__patient_patient_dashboard_patient_dashboard_component__ = __webpack_require__("../../../../../src/app/patient/patient-dashboard/patient-dashboard.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__login_login_component__ = __webpack_require__("../../../../../src/app/login/login.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__share_DateInterceptor__ = __webpack_require__("../../../../../src/app/share/DateInterceptor.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__diet_diet_module__ = __webpack_require__("../../../../../src/app/diet/diet.module.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

















var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_13__login_login_component__["a" /* LoginComponent */],
                __WEBPACK_IMPORTED_MODULE_11__admin_admin_dashboard_admin_dashboard_component__["a" /* AdminDashboardComponent */],
                __WEBPACK_IMPORTED_MODULE_12__patient_patient_dashboard_patient_dashboard_component__["a" /* PatientDashboardComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_2__ng_bootstrap_ng_bootstrap__["b" /* NgbModule */].forRoot(),
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["c" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_5__auth0_angular_jwt__["b" /* JwtModule */].forRoot({ config: {
                        tokenGetter: function () {
                            return localStorage.getItem('token.access_token');
                        },
                        whitelistedDomains: ['localhost:8080']
                    } }),
                __WEBPACK_IMPORTED_MODULE_15__diet_diet_module__["a" /* DietModule */],
                __WEBPACK_IMPORTED_MODULE_7__app_routing_module__["a" /* AppRoutingModule */],
            ],
            providers: [
                __WEBPACK_IMPORTED_MODULE_5__auth0_angular_jwt__["a" /* JwtHelperService */],
                __WEBPACK_IMPORTED_MODULE_8__services_authentication_service__["a" /* AuthenticationService */],
                __WEBPACK_IMPORTED_MODULE_10__guard_admin_guard_service_service__["a" /* AdminGuardServiceService */],
                __WEBPACK_IMPORTED_MODULE_9__guard_patient_guard_service_service__["a" /* PatientGuardServiceService */],
                {
                    provide: __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["a" /* HTTP_INTERCEPTORS */],
                    useClass: __WEBPACK_IMPORTED_MODULE_14__share_DateInterceptor__["a" /* DateInterceptor */],
                    multi: true,
                }
            ],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/diet/detail-patient/detail-patient.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/diet/detail-patient/detail-patient.component.html":
/***/ (function(module, exports) {

module.exports = "<p *ngFor=\"let alert of alerts\">\n  <ngb-alert [type]=\"alert.type\" (close)=\"closeAlert(alert)\">{{ alert.message }}</ngb-alert>\n</p>\n\n<div *ngIf=\"!patient\">\n  Please select first a patient\n</div>\n\n<div class=\"container-fluid\" *ngIf=\"patient\">\n  <div class=\"row\">\n    <div class=\"col-md-4\">\n      <div class=\"card\">\n        <h4 class=\"card-header\">Meta data</h4>\n        <div class=\"card-body\">\n          <label for=\"firstName\">First name</label>\n          <input type=\"text\" class=\"form-control\" id=\"firstName\"\n                 required\n                 [(ngModel)]=\"patient.firstName\" name=\"firstName\">\n          <label for=\"middleName\">Middle name</label>\n          <input type=\"text\" class=\"form-control\" id=\"middleName\"\n                 [(ngModel)]=\"patient.middleName\" name=\"middleName\">\n          <label for=\"lastName\">Last name</label>\n          <input type=\"text\" class=\"form-control\" id=\"lastName\"\n                 [(ngModel)]=\"patient.lastName\" name=\"lastName\">\n          <label for=\"email\">Email</label>\n          <input type=\"text\" class=\"form-control\" id=\"email\"\n                 [(ngModel)]=\"patient.email\" name=\"email\">\n          <label for=\"phone\">Phone</label>\n          <input type=\"text\" class=\"form-control\" id=\"phone\"\n                 [(ngModel)]=\"patient.phone\" name=\"phone\">\n          <label for=\"birthday\">Birthday</label>\n          <form class=\"form-inline\">\n            <div class=\"form-group\">\n              <div class=\"input-group\">\n                <input class=\"form-control\" placeholder=\"yyyy-mm-dd\"\n                       name=\"birthday\" [(ngModel)]=\"model\" ngbDatepicker #d=\"ngbDatepicker\"\n                       (ngModelChange)=\"birthdayChange()\" id=\"birthday\">\n                <button class=\"input-group-addon\" (click)=\"d.toggle()\" type=\"button\">\n                  <img src=\"../../../assets/img/calendar-icon.svg\" style=\"width: 1.2rem; height: 1rem; cursor: pointer;\"/>\n                </button>\n              </div>\n            </div>\n          </form>\n          <div class=\"form-group\">\n            <label for=\"gender\">Gender</label>\n            <select class=\"form-control\" placeholder=\"Gender\" [(ngModel)]=\"patient.gender\" name=\"gender\" id=\"gender\">\n              <option *ngFor=\"let g of genders\" [value]=\"g.value\">\n                {{ g.title }}\n              </option>\n            </select>\n          </div>\n          <button type=\"button\" class=\"btn btn-outline-primary\" (click)=\"isAddressCollapsed = !isAddressCollapsed\"\n                  [attr.aria-expanded]=\"!isAddressCollapsed\" aria-controls=\"addressCollapse\">\n            Toggle address\n          </button>\n          <div id=\"addressCollapse\" [ngbCollapse]=\"isAddressCollapsed\">\n            <div class=\"card\">\n              <div class=\"card-body\">\n                <label for=\"street\">Street</label>\n                <input type=\"text\" class=\"form-control\" id=\"street\"\n                       [(ngModel)]=\"patient.address.street\" name=\"street\">\n                <label for=\"number\">Number</label>\n                <input type=\"text\" class=\"form-control\" id=\"number\"\n                       [(ngModel)]=\"patient.address.number\" name=\"number\">\n                <label for=\"postcode\">Postcode</label>\n                <input type=\"number\" class=\"form-control\" id=\"postcode\"\n                       [(ngModel)]=\"patient.address.postcode\" name=\"postcode\">\n                <label for=\"city\">City</label>\n                <input type=\"text\" class=\"form-control\" id=\"city\"\n                       [(ngModel)]=\"patient.address.city\" name=\"city\">\n                <label for=\"country\">Country</label>\n                <input type=\"text\" class=\"form-control\" id=\"country\"\n                       [(ngModel)]=\"patient.address.country\" name=\"country\">\n              </div>\n            </div>\n          </div>\n        </div>\n      </div>\n    </div>\n    <div class=\"col-md-4\">\n      <div class=\"card\">\n        <h4 class=\"card-header\">Anthropometric parameters</h4>\n        <div class=\"card-body\">\n            <ngb-accordion #acc=\"ngbAccordion\" activeIds=\"ngb-panel-0\">\n              <div *ngFor=\"let param of patient.anthropometricParameters\">\n                <ngb-panel title={{getFormattedDate(param.date)}}>\n                  <ng-template ngbPanelContent>\n                    <label for=\"length\">Length</label>\n                    <input type=\"number\" class=\"form-control\" id=\"length\"\n                           [(ngModel)]=\"param.length\" name=\"length\">\n                    <label for=\"weight\">weight</label>\n                    <input type=\"number\" step=\"any\" class=\"form-control\" id=\"weight\"\n                           [(ngModel)]=\"param.weight\" name=\"weight\">\n                    <label for=\"bodyFat\">Body fat</label>\n                    <input type=\"number\" step=\"any\" class=\"form-control\" id=\"bodyFat\"\n                           [(ngModel)]=\"param.bodyFat\" name=\"bodyFat\">\n                    <label for=\"waistCircumference\">Waist circumference</label>\n                    <input type=\"number\" step=\"any\" class=\"form-control\" id=\"waistCircumference\"\n                           [(ngModel)]=\"param.waistCircumference\" name=\"waistCircumference\">\n                    <label>BMI: {{ param.weight / (param.length / 100.0 * param.length / 100.0) | number:'1.0-0' }}</label>\n                  </ng-template>\n                </ngb-panel>\n              </div>\n              <ngb-panel title={{selectToday()}}>\n                <ng-template ngbPanelContent>\n                  <label for=\"nLength\">Length</label>\n                  <input type=\"number\" class=\"form-control\" id=\"nLength\"\n                         [(ngModel)]=\"param.length\" name=\"nLength\">\n                  <label for=\"weight\">weight</label>\n                  <input type=\"number\" step=\"any\" class=\"form-control\" id=\"nWeight\"\n                         [(ngModel)]=\"param.weight\" name=\"nWeight\">\n                  <label for=\"nBodyFat\">Body fat</label>\n                  <input type=\"number\" step=\"any\" class=\"form-control\" id=\"nBodyFat\"\n                         [(ngModel)]=\"param.bodyFat\" name=\"nBodyFat\">\n                  <label for=\"nWaistCircumference\">Waist circumference</label>\n                  <input type=\"number\" step=\"any\" class=\"form-control\" id=\"nWaistCircumference\"\n                         [(ngModel)]=\"param.waistCircumference\" name=\"nWaistCircumference\">\n                  <button class=\"btn btn-outline-primary\" (click)=\"addParam()\">Add</button>\n                </ng-template>\n              </ngb-panel>\n            </ngb-accordion>\n        </div>\n      </div>\n    </div>\n    <div class=\"col-md-4\">\n      <div class=\"card\">\n        <h4 class=\"card-header\">Extra info</h4>\n        <div class=\"card-body\">\n          <div class=\"form-group\">\n            <label for=\"extraInfo\">Extra Info</label>\n            <textarea type=\"text\" class=\"form-control\" id=\"extraInfo\" rows=\"15\"\n                      [(ngModel)]=\"patient.extraInfo\" name=\"extraInfo\"></textarea>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n  <div class=\"row\">\n    <button type=\"button\" class=\"btn btn-secondary\" (click)=\"goBack(content)\">Return</button>\n    <button type=\"button\" class=\"btn btn-success\" (click)=\"save()\">\n      Save <span class=\"badge badge-pill badge-danger\" *ngIf=\"isPatientModified()\">*</span>\n    </button>\n  </div>\n</div>\n\n<ng-template #content let-c=\"close\" let-d=\"dismiss\">\n  <div class=\"modal-header\">\n    <h4 class=\"modal-title\">Attention</h4>\n    <button type=\"button\" class=\"close\" aria-label=\"Close\" (click)=\"d('Cross click')\">\n      <span aria-hidden=\"true\">&times;</span>\n    </button>\n  </div>\n  <div class=\"modal-body\">\n    <p>Patient data has been modified without saving it</p>\n  </div>\n  <div class=\"modal-footer\">\n    <button type=\"button\" class=\"btn btn-outline-dark\" (click)=\"c('Cancel')\">Cancel</button>\n    <button type=\"button\" class=\"btn btn-outline-dark\" (click)=\"c('Return')\">Return anyway</button>\n  </div>\n</ng-template>\n"

/***/ }),

/***/ "../../../../../src/app/diet/detail-patient/detail-patient.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DetailPatientComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ng_bootstrap_ng_bootstrap__ = __webpack_require__("../../../../@ng-bootstrap/ng-bootstrap/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__model_patient__ = __webpack_require__("../../../../../src/app/model/patient.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__model_anthropometricParameter__ = __webpack_require__("../../../../../src/app/model/anthropometricParameter.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__model_gender__ = __webpack_require__("../../../../../src/app/model/gender.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__service_diet_service__ = __webpack_require__("../../../../../src/app/diet/service/diet.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_util__ = __webpack_require__("../../../../util/util.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_util___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_util__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_lodash__ = __webpack_require__("../../../../lodash/lodash.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_lodash___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_9_lodash__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_moment__ = __webpack_require__("../../../../moment/moment.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_moment___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_moment__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__service_shared_service__ = __webpack_require__("../../../../../src/app/diet/service/shared.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12_rxjs_Subscription__ = __webpack_require__("../../../../rxjs/_esm5/Subscription.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};













var now = new Date();
var DetailPatientComponent = (function () {
    function DetailPatientComponent(dietService, sharedService, route, location, modalService) {
        this.dietService = dietService;
        this.sharedService = sharedService;
        this.route = route;
        this.location = location;
        this.modalService = modalService;
        this.subscriptions = new __WEBPACK_IMPORTED_MODULE_12_rxjs_Subscription__["a" /* Subscription */]();
        this.isAddPatient = false;
        this.isAddressCollapsed = true;
        this.genders = this.enumSelector(__WEBPACK_IMPORTED_MODULE_5__model_gender__["a" /* Gender */]);
        this.alerts = [];
        this.alertCounter = 0;
    }
    DetailPatientComponent.prototype.ngOnInit = function () {
        if (this.location.path().indexOf('detail') >= 0) {
            this.initDetailPatient();
        }
        else if (this.location.path().indexOf('add') >= 0) {
            this.initAddPatient();
        }
    };
    DetailPatientComponent.prototype.initAddPatient = function () {
        this.param = new __WEBPACK_IMPORTED_MODULE_4__model_anthropometricParameter__["a" /* AnthropometricParameter */]();
        this.patient = new __WEBPACK_IMPORTED_MODULE_3__model_patient__["a" /* Patient */]();
        this.isAddPatient = true;
    };
    DetailPatientComponent.prototype.initDetailPatient = function () {
        var _this = this;
        var id = +this.route.snapshot.paramMap.get('id');
        //If the request is by id
        if (id != 0) {
            this.subscriptions.add(this.dietService.getPatient(id).subscribe(function (data) {
                if (!Object(__WEBPACK_IMPORTED_MODULE_8_util__["isNullOrUndefined"])(data)) {
                    _this.patient = data;
                    _this.initDateModel();
                    _this.initPatientBackup();
                }
            }));
        }
        else {
            //If the request is by shared context
            this.subscriptions.add(this.sharedService.patient$.subscribe(function (data) {
                _this.patient = data;
            }));
        }
        if (!Object(__WEBPACK_IMPORTED_MODULE_8_util__["isNullOrUndefined"])(this.patient)) {
            this.param = new __WEBPACK_IMPORTED_MODULE_4__model_anthropometricParameter__["a" /* AnthropometricParameter */]();
            this.initDateModel();
            this.initPatientBackup();
        }
    };
    DetailPatientComponent.prototype.initDateModel = function () {
        this.model = { day: this.patient.birthday.getUTCDate(), month: this.patient.birthday.getUTCMonth() + 1,
            year: this.patient.birthday.getUTCFullYear() };
    };
    DetailPatientComponent.prototype.initPatientBackup = function () {
        //Copy patient for ui approvement (is patient modified)
        this.copyPatient = __WEBPACK_IMPORTED_MODULE_9_lodash__["cloneDeep"](this.patient);
    };
    DetailPatientComponent.prototype.enumSelector = function (definition) {
        return Object.keys(definition)
            .map(function (key) { return ({ value: definition[key], title: key }); });
    };
    DetailPatientComponent.prototype.selectToday = function () {
        return "Today: " + now.getUTCFullYear() + "-" + (now.getUTCMonth() + 1) + "-" + now.getUTCDate();
    };
    DetailPatientComponent.prototype.getFormattedDate = function (date) {
        return __WEBPACK_IMPORTED_MODULE_10_moment__(date).format("DD/MM/YYYY");
    };
    DetailPatientComponent.prototype.isPatientModified = function () {
        return !__WEBPACK_IMPORTED_MODULE_9_lodash__["isEqual"](this.copyPatient, this.patient);
    };
    DetailPatientComponent.prototype.addParam = function () {
        this.param.date = now;
        this.param.id = undefined;
        this.param.patientId = this.patient.id;
        this.patient.anthropometricParameters.push(this.param);
        this.param = new __WEBPACK_IMPORTED_MODULE_4__model_anthropometricParameter__["a" /* AnthropometricParameter */]();
    };
    DetailPatientComponent.prototype.birthdayChange = function () {
        this.patient.birthday.setUTCFullYear(this.model.year, this.model.month - 1, this.model.day);
    };
    DetailPatientComponent.prototype.goBack = function (content) {
        var _this = this;
        if (this.isPatientModified()) {
            this.modalService.open(content).result.then(function (result) {
                if (result === 'Cancel') {
                    console.log('Stay here');
                }
                else if (result === 'Return') {
                    //Restore patient like it was before
                    __WEBPACK_IMPORTED_MODULE_9_lodash__["merge"](_this.patient, _this.copyPatient);
                    //Go back
                    _this.location.back();
                }
            });
        }
        else {
            this.location.back();
        }
    };
    DetailPatientComponent.prototype.closeAlert = function (alert) {
        var index = this.alerts.indexOf(alert);
        this.alerts.splice(index, 1);
    };
    DetailPatientComponent.prototype.closeAlertWithId = function (id) {
        var alert = this.alerts.find(function (a) { return a.id == id; });
        var index = this.alerts.indexOf(alert);
        this.alerts.splice(index, 1);
    };
    DetailPatientComponent.prototype.save = function () {
        var _this = this;
        this.alerts.push({ id: this.alertCounter, type: 'secondary', message: 'Saving ' + this.patient.firstName });
        setTimeout(function (index) {
            _this.closeAlertWithId(index);
        }, 1500, this.alertCounter++);
        console.log(this.patient);
        this.dietService.savePatient(this.patient).subscribe(function (data) {
            if (_this.isAddPatient) {
                _this.patient = __WEBPACK_IMPORTED_MODULE_9_lodash__["merge"](_this.patient, data);
                _this.subscriptions.add(_this.sharedService.dietetist$.subscribe(function (data) {
                    if (!Object(__WEBPACK_IMPORTED_MODULE_8_util__["isNullOrUndefined"])(data)) {
                        data.patients.push(_this.patient);
                    }
                }));
                _this.isAddPatient = false;
            }
            else {
                //Patient is saved
            }
            _this.initPatientBackup();
            _this.alerts.push({ id: _this.alertCounter, type: 'success', message: 'Saved ' + _this.patient.firstName });
            setTimeout(function (index) {
                _this.closeAlertWithId(index);
            }, 1500, _this.alertCounter++);
        }, function (err) {
            console.log("Error");
            console.log(err);
            _this.alerts.push({ id: _this.alertCounter, type: 'danger', message: 'Error cannot save ' + _this.patient.firstName });
            setTimeout(function (index) {
                _this.closeAlertWithId(index);
            }, 1500, _this.alertCounter++);
        });
    };
    DetailPatientComponent.prototype.ngOnDestroy = function () {
        this.subscriptions.unsubscribe();
    };
    DetailPatientComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-detail-patient',
            template: __webpack_require__("../../../../../src/app/diet/detail-patient/detail-patient.component.html"),
            styles: [__webpack_require__("../../../../../src/app/diet/detail-patient/detail-patient.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_6__service_diet_service__["a" /* DietService */],
            __WEBPACK_IMPORTED_MODULE_11__service_shared_service__["a" /* SharedService */],
            __WEBPACK_IMPORTED_MODULE_7__angular_router__["a" /* ActivatedRoute */],
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["Location"],
            __WEBPACK_IMPORTED_MODULE_2__ng_bootstrap_ng_bootstrap__["a" /* NgbModal */]])
    ], DetailPatientComponent);
    return DetailPatientComponent;
}());



/***/ }),

/***/ "../../../../../src/app/diet/diet-dashboard/diet-dashboard.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "#dashboard {\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/diet/diet-dashboard/diet-dashboard.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\" *ngIf=\"diet\">\n  <h2 class=\"text-center\">Dashboard of {{diet.firstName + ' ' + diet.lastName}}</h2>\n</div>\n<div class=\"container\" *ngIf=\"selectedPatient\">\n  <div class=\"row\">\n    <p>Patient selected: {{selectedPatient.firstName}}</p>\n    <p>Created at {{selectedPatient.created | date:\"dd/MM/yyyy\" }}</p>\n    <p>{{getAge()}} Years old</p>\n  </div>\n  <div id=\"paramChart\" class=\"row\" *ngIf=\"selectedPatient.anthropometricParameters.length > 0\">\n    <div>\n      <canvas baseChart\n              [datasets]=\"barChartData\"\n              [labels]=\"barChartLabels\"\n              [options]=\"barChartOptions\"\n              [legend]=\"barChartLegend\"\n              [chartType]=\"barChartType\"></canvas>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/diet/diet-dashboard/diet-dashboard.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DietDashboardComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service_shared_service__ = __webpack_require__("../../../../../src/app/diet/service/shared.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Subscription__ = __webpack_require__("../../../../rxjs/_esm5/Subscription.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_moment__ = __webpack_require__("../../../../moment/moment.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_moment___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_moment__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_util__ = __webpack_require__("../../../../util/util.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_util___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_util__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var DietDashboardComponent = (function () {
    function DietDashboardComponent(sharedService) {
        this.sharedService = sharedService;
        this.subscriptions = new __WEBPACK_IMPORTED_MODULE_2_rxjs_Subscription__["a" /* Subscription */]();
        this.barChartOptions = {
            scaleShowVerticalLines: false,
            responsive: true
        };
        this.barChartLabels = ["Length", "Weight"];
        this.barChartType = 'bar';
        this.barChartLegend = true;
        this.barChartData = [
            { data: [180, 95], label: '12 Nov 2017' },
            { data: [181, 90], label: '12 Dec 2017' }
        ];
    }
    DietDashboardComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.subscriptions.add(this.sharedService.dietetist$.subscribe(function (data) {
            _this.diet = data;
        }));
        this.subscriptions.add(this.sharedService.patient$.subscribe(function (data) {
            if (!Object(__WEBPACK_IMPORTED_MODULE_4_util__["isNullOrUndefined"])(data)) {
                _this.selectedPatient = data;
                /*let clone = _.clone(this.barChartData);
                console.log(this.barChartData);
                console.log(clone);
                let values = [];*/
                //this.barChartData.splice(0, this.barChartData.length);
                //this.barChartLabels.splice(0, this.barChartLabels.length);
                for (var _i = 0, _a = _this.selectedPatient.anthropometricParameters; _i < _a.length; _i++) {
                    var param = _a[_i];
                    //values.push({data:[param.length, param.weight],
                    //label:moment(param.date).format("DD/MM/YYYY")});
                }
                /*let clone = JSON.parse(JSON.stringify(this.barChartData));
                for(var row of clone) {
      
                }
                clone[0].data = values[0].data;
                clone[0].label = values[0].label;
                this.barChartData = clone;*/
            }
        }));
    };
    DietDashboardComponent.prototype.ngOnDestroy = function () {
        this.subscriptions.unsubscribe();
    };
    DietDashboardComponent.prototype.getAge = function () {
        return __WEBPACK_IMPORTED_MODULE_3_moment__().diff(this.selectedPatient.birthday, 'years', false);
    };
    DietDashboardComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-diet-dashboard',
            template: __webpack_require__("../../../../../src/app/diet/diet-dashboard/diet-dashboard.component.html"),
            styles: [__webpack_require__("../../../../../src/app/diet/diet-dashboard/diet-dashboard.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__service_shared_service__["a" /* SharedService */]])
    ], DietDashboardComponent);
    return DietDashboardComponent;
}());



/***/ }),

/***/ "../../../../../src/app/diet/diet-routing.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DietRoutingModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__diet_dashboard_diet_dashboard_component__ = __webpack_require__("../../../../../src/app/diet/diet-dashboard/diet-dashboard.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__select_patient_select_patient_component__ = __webpack_require__("../../../../../src/app/diet/select-patient/select-patient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__ = __webpack_require__("../../../../../src/app/guard/diet-guard-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__detail_patient_detail_patient_component__ = __webpack_require__("../../../../../src/app/diet/detail-patient/detail-patient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__diet_component__ = __webpack_require__("../../../../../src/app/diet/diet.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};







var dietRoutes = [
    {
        path: 'diet',
        component: __WEBPACK_IMPORTED_MODULE_6__diet_component__["a" /* DietComponent */],
        canActivate: [__WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__["a" /* DietGuardServiceService */]],
        children: [
            { path: '', component: __WEBPACK_IMPORTED_MODULE_2__diet_dashboard_diet_dashboard_component__["a" /* DietDashboardComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__["a" /* DietGuardServiceService */]] },
            { path: 'dashboard', component: __WEBPACK_IMPORTED_MODULE_2__diet_dashboard_diet_dashboard_component__["a" /* DietDashboardComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__["a" /* DietGuardServiceService */]] },
            { path: 'select-patient', component: __WEBPACK_IMPORTED_MODULE_3__select_patient_select_patient_component__["a" /* SelectPatientComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__["a" /* DietGuardServiceService */]] },
            { path: 'detail-patient', component: __WEBPACK_IMPORTED_MODULE_5__detail_patient_detail_patient_component__["a" /* DetailPatientComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__["a" /* DietGuardServiceService */]] },
            { path: 'detail-patient/:id', component: __WEBPACK_IMPORTED_MODULE_5__detail_patient_detail_patient_component__["a" /* DetailPatientComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__["a" /* DietGuardServiceService */]] },
            { path: 'add-patient', component: __WEBPACK_IMPORTED_MODULE_5__detail_patient_detail_patient_component__["a" /* DetailPatientComponent */], canActivate: [__WEBPACK_IMPORTED_MODULE_4__guard_diet_guard_service_service__["a" /* DietGuardServiceService */]] },
        ]
    }
];
var DietRoutingModule = (function () {
    function DietRoutingModule() {
    }
    DietRoutingModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */].forChild(dietRoutes)
            ],
            exports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_router__["c" /* RouterModule */]
            ]
        })
    ], DietRoutingModule);
    return DietRoutingModule;
}());



/***/ }),

/***/ "../../../../../src/app/diet/diet.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/diet/diet.component.html":
/***/ (function(module, exports) {

module.exports = "<ng-sidebar-container style=\"height: 100vh;\">\n  <ng-sidebar\n    [(opened)]=\"_opened\"\n    mode=\"push\"\n    autoCollapseWidth=500>\n    <app-navbar [navItems]=\"navItems\" (navItemClicked)=\"navItemClicked($event)\"></app-navbar>\n  </ng-sidebar>\n  <div ng-sidebar-content>\n    <button class=\"btn btn-secondary\" (click)=\"_toggleSidebar()\"><i class=\"fa fa-bars\" aria-hidden=\"true\"></i></button>\n    <router-outlet></router-outlet>\n  </div>\n</ng-sidebar-container>\n\n"

/***/ }),

/***/ "../../../../../src/app/diet/diet.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DietComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_add_operator_switchMap__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/switchMap.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__service_diet_service__ = __webpack_require__("../../../../../src/app/diet/service/diet.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_util__ = __webpack_require__("../../../../util/util.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_util___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_util__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__service_shared_service__ = __webpack_require__("../../../../../src/app/diet/service/shared.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};








var DietComponent = (function () {
    function DietComponent(authService, dietService, sharedService, router, route) {
        this.authService = authService;
        this.dietService = dietService;
        this.sharedService = sharedService;
        this.router = router;
        this.route = route;
        this._opened = true;
        this.foodItemItem = { img: "../../assets/img/food.ico", title: "Food overview", routerLink: "/diet/food" };
        this.aboutPatientItem = { img: "../../assets/img/about.ico", title: "About Patient", routerLink: "/diet/detail-patient" };
        this.selectPatientItem = { img: "../../assets/img/select-patient.png", title: "Select Patient", routerLink: "/diet/select-patient" };
        this.dashboardItem = { img: "../../assets/img/dashboard.png", title: "Dashboard", routerLink: "/diet/dashboard" };
        this.navItems = new Array();
    }
    DietComponent.prototype.ngOnInit = function () {
        this.initDiet();
        this.initPatient();
        this.initNavItems();
    };
    DietComponent.prototype.initPatient = function () {
        var _this = this;
        this.patient$ = this.route.paramMap
            .switchMap(function (params) {
            _this.patientId = +params.get("patientId");
            return _this.dietService.getPatient(_this.patientId);
        });
        this.patient$.subscribe(function (data) {
            if (!Object(__WEBPACK_IMPORTED_MODULE_5_util__["isNullOrUndefined"])(data)) {
                var index = _this.navItems.indexOf(_this.aboutPatientItem);
                if (index <= 0)
                    _this.navItems.push(_this.aboutPatientItem);
                _this.selectedPatient = data;
                _this.sharedService.setPatient(_this.selectedPatient);
                console.log("Getting data: ", data);
            }
            else {
                console.log("Error with data: ", data);
            }
        }, function (err) {
            console.log(err);
            if (err instanceof __WEBPACK_IMPORTED_MODULE_7__angular_common_http__["d" /* HttpErrorResponse */]) {
                console.log("Httperror");
            }
            else {
                console.log("Not a httperror");
            }
        });
    };
    DietComponent.prototype.initDiet = function () {
        var _this = this;
        this.dietService.getConnectedUser().subscribe(function (data) {
            _this.diet = data;
            _this.sharedService.setDietetist(data);
        }, function (err) { console.log("Error trying to get the connected user"); });
    };
    DietComponent.prototype.initNavItems = function () {
        this.navItems.push(this.dashboardItem);
        this.navItems.push(this.foodItemItem);
        this.navItems.push(this.selectPatientItem);
    };
    DietComponent.prototype._toggleSidebar = function () {
        this._opened = !this._opened;
    };
    DietComponent.prototype.navItemClicked = function (item) {
        console.log("Navigate to %s", item.routerLink);
        this.router.navigate([item.routerLink]);
    };
    DietComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-diet',
            template: __webpack_require__("../../../../../src/app/diet/diet.component.html"),
            styles: [__webpack_require__("../../../../../src/app/diet/diet.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__services_authentication_service__["a" /* AuthenticationService */],
            __WEBPACK_IMPORTED_MODULE_4__service_diet_service__["a" /* DietService */],
            __WEBPACK_IMPORTED_MODULE_6__service_shared_service__["a" /* SharedService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */]])
    ], DietComponent);
    return DietComponent;
}());



/***/ }),

/***/ "../../../../../src/app/diet/diet.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DietModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__ng_bootstrap_ng_bootstrap__ = __webpack_require__("../../../../@ng-bootstrap/ng-bootstrap/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common__ = __webpack_require__("../../../common/esm5/common.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_ng_sidebar__ = __webpack_require__("../../../../ng-sidebar/lib/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_ng_sidebar___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_ng_sidebar__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__service_diet_service__ = __webpack_require__("../../../../../src/app/diet/service/diet.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__service_shared_service__ = __webpack_require__("../../../../../src/app/diet/service/shared.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__detail_patient_detail_patient_component__ = __webpack_require__("../../../../../src/app/diet/detail-patient/detail-patient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__diet_dashboard_diet_dashboard_component__ = __webpack_require__("../../../../../src/app/diet/diet-dashboard/diet-dashboard.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__select_patient_select_patient_component__ = __webpack_require__("../../../../../src/app/diet/select-patient/select-patient.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__guard_diet_guard_service_service__ = __webpack_require__("../../../../../src/app/guard/diet-guard-service.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__diet_routing_module__ = __webpack_require__("../../../../../src/app/diet/diet-routing.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__share_PatientFilterPipe__ = __webpack_require__("../../../../../src/app/share/PatientFilterPipe.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__navbar_navbar_component__ = __webpack_require__("../../../../../src/app/navbar/navbar.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__diet_component__ = __webpack_require__("../../../../../src/app/diet/diet.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_ng2_charts__ = __webpack_require__("../../../../ng2-charts/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15_ng2_charts___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_15_ng2_charts__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















var DietModule = (function () {
    function DietModule() {
    }
    DietModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"])({
            imports: [
                __WEBPACK_IMPORTED_MODULE_2__angular_common__["CommonModule"],
                __WEBPACK_IMPORTED_MODULE_3__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_1__ng_bootstrap_ng_bootstrap__["b" /* NgbModule */],
                __WEBPACK_IMPORTED_MODULE_11__diet_routing_module__["a" /* DietRoutingModule */],
                __WEBPACK_IMPORTED_MODULE_4_ng_sidebar__["SidebarModule"].forRoot(),
                __WEBPACK_IMPORTED_MODULE_15_ng2_charts__["ChartsModule"]
            ],
            declarations: [
                __WEBPACK_IMPORTED_MODULE_8__diet_dashboard_diet_dashboard_component__["a" /* DietDashboardComponent */],
                __WEBPACK_IMPORTED_MODULE_7__detail_patient_detail_patient_component__["a" /* DetailPatientComponent */],
                __WEBPACK_IMPORTED_MODULE_9__select_patient_select_patient_component__["a" /* SelectPatientComponent */],
                __WEBPACK_IMPORTED_MODULE_12__share_PatientFilterPipe__["a" /* PatientFilterPipe */],
                __WEBPACK_IMPORTED_MODULE_13__navbar_navbar_component__["a" /* NavbarComponent */],
                __WEBPACK_IMPORTED_MODULE_14__diet_component__["a" /* DietComponent */]
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_5__service_diet_service__["a" /* DietService */], __WEBPACK_IMPORTED_MODULE_10__guard_diet_guard_service_service__["a" /* DietGuardServiceService */], __WEBPACK_IMPORTED_MODULE_6__service_shared_service__["a" /* SharedService */]]
        })
    ], DietModule);
    return DietModule;
}());



/***/ }),

/***/ "../../../../../src/app/diet/select-patient/select-patient.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".jumbotron {\n  width: 50%;\n  margin: auto;\n  min-width: 450px;\n}\n\n.patient-holder {\n}\n\n@media (max-width: 768px) {\n  .jumbotron {\n    width: 100%;\n    min-width: 50%;\n  }\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/diet/select-patient/select-patient.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"jumbotron\">\n  <h4 class=\"display-4\">Select a patient</h4>\n\n  <label for=\"search\">Search for a patient:</label>\n  <input id=\"search\" type=\"text\" name=\"search\" [(ngModel)]=\"filter\" placeholder=\"name\" class=\"form-control\"/>\n\n  <hr class=\"my-4\">\n\n  <div *ngIf=\"patients\" >\n    <ul class=\"list-group list-group-flush\" >\n        <li class=\"list-group-item patient-holder \" *ngFor=\"let patient of\n        (patients.slice((this.currentPage-1) * this.patientsPerPage, this.currentPage * this.patientsPerPage))\n        | patientfilter:filter\" (click)=\"switch(patient)\"\n            [class.active]=\"(selectedPatient ? selectedPatient.id : 0) === patient.id\">\n          {{patient.firstName + ' ' + patient.lastName}}\n        </li>\n    </ul>\n\n    <div>Pages</div>\n    <ngb-pagination [pageSize]=\"patientsPerPage\" [collectionSize]=\"(patients | patientfilter:filter).length\"\n                    [(page)]=\"currentPage\" aria-label=\"Default pagination\"></ngb-pagination>\n  </div>\n\n  <hr class=\"my-4\">\n  <button type=\"button\" class=\"btn btn-secondary float-left\" (click)=\"newPatient()\">Add new Patient</button>\n  <button type=\"button\" class=\"btn btn-primary float-right\" (click)=\"select()\"\n          [disabled]=\"!selectedPatient\">Select</button>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/diet/select-patient/select-patient.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SelectPatientComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_util__ = __webpack_require__("../../../../util/util.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_util___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_util__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__service_shared_service__ = __webpack_require__("../../../../../src/app/diet/service/shared.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Subscription__ = __webpack_require__("../../../../rxjs/_esm5/Subscription.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var SelectPatientComponent = (function () {
    function SelectPatientComponent(sharedService, router) {
        this.sharedService = sharedService;
        this.router = router;
        this.subscriptions = new __WEBPACK_IMPORTED_MODULE_4_rxjs_Subscription__["a" /* Subscription */]();
        this.filter = new String();
        this.currentPage = 1;
        this.patientsPerPage = 5;
    }
    SelectPatientComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.subscriptions.add(this.sharedService.dietetist$.subscribe(function (data) {
            if (!Object(__WEBPACK_IMPORTED_MODULE_1_util__["isNullOrUndefined"])(data)) {
                _this.patients = data.patients;
            }
        }));
        this.subscriptions.add(this.sharedService.patient$.subscribe(function (data) {
            _this.selectedPatient = data;
        }));
    };
    SelectPatientComponent.prototype.select = function () {
        this.router.navigate(['diet', { patientId: this.selectedPatient.id }]);
    };
    SelectPatientComponent.prototype.newPatient = function () {
        this.router.navigate(['diet/add-patient']);
    };
    SelectPatientComponent.prototype.ngOnDestroy = function () {
        console.log("Unsubscribe from select");
        this.subscriptions.unsubscribe();
    };
    SelectPatientComponent.prototype.switch = function (patient) {
        this.selectedPatient = patient;
    };
    SelectPatientComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-select-patient',
            template: __webpack_require__("../../../../../src/app/diet/select-patient/select-patient.component.html"),
            styles: [__webpack_require__("../../../../../src/app/diet/select-patient/select-patient.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_3__service_shared_service__["a" /* SharedService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */]])
    ], SelectPatientComponent);
    return SelectPatientComponent;
}());



/***/ }),

/***/ "../../../../../src/app/diet/service/diet.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DietService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__auth0_angular_jwt__ = __webpack_require__("../../../../@auth0/angular-jwt/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_observable_of__ = __webpack_require__("../../../../rxjs/_esm5/observable/of.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_operators__ = __webpack_require__("../../../../rxjs/_esm5/operators.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["e" /* HttpHeaders */]({ 'Content-Type': 'application/json' })
};
var DietService = (function () {
    function DietService(http, jwtHelper) {
        this.http = http;
        this.jwtHelper = jwtHelper;
        this.patientUrl = "api/patient/";
        this.patientByDietUrl = "api/patient/dietetist/";
        this.connectedUserUrl = "api/auth/connecteduser";
        this._token = JSON.parse(localStorage.getItem("token"));
    }
    DietService.prototype.getConnectedUser = function () {
        return this.http.get(this.connectedUserUrl, httpOptions);
    };
    DietService.prototype.getPatientsOfDiet = function (id) {
        return this.http.get(this.patientByDietUrl + id, httpOptions);
    };
    //Need to catch the error because diet.component used a route param for the selected patient
    //this id can be 0 so if we don't catch it it will crash the web app
    DietService.prototype.getPatient = function (id) {
        return this.http.get(this.patientUrl + id, httpOptions).pipe(Object(__WEBPACK_IMPORTED_MODULE_4_rxjs_operators__["a" /* catchError */])(this.handleError('getPatient')));
        //return this.http.get<Patient>(this.patientUrl + id, httpOptions);
    };
    DietService.prototype.savePatient = function (patient) {
        return this.http.post(this.patientUrl, patient, httpOptions);
    };
    Object.defineProperty(DietService.prototype, "token", {
        get: function () {
            return this._token;
        },
        enumerable: true,
        configurable: true
    });
    /**
     * https://angular.io/tutorial/toh-pt6
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    DietService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            // TODO: send the error to remote logging infrastructure
            console.error(error); // log to console instead
            // Let the app keep running by returning an empty result.
            return Object(__WEBPACK_IMPORTED_MODULE_3_rxjs_observable_of__["a" /* of */])(result);
        };
    };
    DietService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_2__auth0_angular_jwt__["a" /* JwtHelperService */]])
    ], DietService);
    return DietService;
}());



/***/ }),

/***/ "../../../../../src/app/diet/service/shared.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SharedService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_BehaviorSubject__ = __webpack_require__("../../../../rxjs/_esm5/BehaviorSubject.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var SharedService = (function () {
    function SharedService() {
        this.dietetist = new __WEBPACK_IMPORTED_MODULE_1_rxjs_BehaviorSubject__["a" /* BehaviorSubject */](null);
        this.dietetist$ = this.dietetist.asObservable();
        this.patient = new __WEBPACK_IMPORTED_MODULE_1_rxjs_BehaviorSubject__["a" /* BehaviorSubject */](null);
        this.patient$ = this.patient.asObservable();
    }
    SharedService.prototype.setDietetist = function (diet) {
        this.dietetist.next(diet);
    };
    SharedService.prototype.setPatient = function (patient) {
        this.patient.next(patient);
    };
    SharedService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [])
    ], SharedService);
    return SharedService;
}());



/***/ }),

/***/ "../../../../../src/app/guard/admin-guard-service.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AdminGuardServiceService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__model_role_enum__ = __webpack_require__("../../../../../src/app/model/role.enum.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Observable__ = __webpack_require__("../../../../rxjs/_esm5/Observable.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AdminGuardServiceService = (function () {
    function AdminGuardServiceService(authService, router) {
        this.authService = authService;
        this.router = router;
    }
    AdminGuardServiceService.prototype.canActivate = function (route, state) {
        var _this = this;
        //Not authenticated return false and go to login
        if (!this.authService.isAuthenticated()) {
            this.router.navigate(['/login'], {
                queryParams: {
                    ret: state.url
                }
            });
            return false;
        }
        else {
            //Else we need to check the permission
            return new __WEBPACK_IMPORTED_MODULE_4_rxjs_Observable__["a" /* Observable */](function (observer) {
                _this.authService.getRole().subscribe(function (data) {
                    var access = data == __WEBPACK_IMPORTED_MODULE_3__model_role_enum__["a" /* Role */].ADMIN;
                    observer.next(access);
                    if (!access) {
                        _this.router.navigate(['/login'], {
                            queryParams: {
                                ret: state.url
                            }
                        });
                    }
                    observer.complete();
                }, function (err) {
                    observer.error(err);
                });
            });
        }
    };
    AdminGuardServiceService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__services_authentication_service__["a" /* AuthenticationService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], AdminGuardServiceService);
    return AdminGuardServiceService;
}());



/***/ }),

/***/ "../../../../../src/app/guard/diet-guard-service.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DietGuardServiceService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__model_role_enum__ = __webpack_require__("../../../../../src/app/model/role.enum.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Observable__ = __webpack_require__("../../../../rxjs/_esm5/Observable.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var DietGuardServiceService = (function () {
    function DietGuardServiceService(authService, router) {
        this.authService = authService;
        this.router = router;
    }
    DietGuardServiceService.prototype.canActivate = function (route, state) {
        var _this = this;
        //Not authenticated return false and go to login
        if (!this.authService.isAuthenticated()) {
            this.router.navigate(['/login'], {
                queryParams: {
                    ret: state.url
                }
            });
            return false;
        }
        else {
            //Else we need to check the permission
            return new __WEBPACK_IMPORTED_MODULE_4_rxjs_Observable__["a" /* Observable */](function (observer) {
                _this.authService.getRole().subscribe(function (data) {
                    var access = data == __WEBPACK_IMPORTED_MODULE_3__model_role_enum__["a" /* Role */].DIET;
                    observer.next(access);
                    if (!access) {
                        _this.router.navigate(['/login'], {
                            queryParams: {
                                ret: state.url
                            }
                        });
                    }
                    observer.complete();
                }, function (err) {
                    observer.error(err);
                });
            });
        }
    };
    DietGuardServiceService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__services_authentication_service__["a" /* AuthenticationService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], DietGuardServiceService);
    return DietGuardServiceService;
}());



/***/ }),

/***/ "../../../../../src/app/guard/patient-guard-service.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PatientGuardServiceService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__model_role_enum__ = __webpack_require__("../../../../../src/app/model/role.enum.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_Observable__ = __webpack_require__("../../../../rxjs/_esm5/Observable.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var PatientGuardServiceService = (function () {
    function PatientGuardServiceService(authService, router) {
        this.authService = authService;
        this.router = router;
    }
    PatientGuardServiceService.prototype.canActivate = function (route, state) {
        var _this = this;
        //Not authenticated return false and go to login
        if (!this.authService.isAuthenticated()) {
            this.router.navigate(['/login'], {
                queryParams: {
                    ret: state.url
                }
            });
            return false;
        }
        else {
            //Else we need to check the permission
            return new __WEBPACK_IMPORTED_MODULE_4_rxjs_Observable__["a" /* Observable */](function (observer) {
                _this.authService.getRole().subscribe(function (data) {
                    var access = data == __WEBPACK_IMPORTED_MODULE_3__model_role_enum__["a" /* Role */].PATIENT;
                    observer.next(access);
                    if (!access) {
                        _this.router.navigate(['/login'], {
                            queryParams: {
                                ret: state.url
                            }
                        });
                    }
                    observer.complete();
                }, function (err) {
                    observer.error(err);
                });
            });
        }
    };
    PatientGuardServiceService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__services_authentication_service__["a" /* AuthenticationService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]])
    ], PatientGuardServiceService);
    return PatientGuardServiceService;
}());



/***/ }),

/***/ "../../../../../src/app/login/login.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "#form-holder {\n  max-width: 50%;\n}\n\nform {\n  border: 3px solid #f1f1f1;\n}\n\ninput[type=text], input[type=password] {\n  width: 100%;\n  padding: 12px 20px;\n  margin: 8px 0;\n  display: inline-block;\n  border: 1px solid #ccc;\n  box-sizing: border-box;\n}\n\nbutton {\n  background-color: #4CAF50;\n  color: white;\n  padding: 14px 20px;\n  margin: 8px 0;\n  border: none;\n  cursor: pointer;\n  width: 100%;\n}\n\nbutton:hover {\n  opacity: 0.8;\n}\n\n.cancelbtn {\n  width: auto;\n  padding: 10px 18px;\n  background-color: #f44336;\n}\n\n.container {\n  padding: 16px;\n}\n\nspan.psw {\n  float: right;\n  padding-top: 16px;\n}\n\n/* Change styles for span and cancel button on extra small screens */\n@media screen and (max-width: 300px) {\n  span.psw {\n    display: block;\n    float: none;\n  }\n  .cancelbtn {\n    width: 100%;\n  }\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/login/login.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\" id=\"form-holder\">\n  <form action=\"/action_page.php\">\n    <div class=\"container\">\n      <label><b>Username</b></label>\n      <input type=\"text\" [(ngModel)]=\"auth.username\" placeholder=\"Enter username\" name=\"username\" id=\"username\" required>\n\n      <label><b>Password</b></label>\n      <input type=\"password\" [(ngModel)]=\"auth.password\" placeholder=\"Enter password\" name=\"password\" id=\"password\" required>\n\n      <button type=\"submit\" (click)=\"onLogin()\">Login</button>\n      <input type=\"checkbox\" checked=\"checked\"> Remember me\n    </div>\n\n    <div class=\"container\" style=\"background-color:#f1f1f1\">\n      <button type=\"button\" class=\"cancelbtn\">Cancel</button>\n      <span class=\"psw\">Forgot <a href=\"#\">password?</a></span>\n    </div>\n\n    <div class=\"container\">\n      <div class=\"alert alert-danger\" *ngIf=\"error !== ''\">\n        <strong>{{ error }}</strong>\n      </div>\n    </div>\n  </form>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/login/login.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__model_role_enum__ = __webpack_require__("../../../../../src/app/model/role.enum.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LoginComponent = (function () {
    function LoginComponent(authService, router, route) {
        this.authService = authService;
        this.router = router;
        this.route = route;
        this.auth = {
            username: 'momo@diet.com',
            password: 'momo'
        };
        this.ret = '';
        this.error = '';
    }
    LoginComponent.prototype.ngOnInit = function () {
        var _this = this;
        //Check the return param and go to /login if nothing is set
        this.route.queryParams
            .subscribe(function (params) { return _this.ret = params['ret'] || '/login'; });
    };
    LoginComponent.prototype.onLogin = function () {
        var _this = this;
        this.authService.onLogin(this.auth).subscribe(function (role) {
            if (_this.ret === '/login') {
                switch (role) {
                    case __WEBPACK_IMPORTED_MODULE_3__model_role_enum__["a" /* Role */].PATIENT:
                        _this.router.navigateByUrl('patient/dashboard');
                        break;
                    case __WEBPACK_IMPORTED_MODULE_3__model_role_enum__["a" /* Role */].ADMIN:
                        _this.router.navigateByUrl('admin/dashboard');
                        break;
                    case __WEBPACK_IMPORTED_MODULE_3__model_role_enum__["a" /* Role */].DIET:
                        _this.router.navigateByUrl('diet/dashboard');
                        break;
                }
            }
            else {
                _this.router.navigateByUrl(_this.ret);
            }
        }, function (err) { _this.error = 'Cannot connect !'; console.log(err); });
    };
    LoginComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-login',
            template: __webpack_require__("../../../../../src/app/login/login.component.html"),
            styles: [__webpack_require__("../../../../../src/app/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__services_authentication_service__["a" /* AuthenticationService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* ActivatedRoute */]])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "../../../../../src/app/model/address.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Address; });
var Address = (function () {
    function Address() {
        this.city = "";
        this.country = "";
        this.id = 0;
        this.number = "";
        this.postcode = 0;
        this.street = "";
    }
    return Address;
}());



/***/ }),

/***/ "../../../../../src/app/model/anthropometricParameter.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AnthropometricParameter; });
var AnthropometricParameter = (function () {
    function AnthropometricParameter() {
        this.id = 0;
        this.length = 0;
        this.weight = 0;
        this.bodyFat = 0;
        this.waistCircumference = 0;
        this.date = new Date();
        this.patientId = 0;
    }
    return AnthropometricParameter;
}());



/***/ }),

/***/ "../../../../../src/app/model/gender.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Gender; });
var Gender;
(function (Gender) {
    Gender["MALE"] = "MALE";
    Gender["FEMALE"] = "FEMALE";
    Gender["OTHER"] = "OTHER";
})(Gender || (Gender = {}));


/***/ }),

/***/ "../../../../../src/app/model/patient.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Patient; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__gender__ = __webpack_require__("../../../../../src/app/model/gender.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__address__ = __webpack_require__("../../../../../src/app/model/address.ts");


var Patient = (function () {
    function Patient() {
        this.authId = "";
        this.birthday = new Date();
        this.created = new Date();
        this.email = "";
        this.extraInfo = "";
        this.firstName = "";
        this.gender = __WEBPACK_IMPORTED_MODULE_0__gender__["a" /* Gender */].OTHER;
        this.id = 0;
        this.lastName = "";
        this.middleName = "";
        this.phone = "";
        this.anthropometricParameters = new Array();
        this.address = new __WEBPACK_IMPORTED_MODULE_1__address__["a" /* Address */]();
        this.dietetistId = 0;
    }
    return Patient;
}());



/***/ }),

/***/ "../../../../../src/app/model/role.enum.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Role; });
var Role;
(function (Role) {
    Role["PATIENT"] = "PATIENT";
    Role["ADMIN"] = "ADMIN";
    Role["DIET"] = "DIET";
})(Role || (Role = {}));


/***/ }),

/***/ "../../../../../src/app/navbar/navbar.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "nav {\n  width: 200px;\n  height: 100vh;\n}\n\n#bottom {\n  width: 200px;\n}\n\n#logout {\n  width: 180px;\n  margin-left: 10px;\n  margin-bottom: 10px;\n}\n\nul {\n  list-style: none;\n  margin: 0;\n  padding: 0;\n}\n\na.active {\n  font-style  : italic;\n  font-weight: bold;\n}\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/navbar/navbar.component.html":
/***/ (function(module, exports) {

module.exports = "<nav class=\"p-1 bg-light\">\n  <h2 class=\"pb-4\">Diet Pro</h2>\n\n  <ul *ngIf=\"navItems\">\n    <li *ngFor=\"let item of navItems\">\n      <!-- Look for rounded images -->\n      <img src=\"{{item.img}}\" alt=\"logo\" class=\"mx-auto d-block\" width=\"50px\" height=\"50px\" (click)=\"navigate(item)\">\n      <h4 class=\"text-center\" (click)=\"navigate(item)\" placement=\"bottom\" ngbTooltip=\"{{item.routerLink}}\">\n        <a routerLink=\"{{item.routerLink}}\" routerLinkActive=\"active\">{{item.title}}</a>\n      </h4>\n\n      <hr width=\"75%\">\n    </li>\n  </ul>\n  <div class=\"fixed-bottom\" id=\"bottom\">\n    <button type=\"button\" class=\"btn btn-warning\" id=\"logout\" (click)=\"logout()\">Log out</button>\n  </div>\n</nav>\n"

/***/ }),

/***/ "../../../../../src/app/navbar/navbar.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return NavbarComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var NavbarComponent = (function () {
    function NavbarComponent(authService, router) {
        this.authService = authService;
        this.router = router;
        this.navItemClicked = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    NavbarComponent.prototype.ngOnInit = function () {
    };
    NavbarComponent.prototype.navigate = function (navItem) {
        this.navItemClicked.emit(navItem);
    };
    NavbarComponent.prototype.logout = function () {
        this.authService.onLogout();
        this.router.navigateByUrl('/login');
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"])(),
        __metadata("design:type", Array)
    ], NavbarComponent.prototype, "navItems", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"])(),
        __metadata("design:type", Object)
    ], NavbarComponent.prototype, "navItemClicked", void 0);
    NavbarComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__("../../../../../src/app/navbar/navbar.component.html"),
            styles: [__webpack_require__("../../../../../src/app/navbar/navbar.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__services_authentication_service__["a" /* AuthenticationService */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */]])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "../../../../../src/app/patient/patient-dashboard/patient-dashboard.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/patient/patient-dashboard/patient-dashboard.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\n  patient-dashboard works!\n</p>\n"

/***/ }),

/***/ "../../../../../src/app/patient/patient-dashboard/patient-dashboard.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PatientDashboardComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var PatientDashboardComponent = (function () {
    function PatientDashboardComponent() {
    }
    PatientDashboardComponent.prototype.ngOnInit = function () {
    };
    PatientDashboardComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-patient-dashboard',
            template: __webpack_require__("../../../../../src/app/patient/patient-dashboard/patient-dashboard.component.html"),
            styles: [__webpack_require__("../../../../../src/app/patient/patient-dashboard/patient-dashboard.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], PatientDashboardComponent);
    return PatientDashboardComponent;
}());



/***/ }),

/***/ "../../../../../src/app/services/authentication.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthenticationService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_Observable__ = __webpack_require__("../../../../rxjs/_esm5/Observable.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__auth0_angular_jwt__ = __webpack_require__("../../../../@auth0/angular-jwt/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_util__ = __webpack_require__("../../../../util/util.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_util___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_util__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["e" /* HttpHeaders */]({ 'Content-Type': 'application/json' })
};
var AuthenticationService = (function () {
    function AuthenticationService(http, jwtHelper) {
        this.http = http;
        this.jwtHelper = jwtHelper;
        this.idUrl = "api/auth/id";
        this.loginUrl = "api/auth/login";
        this.connectedUserUrl = "api/auth/connecteduser";
        this.roleUrl = "api/auth/role";
        this._token = JSON.parse(localStorage.getItem("token"));
    }
    AuthenticationService.prototype.onLogin = function (auth) {
        var _this = this;
        return new __WEBPACK_IMPORTED_MODULE_2_rxjs_Observable__["a" /* Observable */](function (observer) {
            _this.http.post(_this.loginUrl, auth, httpOptions).subscribe(function (data) {
                console.log("AuthService: user is logged on %s", data.access_token);
                _this._token = data;
                localStorage.setItem("token", JSON.stringify(_this._token));
                _this.initRole().subscribe(function (role) {
                    _this._role = role;
                    observer.next(_this._role);
                    observer.complete();
                }, function (err) {
                    observer.error(err);
                });
            }, function (err) {
                console.log("AuthService error in logging on - code:%s  msg:%s", err.status, err.message);
                observer.error(err);
            });
        });
    };
    AuthenticationService.prototype.onLogout = function () {
        localStorage.removeItem('token');
    };
    AuthenticationService.prototype.isAuthenticated = function () {
        if (this._token == null)
            return false;
        console.log("Expiration date of token: %s", this.jwtHelper.getTokenExpirationDate(this._token.access_token));
        return !this.jwtHelper.isTokenExpired(this._token.access_token);
    };
    AuthenticationService.prototype.getConnectedUser = function () {
        return this.http.get(this.connectedUserUrl, httpOptions);
    };
    AuthenticationService.prototype.initRole = function () {
        return this.http.get(this.roleUrl, httpOptions);
    };
    AuthenticationService.prototype.getId = function () {
        return this.http.get(this.idUrl, httpOptions);
    };
    Object.defineProperty(AuthenticationService.prototype, "id", {
        get: function () {
            return this._id;
        },
        enumerable: true,
        configurable: true
    });
    AuthenticationService.prototype.getRole = function () {
        var _this = this;
        return new __WEBPACK_IMPORTED_MODULE_2_rxjs_Observable__["a" /* Observable */](function (observer) {
            if (Object(__WEBPACK_IMPORTED_MODULE_4_util__["isNullOrUndefined"])(_this._role)) {
                _this.initRole().subscribe(function (role) {
                    _this._role = role;
                    observer.next(_this._role);
                    observer.complete();
                }, function (err) {
                    observer.error(err);
                });
            }
            else {
                observer.next(_this._role);
                observer.complete();
            }
        });
    };
    Object.defineProperty(AuthenticationService.prototype, "token", {
        get: function () {
            return this._token;
        },
        enumerable: true,
        configurable: true
    });
    AuthenticationService.prototype.getAuthorizationHeader = function () {
        return "Bearer: " + (this._token ? this._token.access_token : 0);
    };
    AuthenticationService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["b" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_3__auth0_angular_jwt__["a" /* JwtHelperService */]])
    ], AuthenticationService);
    return AuthenticationService;
}());



/***/ }),

/***/ "../../../../../src/app/share/DateInterceptor.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return DateInterceptor; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_rxjs_add_operator_do__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/do.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_catch__ = __webpack_require__("../../../../rxjs/_esm5/add/operator/catch.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__services_authentication_service__ = __webpack_require__("../../../../../src/app/services/authentication.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var DateInterceptor = (function () {
    function DateInterceptor(router, injector) {
        this.router = router;
        this.injector = injector;
        this.regexIso8601 = /^(\d{4}|\+\d{6})(?:-(\d{2})(?:-(\d{2})(?:T(\d{2}):(\d{2}):(\d{2})\.(\d{1,})(Z|([\-+])(\d{2}):(\d{2}))?)?)?)?$/;
    }
    DateInterceptor.prototype.intercept = function (req, next) {
        this.authService = this.injector.get(__WEBPACK_IMPORTED_MODULE_5__services_authentication_service__["a" /* AuthenticationService */]);
        var authHeader = this.authService.getAuthorizationHeader();
        var authReq = req.clone({ headers: req.headers.set('Authorization', authHeader) });
        return this.logAndConvertDate(authReq, next);
    };
    DateInterceptor.prototype.logAndConvertDate = function (req, next) {
        var _this = this;
        var started = Date.now();
        return next
            .handle(req)
            .do(function (event) {
            if (event instanceof __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["f" /* HttpResponse */]) {
                _this.convertDateStringsToDates(event.body);
                var elapsed = Date.now() - started;
                console.log("Request for " + req.urlWithParams + " took " + elapsed + " ms.");
            }
        });
    };
    //http://aboutcode.net/2013/07/27/json-date-parsing-angularjs.html
    DateInterceptor.prototype.convertDateStringsToDates = function (input) {
        // Ignore things that aren't objects.
        if (typeof input !== "object")
            return input;
        for (var key in input) {
            if (!input.hasOwnProperty(key))
                continue;
            var value = input[key];
            var match;
            // Check for string properties which look like dates.
            if (typeof value === "string" && (match = value.match(this.regexIso8601))) {
                var milliseconds = Date.parse(match[0]);
                if (!isNaN(milliseconds)) {
                    input[key] = new Date(milliseconds);
                }
            }
            else if (typeof value === "object") {
                // Recurse into object
                this.convertDateStringsToDates(value);
            }
        }
    };
    DateInterceptor = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_4__angular_router__["b" /* Router */],
            __WEBPACK_IMPORTED_MODULE_0__angular_core__["Injector"]])
    ], DateInterceptor);
    return DateInterceptor;
}());



/***/ }),

/***/ "../../../../../src/app/share/PatientFilterPipe.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PatientFilterPipe; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var PatientFilterPipe = (function () {
    function PatientFilterPipe() {
    }
    PatientFilterPipe.prototype.transform = function (items, filter) {
        var _this = this;
        if (!items || !filter) {
            return items;
        }
        // filter items array, items which match and return true will be kept, false will be filtered out
        return items.filter(function (item) { return _this.applyFilter(item, filter.toString()); });
    };
    PatientFilterPipe.prototype.applyFilter = function (patient, filter) {
        if (!filter)
            return true;
        var split = filter.split(' ');
        for (var _i = 0, split_1 = split; _i < split_1.length; _i++) {
            var word = split_1[_i];
            if (!word)
                continue;
            if (this.contains(patient.firstName, word) || this.contains(patient.lastName, word))
                return true;
        }
        return false;
    };
    PatientFilterPipe.prototype.contains = function (source, check) {
        return source.toLowerCase().indexOf(check) >= 0;
    };
    PatientFilterPipe = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Pipe"])({
            name: 'patientfilter',
            pure: false
        })
    ], PatientFilterPipe);
    return PatientFilterPipe;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["enableProdMode"])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ "../../../../chart.js/node_modules/moment/locale recursive ^\\.\\/.*$":
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"./af": "../../../../chart.js/node_modules/moment/locale/af.js",
	"./af.js": "../../../../chart.js/node_modules/moment/locale/af.js",
	"./ar": "../../../../chart.js/node_modules/moment/locale/ar.js",
	"./ar-dz": "../../../../chart.js/node_modules/moment/locale/ar-dz.js",
	"./ar-dz.js": "../../../../chart.js/node_modules/moment/locale/ar-dz.js",
	"./ar-kw": "../../../../chart.js/node_modules/moment/locale/ar-kw.js",
	"./ar-kw.js": "../../../../chart.js/node_modules/moment/locale/ar-kw.js",
	"./ar-ly": "../../../../chart.js/node_modules/moment/locale/ar-ly.js",
	"./ar-ly.js": "../../../../chart.js/node_modules/moment/locale/ar-ly.js",
	"./ar-ma": "../../../../chart.js/node_modules/moment/locale/ar-ma.js",
	"./ar-ma.js": "../../../../chart.js/node_modules/moment/locale/ar-ma.js",
	"./ar-sa": "../../../../chart.js/node_modules/moment/locale/ar-sa.js",
	"./ar-sa.js": "../../../../chart.js/node_modules/moment/locale/ar-sa.js",
	"./ar-tn": "../../../../chart.js/node_modules/moment/locale/ar-tn.js",
	"./ar-tn.js": "../../../../chart.js/node_modules/moment/locale/ar-tn.js",
	"./ar.js": "../../../../chart.js/node_modules/moment/locale/ar.js",
	"./az": "../../../../chart.js/node_modules/moment/locale/az.js",
	"./az.js": "../../../../chart.js/node_modules/moment/locale/az.js",
	"./be": "../../../../chart.js/node_modules/moment/locale/be.js",
	"./be.js": "../../../../chart.js/node_modules/moment/locale/be.js",
	"./bg": "../../../../chart.js/node_modules/moment/locale/bg.js",
	"./bg.js": "../../../../chart.js/node_modules/moment/locale/bg.js",
	"./bn": "../../../../chart.js/node_modules/moment/locale/bn.js",
	"./bn.js": "../../../../chart.js/node_modules/moment/locale/bn.js",
	"./bo": "../../../../chart.js/node_modules/moment/locale/bo.js",
	"./bo.js": "../../../../chart.js/node_modules/moment/locale/bo.js",
	"./br": "../../../../chart.js/node_modules/moment/locale/br.js",
	"./br.js": "../../../../chart.js/node_modules/moment/locale/br.js",
	"./bs": "../../../../chart.js/node_modules/moment/locale/bs.js",
	"./bs.js": "../../../../chart.js/node_modules/moment/locale/bs.js",
	"./ca": "../../../../chart.js/node_modules/moment/locale/ca.js",
	"./ca.js": "../../../../chart.js/node_modules/moment/locale/ca.js",
	"./cs": "../../../../chart.js/node_modules/moment/locale/cs.js",
	"./cs.js": "../../../../chart.js/node_modules/moment/locale/cs.js",
	"./cv": "../../../../chart.js/node_modules/moment/locale/cv.js",
	"./cv.js": "../../../../chart.js/node_modules/moment/locale/cv.js",
	"./cy": "../../../../chart.js/node_modules/moment/locale/cy.js",
	"./cy.js": "../../../../chart.js/node_modules/moment/locale/cy.js",
	"./da": "../../../../chart.js/node_modules/moment/locale/da.js",
	"./da.js": "../../../../chart.js/node_modules/moment/locale/da.js",
	"./de": "../../../../chart.js/node_modules/moment/locale/de.js",
	"./de-at": "../../../../chart.js/node_modules/moment/locale/de-at.js",
	"./de-at.js": "../../../../chart.js/node_modules/moment/locale/de-at.js",
	"./de-ch": "../../../../chart.js/node_modules/moment/locale/de-ch.js",
	"./de-ch.js": "../../../../chart.js/node_modules/moment/locale/de-ch.js",
	"./de.js": "../../../../chart.js/node_modules/moment/locale/de.js",
	"./dv": "../../../../chart.js/node_modules/moment/locale/dv.js",
	"./dv.js": "../../../../chart.js/node_modules/moment/locale/dv.js",
	"./el": "../../../../chart.js/node_modules/moment/locale/el.js",
	"./el.js": "../../../../chart.js/node_modules/moment/locale/el.js",
	"./en-au": "../../../../chart.js/node_modules/moment/locale/en-au.js",
	"./en-au.js": "../../../../chart.js/node_modules/moment/locale/en-au.js",
	"./en-ca": "../../../../chart.js/node_modules/moment/locale/en-ca.js",
	"./en-ca.js": "../../../../chart.js/node_modules/moment/locale/en-ca.js",
	"./en-gb": "../../../../chart.js/node_modules/moment/locale/en-gb.js",
	"./en-gb.js": "../../../../chart.js/node_modules/moment/locale/en-gb.js",
	"./en-ie": "../../../../chart.js/node_modules/moment/locale/en-ie.js",
	"./en-ie.js": "../../../../chart.js/node_modules/moment/locale/en-ie.js",
	"./en-nz": "../../../../chart.js/node_modules/moment/locale/en-nz.js",
	"./en-nz.js": "../../../../chart.js/node_modules/moment/locale/en-nz.js",
	"./eo": "../../../../chart.js/node_modules/moment/locale/eo.js",
	"./eo.js": "../../../../chart.js/node_modules/moment/locale/eo.js",
	"./es": "../../../../chart.js/node_modules/moment/locale/es.js",
	"./es-do": "../../../../chart.js/node_modules/moment/locale/es-do.js",
	"./es-do.js": "../../../../chart.js/node_modules/moment/locale/es-do.js",
	"./es.js": "../../../../chart.js/node_modules/moment/locale/es.js",
	"./et": "../../../../chart.js/node_modules/moment/locale/et.js",
	"./et.js": "../../../../chart.js/node_modules/moment/locale/et.js",
	"./eu": "../../../../chart.js/node_modules/moment/locale/eu.js",
	"./eu.js": "../../../../chart.js/node_modules/moment/locale/eu.js",
	"./fa": "../../../../chart.js/node_modules/moment/locale/fa.js",
	"./fa.js": "../../../../chart.js/node_modules/moment/locale/fa.js",
	"./fi": "../../../../chart.js/node_modules/moment/locale/fi.js",
	"./fi.js": "../../../../chart.js/node_modules/moment/locale/fi.js",
	"./fo": "../../../../chart.js/node_modules/moment/locale/fo.js",
	"./fo.js": "../../../../chart.js/node_modules/moment/locale/fo.js",
	"./fr": "../../../../chart.js/node_modules/moment/locale/fr.js",
	"./fr-ca": "../../../../chart.js/node_modules/moment/locale/fr-ca.js",
	"./fr-ca.js": "../../../../chart.js/node_modules/moment/locale/fr-ca.js",
	"./fr-ch": "../../../../chart.js/node_modules/moment/locale/fr-ch.js",
	"./fr-ch.js": "../../../../chart.js/node_modules/moment/locale/fr-ch.js",
	"./fr.js": "../../../../chart.js/node_modules/moment/locale/fr.js",
	"./fy": "../../../../chart.js/node_modules/moment/locale/fy.js",
	"./fy.js": "../../../../chart.js/node_modules/moment/locale/fy.js",
	"./gd": "../../../../chart.js/node_modules/moment/locale/gd.js",
	"./gd.js": "../../../../chart.js/node_modules/moment/locale/gd.js",
	"./gl": "../../../../chart.js/node_modules/moment/locale/gl.js",
	"./gl.js": "../../../../chart.js/node_modules/moment/locale/gl.js",
	"./gom-latn": "../../../../chart.js/node_modules/moment/locale/gom-latn.js",
	"./gom-latn.js": "../../../../chart.js/node_modules/moment/locale/gom-latn.js",
	"./he": "../../../../chart.js/node_modules/moment/locale/he.js",
	"./he.js": "../../../../chart.js/node_modules/moment/locale/he.js",
	"./hi": "../../../../chart.js/node_modules/moment/locale/hi.js",
	"./hi.js": "../../../../chart.js/node_modules/moment/locale/hi.js",
	"./hr": "../../../../chart.js/node_modules/moment/locale/hr.js",
	"./hr.js": "../../../../chart.js/node_modules/moment/locale/hr.js",
	"./hu": "../../../../chart.js/node_modules/moment/locale/hu.js",
	"./hu.js": "../../../../chart.js/node_modules/moment/locale/hu.js",
	"./hy-am": "../../../../chart.js/node_modules/moment/locale/hy-am.js",
	"./hy-am.js": "../../../../chart.js/node_modules/moment/locale/hy-am.js",
	"./id": "../../../../chart.js/node_modules/moment/locale/id.js",
	"./id.js": "../../../../chart.js/node_modules/moment/locale/id.js",
	"./is": "../../../../chart.js/node_modules/moment/locale/is.js",
	"./is.js": "../../../../chart.js/node_modules/moment/locale/is.js",
	"./it": "../../../../chart.js/node_modules/moment/locale/it.js",
	"./it.js": "../../../../chart.js/node_modules/moment/locale/it.js",
	"./ja": "../../../../chart.js/node_modules/moment/locale/ja.js",
	"./ja.js": "../../../../chart.js/node_modules/moment/locale/ja.js",
	"./jv": "../../../../chart.js/node_modules/moment/locale/jv.js",
	"./jv.js": "../../../../chart.js/node_modules/moment/locale/jv.js",
	"./ka": "../../../../chart.js/node_modules/moment/locale/ka.js",
	"./ka.js": "../../../../chart.js/node_modules/moment/locale/ka.js",
	"./kk": "../../../../chart.js/node_modules/moment/locale/kk.js",
	"./kk.js": "../../../../chart.js/node_modules/moment/locale/kk.js",
	"./km": "../../../../chart.js/node_modules/moment/locale/km.js",
	"./km.js": "../../../../chart.js/node_modules/moment/locale/km.js",
	"./kn": "../../../../chart.js/node_modules/moment/locale/kn.js",
	"./kn.js": "../../../../chart.js/node_modules/moment/locale/kn.js",
	"./ko": "../../../../chart.js/node_modules/moment/locale/ko.js",
	"./ko.js": "../../../../chart.js/node_modules/moment/locale/ko.js",
	"./ky": "../../../../chart.js/node_modules/moment/locale/ky.js",
	"./ky.js": "../../../../chart.js/node_modules/moment/locale/ky.js",
	"./lb": "../../../../chart.js/node_modules/moment/locale/lb.js",
	"./lb.js": "../../../../chart.js/node_modules/moment/locale/lb.js",
	"./lo": "../../../../chart.js/node_modules/moment/locale/lo.js",
	"./lo.js": "../../../../chart.js/node_modules/moment/locale/lo.js",
	"./lt": "../../../../chart.js/node_modules/moment/locale/lt.js",
	"./lt.js": "../../../../chart.js/node_modules/moment/locale/lt.js",
	"./lv": "../../../../chart.js/node_modules/moment/locale/lv.js",
	"./lv.js": "../../../../chart.js/node_modules/moment/locale/lv.js",
	"./me": "../../../../chart.js/node_modules/moment/locale/me.js",
	"./me.js": "../../../../chart.js/node_modules/moment/locale/me.js",
	"./mi": "../../../../chart.js/node_modules/moment/locale/mi.js",
	"./mi.js": "../../../../chart.js/node_modules/moment/locale/mi.js",
	"./mk": "../../../../chart.js/node_modules/moment/locale/mk.js",
	"./mk.js": "../../../../chart.js/node_modules/moment/locale/mk.js",
	"./ml": "../../../../chart.js/node_modules/moment/locale/ml.js",
	"./ml.js": "../../../../chart.js/node_modules/moment/locale/ml.js",
	"./mr": "../../../../chart.js/node_modules/moment/locale/mr.js",
	"./mr.js": "../../../../chart.js/node_modules/moment/locale/mr.js",
	"./ms": "../../../../chart.js/node_modules/moment/locale/ms.js",
	"./ms-my": "../../../../chart.js/node_modules/moment/locale/ms-my.js",
	"./ms-my.js": "../../../../chart.js/node_modules/moment/locale/ms-my.js",
	"./ms.js": "../../../../chart.js/node_modules/moment/locale/ms.js",
	"./my": "../../../../chart.js/node_modules/moment/locale/my.js",
	"./my.js": "../../../../chart.js/node_modules/moment/locale/my.js",
	"./nb": "../../../../chart.js/node_modules/moment/locale/nb.js",
	"./nb.js": "../../../../chart.js/node_modules/moment/locale/nb.js",
	"./ne": "../../../../chart.js/node_modules/moment/locale/ne.js",
	"./ne.js": "../../../../chart.js/node_modules/moment/locale/ne.js",
	"./nl": "../../../../chart.js/node_modules/moment/locale/nl.js",
	"./nl-be": "../../../../chart.js/node_modules/moment/locale/nl-be.js",
	"./nl-be.js": "../../../../chart.js/node_modules/moment/locale/nl-be.js",
	"./nl.js": "../../../../chart.js/node_modules/moment/locale/nl.js",
	"./nn": "../../../../chart.js/node_modules/moment/locale/nn.js",
	"./nn.js": "../../../../chart.js/node_modules/moment/locale/nn.js",
	"./pa-in": "../../../../chart.js/node_modules/moment/locale/pa-in.js",
	"./pa-in.js": "../../../../chart.js/node_modules/moment/locale/pa-in.js",
	"./pl": "../../../../chart.js/node_modules/moment/locale/pl.js",
	"./pl.js": "../../../../chart.js/node_modules/moment/locale/pl.js",
	"./pt": "../../../../chart.js/node_modules/moment/locale/pt.js",
	"./pt-br": "../../../../chart.js/node_modules/moment/locale/pt-br.js",
	"./pt-br.js": "../../../../chart.js/node_modules/moment/locale/pt-br.js",
	"./pt.js": "../../../../chart.js/node_modules/moment/locale/pt.js",
	"./ro": "../../../../chart.js/node_modules/moment/locale/ro.js",
	"./ro.js": "../../../../chart.js/node_modules/moment/locale/ro.js",
	"./ru": "../../../../chart.js/node_modules/moment/locale/ru.js",
	"./ru.js": "../../../../chart.js/node_modules/moment/locale/ru.js",
	"./sd": "../../../../chart.js/node_modules/moment/locale/sd.js",
	"./sd.js": "../../../../chart.js/node_modules/moment/locale/sd.js",
	"./se": "../../../../chart.js/node_modules/moment/locale/se.js",
	"./se.js": "../../../../chart.js/node_modules/moment/locale/se.js",
	"./si": "../../../../chart.js/node_modules/moment/locale/si.js",
	"./si.js": "../../../../chart.js/node_modules/moment/locale/si.js",
	"./sk": "../../../../chart.js/node_modules/moment/locale/sk.js",
	"./sk.js": "../../../../chart.js/node_modules/moment/locale/sk.js",
	"./sl": "../../../../chart.js/node_modules/moment/locale/sl.js",
	"./sl.js": "../../../../chart.js/node_modules/moment/locale/sl.js",
	"./sq": "../../../../chart.js/node_modules/moment/locale/sq.js",
	"./sq.js": "../../../../chart.js/node_modules/moment/locale/sq.js",
	"./sr": "../../../../chart.js/node_modules/moment/locale/sr.js",
	"./sr-cyrl": "../../../../chart.js/node_modules/moment/locale/sr-cyrl.js",
	"./sr-cyrl.js": "../../../../chart.js/node_modules/moment/locale/sr-cyrl.js",
	"./sr.js": "../../../../chart.js/node_modules/moment/locale/sr.js",
	"./ss": "../../../../chart.js/node_modules/moment/locale/ss.js",
	"./ss.js": "../../../../chart.js/node_modules/moment/locale/ss.js",
	"./sv": "../../../../chart.js/node_modules/moment/locale/sv.js",
	"./sv.js": "../../../../chart.js/node_modules/moment/locale/sv.js",
	"./sw": "../../../../chart.js/node_modules/moment/locale/sw.js",
	"./sw.js": "../../../../chart.js/node_modules/moment/locale/sw.js",
	"./ta": "../../../../chart.js/node_modules/moment/locale/ta.js",
	"./ta.js": "../../../../chart.js/node_modules/moment/locale/ta.js",
	"./te": "../../../../chart.js/node_modules/moment/locale/te.js",
	"./te.js": "../../../../chart.js/node_modules/moment/locale/te.js",
	"./tet": "../../../../chart.js/node_modules/moment/locale/tet.js",
	"./tet.js": "../../../../chart.js/node_modules/moment/locale/tet.js",
	"./th": "../../../../chart.js/node_modules/moment/locale/th.js",
	"./th.js": "../../../../chart.js/node_modules/moment/locale/th.js",
	"./tl-ph": "../../../../chart.js/node_modules/moment/locale/tl-ph.js",
	"./tl-ph.js": "../../../../chart.js/node_modules/moment/locale/tl-ph.js",
	"./tlh": "../../../../chart.js/node_modules/moment/locale/tlh.js",
	"./tlh.js": "../../../../chart.js/node_modules/moment/locale/tlh.js",
	"./tr": "../../../../chart.js/node_modules/moment/locale/tr.js",
	"./tr.js": "../../../../chart.js/node_modules/moment/locale/tr.js",
	"./tzl": "../../../../chart.js/node_modules/moment/locale/tzl.js",
	"./tzl.js": "../../../../chart.js/node_modules/moment/locale/tzl.js",
	"./tzm": "../../../../chart.js/node_modules/moment/locale/tzm.js",
	"./tzm-latn": "../../../../chart.js/node_modules/moment/locale/tzm-latn.js",
	"./tzm-latn.js": "../../../../chart.js/node_modules/moment/locale/tzm-latn.js",
	"./tzm.js": "../../../../chart.js/node_modules/moment/locale/tzm.js",
	"./uk": "../../../../chart.js/node_modules/moment/locale/uk.js",
	"./uk.js": "../../../../chart.js/node_modules/moment/locale/uk.js",
	"./ur": "../../../../chart.js/node_modules/moment/locale/ur.js",
	"./ur.js": "../../../../chart.js/node_modules/moment/locale/ur.js",
	"./uz": "../../../../chart.js/node_modules/moment/locale/uz.js",
	"./uz-latn": "../../../../chart.js/node_modules/moment/locale/uz-latn.js",
	"./uz-latn.js": "../../../../chart.js/node_modules/moment/locale/uz-latn.js",
	"./uz.js": "../../../../chart.js/node_modules/moment/locale/uz.js",
	"./vi": "../../../../chart.js/node_modules/moment/locale/vi.js",
	"./vi.js": "../../../../chart.js/node_modules/moment/locale/vi.js",
	"./x-pseudo": "../../../../chart.js/node_modules/moment/locale/x-pseudo.js",
	"./x-pseudo.js": "../../../../chart.js/node_modules/moment/locale/x-pseudo.js",
	"./yo": "../../../../chart.js/node_modules/moment/locale/yo.js",
	"./yo.js": "../../../../chart.js/node_modules/moment/locale/yo.js",
	"./zh-cn": "../../../../chart.js/node_modules/moment/locale/zh-cn.js",
	"./zh-cn.js": "../../../../chart.js/node_modules/moment/locale/zh-cn.js",
	"./zh-hk": "../../../../chart.js/node_modules/moment/locale/zh-hk.js",
	"./zh-hk.js": "../../../../chart.js/node_modules/moment/locale/zh-hk.js",
	"./zh-tw": "../../../../chart.js/node_modules/moment/locale/zh-tw.js",
	"./zh-tw.js": "../../../../chart.js/node_modules/moment/locale/zh-tw.js"
};
function webpackContext(req) {
	return __webpack_require__(webpackContextResolve(req));
};
function webpackContextResolve(req) {
	var id = map[req];
	if(!(id + 1)) // check for number or string
		throw new Error("Cannot find module '" + req + "'.");
	return id;
};
webpackContext.keys = function webpackContextKeys() {
	return Object.keys(map);
};
webpackContext.resolve = webpackContextResolve;
module.exports = webpackContext;
webpackContext.id = "../../../../chart.js/node_modules/moment/locale recursive ^\\.\\/.*$";

/***/ }),

/***/ "../../../../moment/locale recursive ^\\.\\/.*$":
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"./af": "../../../../moment/locale/af.js",
	"./af.js": "../../../../moment/locale/af.js",
	"./ar": "../../../../moment/locale/ar.js",
	"./ar-dz": "../../../../moment/locale/ar-dz.js",
	"./ar-dz.js": "../../../../moment/locale/ar-dz.js",
	"./ar-kw": "../../../../moment/locale/ar-kw.js",
	"./ar-kw.js": "../../../../moment/locale/ar-kw.js",
	"./ar-ly": "../../../../moment/locale/ar-ly.js",
	"./ar-ly.js": "../../../../moment/locale/ar-ly.js",
	"./ar-ma": "../../../../moment/locale/ar-ma.js",
	"./ar-ma.js": "../../../../moment/locale/ar-ma.js",
	"./ar-sa": "../../../../moment/locale/ar-sa.js",
	"./ar-sa.js": "../../../../moment/locale/ar-sa.js",
	"./ar-tn": "../../../../moment/locale/ar-tn.js",
	"./ar-tn.js": "../../../../moment/locale/ar-tn.js",
	"./ar.js": "../../../../moment/locale/ar.js",
	"./az": "../../../../moment/locale/az.js",
	"./az.js": "../../../../moment/locale/az.js",
	"./be": "../../../../moment/locale/be.js",
	"./be.js": "../../../../moment/locale/be.js",
	"./bg": "../../../../moment/locale/bg.js",
	"./bg.js": "../../../../moment/locale/bg.js",
	"./bm": "../../../../moment/locale/bm.js",
	"./bm.js": "../../../../moment/locale/bm.js",
	"./bn": "../../../../moment/locale/bn.js",
	"./bn.js": "../../../../moment/locale/bn.js",
	"./bo": "../../../../moment/locale/bo.js",
	"./bo.js": "../../../../moment/locale/bo.js",
	"./br": "../../../../moment/locale/br.js",
	"./br.js": "../../../../moment/locale/br.js",
	"./bs": "../../../../moment/locale/bs.js",
	"./bs.js": "../../../../moment/locale/bs.js",
	"./ca": "../../../../moment/locale/ca.js",
	"./ca.js": "../../../../moment/locale/ca.js",
	"./cs": "../../../../moment/locale/cs.js",
	"./cs.js": "../../../../moment/locale/cs.js",
	"./cv": "../../../../moment/locale/cv.js",
	"./cv.js": "../../../../moment/locale/cv.js",
	"./cy": "../../../../moment/locale/cy.js",
	"./cy.js": "../../../../moment/locale/cy.js",
	"./da": "../../../../moment/locale/da.js",
	"./da.js": "../../../../moment/locale/da.js",
	"./de": "../../../../moment/locale/de.js",
	"./de-at": "../../../../moment/locale/de-at.js",
	"./de-at.js": "../../../../moment/locale/de-at.js",
	"./de-ch": "../../../../moment/locale/de-ch.js",
	"./de-ch.js": "../../../../moment/locale/de-ch.js",
	"./de.js": "../../../../moment/locale/de.js",
	"./dv": "../../../../moment/locale/dv.js",
	"./dv.js": "../../../../moment/locale/dv.js",
	"./el": "../../../../moment/locale/el.js",
	"./el.js": "../../../../moment/locale/el.js",
	"./en-au": "../../../../moment/locale/en-au.js",
	"./en-au.js": "../../../../moment/locale/en-au.js",
	"./en-ca": "../../../../moment/locale/en-ca.js",
	"./en-ca.js": "../../../../moment/locale/en-ca.js",
	"./en-gb": "../../../../moment/locale/en-gb.js",
	"./en-gb.js": "../../../../moment/locale/en-gb.js",
	"./en-ie": "../../../../moment/locale/en-ie.js",
	"./en-ie.js": "../../../../moment/locale/en-ie.js",
	"./en-nz": "../../../../moment/locale/en-nz.js",
	"./en-nz.js": "../../../../moment/locale/en-nz.js",
	"./eo": "../../../../moment/locale/eo.js",
	"./eo.js": "../../../../moment/locale/eo.js",
	"./es": "../../../../moment/locale/es.js",
	"./es-do": "../../../../moment/locale/es-do.js",
	"./es-do.js": "../../../../moment/locale/es-do.js",
	"./es-us": "../../../../moment/locale/es-us.js",
	"./es-us.js": "../../../../moment/locale/es-us.js",
	"./es.js": "../../../../moment/locale/es.js",
	"./et": "../../../../moment/locale/et.js",
	"./et.js": "../../../../moment/locale/et.js",
	"./eu": "../../../../moment/locale/eu.js",
	"./eu.js": "../../../../moment/locale/eu.js",
	"./fa": "../../../../moment/locale/fa.js",
	"./fa.js": "../../../../moment/locale/fa.js",
	"./fi": "../../../../moment/locale/fi.js",
	"./fi.js": "../../../../moment/locale/fi.js",
	"./fo": "../../../../moment/locale/fo.js",
	"./fo.js": "../../../../moment/locale/fo.js",
	"./fr": "../../../../moment/locale/fr.js",
	"./fr-ca": "../../../../moment/locale/fr-ca.js",
	"./fr-ca.js": "../../../../moment/locale/fr-ca.js",
	"./fr-ch": "../../../../moment/locale/fr-ch.js",
	"./fr-ch.js": "../../../../moment/locale/fr-ch.js",
	"./fr.js": "../../../../moment/locale/fr.js",
	"./fy": "../../../../moment/locale/fy.js",
	"./fy.js": "../../../../moment/locale/fy.js",
	"./gd": "../../../../moment/locale/gd.js",
	"./gd.js": "../../../../moment/locale/gd.js",
	"./gl": "../../../../moment/locale/gl.js",
	"./gl.js": "../../../../moment/locale/gl.js",
	"./gom-latn": "../../../../moment/locale/gom-latn.js",
	"./gom-latn.js": "../../../../moment/locale/gom-latn.js",
	"./gu": "../../../../moment/locale/gu.js",
	"./gu.js": "../../../../moment/locale/gu.js",
	"./he": "../../../../moment/locale/he.js",
	"./he.js": "../../../../moment/locale/he.js",
	"./hi": "../../../../moment/locale/hi.js",
	"./hi.js": "../../../../moment/locale/hi.js",
	"./hr": "../../../../moment/locale/hr.js",
	"./hr.js": "../../../../moment/locale/hr.js",
	"./hu": "../../../../moment/locale/hu.js",
	"./hu.js": "../../../../moment/locale/hu.js",
	"./hy-am": "../../../../moment/locale/hy-am.js",
	"./hy-am.js": "../../../../moment/locale/hy-am.js",
	"./id": "../../../../moment/locale/id.js",
	"./id.js": "../../../../moment/locale/id.js",
	"./is": "../../../../moment/locale/is.js",
	"./is.js": "../../../../moment/locale/is.js",
	"./it": "../../../../moment/locale/it.js",
	"./it.js": "../../../../moment/locale/it.js",
	"./ja": "../../../../moment/locale/ja.js",
	"./ja.js": "../../../../moment/locale/ja.js",
	"./jv": "../../../../moment/locale/jv.js",
	"./jv.js": "../../../../moment/locale/jv.js",
	"./ka": "../../../../moment/locale/ka.js",
	"./ka.js": "../../../../moment/locale/ka.js",
	"./kk": "../../../../moment/locale/kk.js",
	"./kk.js": "../../../../moment/locale/kk.js",
	"./km": "../../../../moment/locale/km.js",
	"./km.js": "../../../../moment/locale/km.js",
	"./kn": "../../../../moment/locale/kn.js",
	"./kn.js": "../../../../moment/locale/kn.js",
	"./ko": "../../../../moment/locale/ko.js",
	"./ko.js": "../../../../moment/locale/ko.js",
	"./ky": "../../../../moment/locale/ky.js",
	"./ky.js": "../../../../moment/locale/ky.js",
	"./lb": "../../../../moment/locale/lb.js",
	"./lb.js": "../../../../moment/locale/lb.js",
	"./lo": "../../../../moment/locale/lo.js",
	"./lo.js": "../../../../moment/locale/lo.js",
	"./lt": "../../../../moment/locale/lt.js",
	"./lt.js": "../../../../moment/locale/lt.js",
	"./lv": "../../../../moment/locale/lv.js",
	"./lv.js": "../../../../moment/locale/lv.js",
	"./me": "../../../../moment/locale/me.js",
	"./me.js": "../../../../moment/locale/me.js",
	"./mi": "../../../../moment/locale/mi.js",
	"./mi.js": "../../../../moment/locale/mi.js",
	"./mk": "../../../../moment/locale/mk.js",
	"./mk.js": "../../../../moment/locale/mk.js",
	"./ml": "../../../../moment/locale/ml.js",
	"./ml.js": "../../../../moment/locale/ml.js",
	"./mr": "../../../../moment/locale/mr.js",
	"./mr.js": "../../../../moment/locale/mr.js",
	"./ms": "../../../../moment/locale/ms.js",
	"./ms-my": "../../../../moment/locale/ms-my.js",
	"./ms-my.js": "../../../../moment/locale/ms-my.js",
	"./ms.js": "../../../../moment/locale/ms.js",
	"./mt": "../../../../moment/locale/mt.js",
	"./mt.js": "../../../../moment/locale/mt.js",
	"./my": "../../../../moment/locale/my.js",
	"./my.js": "../../../../moment/locale/my.js",
	"./nb": "../../../../moment/locale/nb.js",
	"./nb.js": "../../../../moment/locale/nb.js",
	"./ne": "../../../../moment/locale/ne.js",
	"./ne.js": "../../../../moment/locale/ne.js",
	"./nl": "../../../../moment/locale/nl.js",
	"./nl-be": "../../../../moment/locale/nl-be.js",
	"./nl-be.js": "../../../../moment/locale/nl-be.js",
	"./nl.js": "../../../../moment/locale/nl.js",
	"./nn": "../../../../moment/locale/nn.js",
	"./nn.js": "../../../../moment/locale/nn.js",
	"./pa-in": "../../../../moment/locale/pa-in.js",
	"./pa-in.js": "../../../../moment/locale/pa-in.js",
	"./pl": "../../../../moment/locale/pl.js",
	"./pl.js": "../../../../moment/locale/pl.js",
	"./pt": "../../../../moment/locale/pt.js",
	"./pt-br": "../../../../moment/locale/pt-br.js",
	"./pt-br.js": "../../../../moment/locale/pt-br.js",
	"./pt.js": "../../../../moment/locale/pt.js",
	"./ro": "../../../../moment/locale/ro.js",
	"./ro.js": "../../../../moment/locale/ro.js",
	"./ru": "../../../../moment/locale/ru.js",
	"./ru.js": "../../../../moment/locale/ru.js",
	"./sd": "../../../../moment/locale/sd.js",
	"./sd.js": "../../../../moment/locale/sd.js",
	"./se": "../../../../moment/locale/se.js",
	"./se.js": "../../../../moment/locale/se.js",
	"./si": "../../../../moment/locale/si.js",
	"./si.js": "../../../../moment/locale/si.js",
	"./sk": "../../../../moment/locale/sk.js",
	"./sk.js": "../../../../moment/locale/sk.js",
	"./sl": "../../../../moment/locale/sl.js",
	"./sl.js": "../../../../moment/locale/sl.js",
	"./sq": "../../../../moment/locale/sq.js",
	"./sq.js": "../../../../moment/locale/sq.js",
	"./sr": "../../../../moment/locale/sr.js",
	"./sr-cyrl": "../../../../moment/locale/sr-cyrl.js",
	"./sr-cyrl.js": "../../../../moment/locale/sr-cyrl.js",
	"./sr.js": "../../../../moment/locale/sr.js",
	"./ss": "../../../../moment/locale/ss.js",
	"./ss.js": "../../../../moment/locale/ss.js",
	"./sv": "../../../../moment/locale/sv.js",
	"./sv.js": "../../../../moment/locale/sv.js",
	"./sw": "../../../../moment/locale/sw.js",
	"./sw.js": "../../../../moment/locale/sw.js",
	"./ta": "../../../../moment/locale/ta.js",
	"./ta.js": "../../../../moment/locale/ta.js",
	"./te": "../../../../moment/locale/te.js",
	"./te.js": "../../../../moment/locale/te.js",
	"./tet": "../../../../moment/locale/tet.js",
	"./tet.js": "../../../../moment/locale/tet.js",
	"./th": "../../../../moment/locale/th.js",
	"./th.js": "../../../../moment/locale/th.js",
	"./tl-ph": "../../../../moment/locale/tl-ph.js",
	"./tl-ph.js": "../../../../moment/locale/tl-ph.js",
	"./tlh": "../../../../moment/locale/tlh.js",
	"./tlh.js": "../../../../moment/locale/tlh.js",
	"./tr": "../../../../moment/locale/tr.js",
	"./tr.js": "../../../../moment/locale/tr.js",
	"./tzl": "../../../../moment/locale/tzl.js",
	"./tzl.js": "../../../../moment/locale/tzl.js",
	"./tzm": "../../../../moment/locale/tzm.js",
	"./tzm-latn": "../../../../moment/locale/tzm-latn.js",
	"./tzm-latn.js": "../../../../moment/locale/tzm-latn.js",
	"./tzm.js": "../../../../moment/locale/tzm.js",
	"./uk": "../../../../moment/locale/uk.js",
	"./uk.js": "../../../../moment/locale/uk.js",
	"./ur": "../../../../moment/locale/ur.js",
	"./ur.js": "../../../../moment/locale/ur.js",
	"./uz": "../../../../moment/locale/uz.js",
	"./uz-latn": "../../../../moment/locale/uz-latn.js",
	"./uz-latn.js": "../../../../moment/locale/uz-latn.js",
	"./uz.js": "../../../../moment/locale/uz.js",
	"./vi": "../../../../moment/locale/vi.js",
	"./vi.js": "../../../../moment/locale/vi.js",
	"./x-pseudo": "../../../../moment/locale/x-pseudo.js",
	"./x-pseudo.js": "../../../../moment/locale/x-pseudo.js",
	"./yo": "../../../../moment/locale/yo.js",
	"./yo.js": "../../../../moment/locale/yo.js",
	"./zh-cn": "../../../../moment/locale/zh-cn.js",
	"./zh-cn.js": "../../../../moment/locale/zh-cn.js",
	"./zh-hk": "../../../../moment/locale/zh-hk.js",
	"./zh-hk.js": "../../../../moment/locale/zh-hk.js",
	"./zh-tw": "../../../../moment/locale/zh-tw.js",
	"./zh-tw.js": "../../../../moment/locale/zh-tw.js"
};
function webpackContext(req) {
	return __webpack_require__(webpackContextResolve(req));
};
function webpackContextResolve(req) {
	var id = map[req];
	if(!(id + 1)) // check for number or string
		throw new Error("Cannot find module '" + req + "'.");
	return id;
};
webpackContext.keys = function webpackContextKeys() {
	return Object.keys(map);
};
webpackContext.resolve = webpackContextResolve;
module.exports = webpackContext;
webpackContext.id = "../../../../moment/locale recursive ^\\.\\/.*$";

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map