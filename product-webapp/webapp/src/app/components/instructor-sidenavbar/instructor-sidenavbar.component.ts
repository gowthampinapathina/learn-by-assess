import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { BreakpointObserver } from '@angular/cdk/layout';
import { InstructorService } from 'src/app/services/instructor.service';
import { Router } from '@angular/router';
import { Batch } from 'src/app/model/batch';
import { Learner } from 'src/app/model/learner';

@Component({
  selector: 'app-instructor-sidenavbar',
  templateUrl: './instructor-sidenavbar.component.html',
  styleUrls: ['./instructor-sidenavbar.component.css']
})


export class InstructorSidenavbarComponent implements OnInit {
  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;
  constructor(private observer: BreakpointObserver, private instructorService:InstructorService,
              private router:Router) { }

  formal:boolean=false;
  informal:boolean=false;
  parentprofile:boolean=false;
  review:boolean=false;
  home:boolean=true;
  editprofile:boolean=false;

  batch : Batch[];
  batchNames : String[] = [];
  instructorName : String;
  batchLearners : Learner;
  batchName : String;
  batchId: String;
  accessorId: String;

  instructorMail : String = localStorage.getItem("emailId");

  ngOnInit(): void {
    this.getBatchDetail();
  }

  getBatchDetail(){
    this.instructorService.getBatchList(this.instructorMail).subscribe(data =>{
      this.batch = data;
      console.log(data);
      this.getBatchName();
    },
    error => console.log(error));
  }

  getBatchName(){
    for(var name of this.batch){
      this.batchNames.push(name.batchName);
      this.instructorName = name.instructorName;
      console.log("batch id:", name.batchId);
    }
  }

  batchDetail(selectedBatch:String){
    this.batchName = selectedBatch;
    for(var allBatches of this.batch){
      if(allBatches.batchName == selectedBatch){
        this.batchLearners = allBatches.learner
        this.batchId=allBatches.batchId;
        //console.log(this.batchLearners);
      }
    }
  }

  ngAfterViewInit() {
    this.observer.observe(['(max-width: 800px']).subscribe((res) => {
      if (res.matches) {
        this.sidenav.mode = 'over';
        this.sidenav.close();
      } else {
        this.sidenav.mode = 'side';
        this.sidenav.open();
      }
    
    })
  }


  instructorsHome(){
    this.formal=false;
    this.home=true;
    this.informal=false;
    this.parentprofile=false;
    this.review=false;
    this.editprofile=false;
  }

  formalAssessment(){
    console.log("batch selected:", this.batchId);
    console.log("assessor id selected:", this.accessorId);
    // console.log("clicked")
    this.formal=true;
    this.informal=false;
    this.home=false;
    this.parentprofile=false;
    this.review=false;
    this.editprofile=false;
  }

  informalAssessment(){
    console.log("clicked")
    this.informal=true;
    this.formal=false;
    this.home=false;
    this.review=false;
    this.parentprofile=false;
    this.editprofile=false;
  }
  instructorsProfile(){
    this.informal=false;
    this.formal=false;
    this.home=false;
    this.parentprofile=true;
    this.review=false;
    this.editprofile=false;
  }
  instructorsReview(){
    this.informal=false;
    this.formal=false;
    this.home=false;
    this.parentprofile=false;
    this.review=true;
    this.editprofile=false;
  }
  instructorsEditProfile(){
    this.parentprofile=false;
    this.informal=false;
    this.formal=false;
    this.home=false;
    this.review=false;
    this.editprofile=true;
  }

  addItem(value: string) {
    console.log("recived from child:", value);
    this.accessorId=value;
  }
}
