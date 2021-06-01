import { ViewEmployeeComponent } from './employee/view-employee/view-employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import { AddEmployeeComponent } from './employee/add-employee/add-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'',component:EmployeeComponent},
  {path: 'add-employee',component:AddEmployeeComponent},
  {path: 'employee/:id',component:EmployeeComponent},
  {path: 'update-employee',component:UpdateEmployeeComponent},
  {path: 'view/:id',component:ViewEmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
