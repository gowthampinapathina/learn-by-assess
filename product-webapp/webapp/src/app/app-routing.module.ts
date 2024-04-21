import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RegistrationComponentComponent } from './components/registration-component/registration-component.component';
import { InstructorSidenavbarComponent } from './components/instructor-sidenavbar/instructor-sidenavbar.component';
import { InstructorsProfileComponent } from './components/instructors-profile/instructors-profile.component';
import { InstructorsCreateFormalAssessmentComponent } from './components/instructors-create-formal-assessment/instructors-create-formal-assessment.component';
import { InstructorsHomeComponent } from './components/instructors-home/instructors-home.component';
import { InstructorsEditprofileComponent } from './components/instructors-editprofile/instructors-editprofile.component';
import { HomeComponentComponent } from './components/home-component/home-component.component';
import { LearnerComponent } from './components/learner/learner.component';
import { HomeComponent } from './components/learner/home/home.component';
import { AssessmentComponent } from './components/learner/assessment/assessment.component';
import { GradingComponent } from './components/learner/grading/grading.component';
import { LearnerProfileComponent } from './components/learner/learner-profile/learner-profile.component';
import { LeaderboardComponent } from './components/learner/leaderboard/leaderboard.component';
import { AssessmentABCComponent } from './components/learner/assessment-abc/assessment-abc.component';
import { TakeAssessmentComponent } from './components/learner/take-assessment/take-assessment.component';
import { AssessmentListComponent } from './components/learner/assessment-list/assessment-list.component';

const routes: Routes = [
  { path: '', component: NavbarComponent, pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: RegistrationComponentComponent },
  { path: 'instructor-dashboard', component: InstructorSidenavbarComponent },
  { path: 'instructors-profile', component: InstructorsProfileComponent },
  { path: 'instructors-home', component: InstructorsHomeComponent },
  { path: 'editprofile', component: InstructorsEditprofileComponent },
  {
    path: 'dashboard', component: LearnerComponent,
    children: [
      { path: '', component: LearnerProfileComponent },
      // { path: 'home', component: HomeComponent },
      { path: 'assessment', component: AssessmentComponent },
      // { path: 'grading', component: GradingComponent },
      { path: 'learner-profile', component: LearnerProfileComponent },
      // { path: 'leaderboard', component: LeaderboardComponent },
      { path: 'createAssignment/:batchId/:assignId', component: AssessmentABCComponent},
      { path: 'takeAssessment', component: AssessmentListComponent},
      { path: 'attempt/:batchId/:assignmentId', component:TakeAssessmentComponent}
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
