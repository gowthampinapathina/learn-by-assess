import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorsEditprofileComponent } from './instructors-editprofile.component';

describe('InstructorsEditprofileComponent', () => {
  let component: InstructorsEditprofileComponent;
  let fixture: ComponentFixture<InstructorsEditprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorsEditprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorsEditprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
