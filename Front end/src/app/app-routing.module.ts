import { HomeComponent } from './home/home.component';
import { SelectDoctorComponent } from './select-doctor/select-doctor.component';

import { PatientDetailsComponent } from './patient/patient-details/patient-details.component';
import { UpdatePatientComponent } from './patient/update-patient/update-patient.component';
import { RegisterPatientComponent } from './patient/register-patient/register-patient.component';
import { PatientListComponent } from './patient/patient-list/patient-list.component';
import { ViewEmployeeComponent } from './employee/view-employee/view-employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import { AddEmployeeComponent } from './employee/add-employee/add-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';

// const routes: Routes = [
//   {path:'',component:EmployeeComponent},
//   {path: 'add-employee',component:AddEmployeeComponent},
//   {path: 'employee/:id',component:EmployeeComponent},
//   {path: 'update-employee',component:UpdateEmployeeComponent},
//   {path: 'view/:id',component:ViewEmployeeComponent }
// ];
const routes: Routes = [
  {path: 'patients',component: PatientListComponent},
  {path: 'register-employee',component: RegisterPatientComponent},
  //{path: '',redirectTo: 'patients',pathMatch: 'full'},
  {path: 'update-patient/:id',component: UpdatePatientComponent},
  {path: 'patient-details/:id', component: PatientDetailsComponent},
  {path: 'selectDoctror',component:SelectDoctorComponent},
  {path:'employelist',component:EmployeeComponent},
   {path: 'add-employee',component:AddEmployeeComponent},
   {path: 'employee/:id',component:EmployeeComponent},
   {path: 'update-employee',component:UpdateEmployeeComponent},
  {path: 'view/:id',component:ViewEmployeeComponent },
  {path:'',component:HomeComponent },
  {path:'login',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
