import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorSidenavbarComponent } from './instructor-sidenavbar.component';

describe('InstructorSidenavbarComponent', () => {
  let component: InstructorSidenavbarComponent;
  let fixture: ComponentFixture<InstructorSidenavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorSidenavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorSidenavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
