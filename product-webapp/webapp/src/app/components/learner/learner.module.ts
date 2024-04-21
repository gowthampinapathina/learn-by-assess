import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LearnerComponent } from './learner.component';
import { RouterModule } from '@angular/router';
import { AssessmentComponent } from './assessment/assessment.component';
import { GradingComponent } from './grading/grading.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { LearnerProfileComponent } from './learner-profile/learner-profile.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { TakeAssessmentComponent } from './take-assessment/take-assessment.component';
import { AssessmentABCComponent } from './assessment-abc/assessment-abc.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatRadioModule} from '@angular/material/radio';
import { AssessmentListComponent } from './assessment-list/assessment-list.component';

@NgModule({
  declarations: [
    LearnerComponent,
    AssessmentComponent,
    GradingComponent,
    HeaderComponent,
    HomeComponent,
    LeaderboardComponent,
    LearnerProfileComponent,
    SidenavComponent,
    TakeAssessmentComponent,
    AssessmentABCComponent,
    AssessmentListComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MatSidenavModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MatRadioModule
  ]
})
export class LearnerModule { }