import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientSubmission } from './ingredient-submission';

describe('IngredientSubmission', () => {
  let component: IngredientSubmission;
  let fixture: ComponentFixture<IngredientSubmission>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IngredientSubmission],
    }).compileComponents();

    fixture = TestBed.createComponent(IngredientSubmission);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
