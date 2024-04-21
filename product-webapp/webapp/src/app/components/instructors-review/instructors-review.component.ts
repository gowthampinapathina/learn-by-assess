import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-instructors-review',
  templateUrl: './instructors-review.component.html',
  styleUrls: ['./instructors-review.component.css']
})
export class InstructorsReviewComponent implements OnInit {

  reviewList:any[]=["Assignment 1", "Assignment 2" ];
  constructor() { }

  ngOnInit(): void {
  }

}
