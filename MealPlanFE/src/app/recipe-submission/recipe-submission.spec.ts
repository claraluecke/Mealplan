import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeSubmission } from './recipe-submission';

describe('RecipeSubmission', () => {
  let component: RecipeSubmission;
  let fixture: ComponentFixture<RecipeSubmission>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecipeSubmission],
    }).compileComponents();

    fixture = TestBed.createComponent(RecipeSubmission);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
