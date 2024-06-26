import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any>=new EventEmitter();

  @Input() learnerName:String;
  constructor() { }

  ngOnInit(): void {}
  toggleSidebar(){
    this.toggleSidebarForMe.emit();
  }
}
