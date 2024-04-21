import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorsCreateInformalAssessmentComponent } from './instructors-create-informal-assessment.component';

describe('InstructorsCreateInformalAssessmentComponent', () => {
  let component: InstructorsCreateInformalAssessmentComponent;
  let fixture: ComponentFixture<InstructorsCreateInformalAssessmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorsCreateInformalAssessmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorsCreateInformalAssessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
