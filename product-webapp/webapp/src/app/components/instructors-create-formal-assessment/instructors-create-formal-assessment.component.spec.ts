import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorsCreateFormalAssessmentComponent } from './instructors-create-formal-assessment.component';

describe('InstructorsCreateFormalAssessmentComponent', () => {
  let component: InstructorsCreateFormalAssessmentComponent;
  let fixture: ComponentFixture<InstructorsCreateFormalAssessmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorsCreateFormalAssessmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorsCreateFormalAssessmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
