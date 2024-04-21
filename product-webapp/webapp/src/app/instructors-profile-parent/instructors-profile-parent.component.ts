import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-instructors-profile-parent',
  templateUrl: './instructors-profile-parent.component.html',
  styleUrls: ['./instructors-profile-parent.component.css']
})
export class InstructorsProfileParentComponent implements OnInit {

  constructor() { }

  profile:boolean=true;
  editprofile:boolean=false;

  ngOnInit(): void {
  }

  
}
