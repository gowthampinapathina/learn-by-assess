import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorsReviewComponent } from './instructors-review.component';

describe('InstructorsReviewComponent', () => {
  let component: InstructorsReviewComponent;
  let fixture: ComponentFixture<InstructorsReviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorsReviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorsReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
