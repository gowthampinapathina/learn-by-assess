import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { InstructorSidenavbarComponent } from './components/instructor-sidenavbar/instructor-sidenavbar.component';
import { InstructorsCreateFormalAssessmentComponent } from './components/instructors-create-formal-assessment/instructors-create-formal-assessment.component';
import { InstructorsCreateInformalAssessmentComponent } from './components/instructors-create-informal-assessment/instructors-create-informal-assessment.component';
import { InstructorsReviewComponent } from './components/instructors-review/instructors-review.component';
import { InstructorsProfileComponent } from './components/instructors-profile/instructors-profile.component';
import { InstructorsEditprofileComponent } from './components/instructors-editprofile/instructors-editprofile.component';
import { InstructorsHomeComponent } from './components/instructors-home/instructors-home.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RegistrationComponentComponent } from './components/registration-component/registration-component.component';
import {MatButtonModule} from '@angular/material/button';
import {MatSelectModule} from '@angular/material/select';
import { InstructorsProfileParentComponent } from './instructors-profile-parent/instructors-profile-parent.component';
import { HttpClientModule } from '@angular/common/http';
import { AssessmentService } from './services/assessment.service';
import { LearnerModule } from './components/learner/learner.module';
import { PasswordPatternDirective } from './directives/password-pattern.directive';
import { MatchPasswordDirective } from './directives/match-password.directive';


@NgModule({
  declarations: [
    AppComponent,
    InstructorSidenavbarComponent,
    InstructorsCreateFormalAssessmentComponent,
    InstructorsCreateInformalAssessmentComponent,
    InstructorsReviewComponent,
    InstructorsProfileComponent,
    InstructorsEditprofileComponent,
    InstructorsHomeComponent,
    HomeComponentComponent,
    RegistrationComponentComponent,
    LoginComponent,
    NavbarComponent,
    InstructorsProfileParentComponent,
    PasswordPatternDirective,
    MatchPasswordDirective,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LearnerModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    // MATERIAL IMPORTS
    MatSidenavModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatDividerModule,
    MatIconModule,
    MatSelectModule,
    LearnerModule
  ],
  providers: [AssessmentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
