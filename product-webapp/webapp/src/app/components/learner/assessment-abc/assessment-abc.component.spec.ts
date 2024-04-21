import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssessmentABCComponent } from './assessment-abc.component';

describe('AssessmentABCComponent', () => {
  let component: AssessmentABCComponent;
  let fixture: ComponentFixture<AssessmentABCComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssessmentABCComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssessmentABCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
