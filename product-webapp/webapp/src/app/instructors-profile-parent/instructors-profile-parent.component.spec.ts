import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorsProfileParentComponent } from './instructors-profile-parent.component';

describe('InstructorsProfileParentComponent', () => {
  let component: InstructorsProfileParentComponent;
  let fixture: ComponentFixture<InstructorsProfileParentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorsProfileParentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorsProfileParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
