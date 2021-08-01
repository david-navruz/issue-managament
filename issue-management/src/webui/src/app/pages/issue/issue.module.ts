import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IssueComponent } from './issue.component';
import {IssueRoutingModule} from "./issue.routing.module";
import { IssueDetailComponent } from './issue-detail/issue-detail.component';

@NgModule({
  imports: [
    CommonModule,
    IssueRoutingModule,
  ],
  declarations: [IssueComponent, IssueDetailComponent]
})
export class IssueModule { }
