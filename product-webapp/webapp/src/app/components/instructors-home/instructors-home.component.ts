import { Component, OnInit, Input } from '@angular/core';
import { Learner } from 'src/app/model/learner';
import { Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-instructors-home',
  templateUrl: './instructors-home.component.html',
  styleUrls: ['./instructors-home.component.css']
})
export class InstructorsHomeComponent implements OnInit {

  @Input() instructorName : String;
  @Input() learnerLists : Learner;
  @Input() batchName : String;
  @Output() accessorEmail = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  addAccessor(value: string) {
    this.accessorEmail.emit(value);
  }

}
