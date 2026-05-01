import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DuplicateDialog } from './duplicate-dialog';

describe('DuplicateDialog', () => {
  let component: DuplicateDialog;
  let fixture: ComponentFixture<DuplicateDialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DuplicateDialog],
    }).compileComponents();

    fixture = TestBed.createComponent(DuplicateDialog);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
