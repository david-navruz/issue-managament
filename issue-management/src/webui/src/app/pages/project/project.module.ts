import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectComponent } from './project.component';
import {ProjectRoutingModule} from "./project.routing.module";


@NgModule({
  imports: [
    CommonModule,
    NgxDatatableModule,
    ProjectRoutingModule,
    SharedModule
  ],
  declarations: [ProjectComponent]
})
export class ProjectModule { }
