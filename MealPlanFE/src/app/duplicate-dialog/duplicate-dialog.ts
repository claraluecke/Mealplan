import { Component, Inject, inject } from '@angular/core';
import { MatDialogRef, MatDialogContent, MatDialogActions, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Ingredient } from '../models/ingredient.model';

@Component({
  selector: 'app-duplicate-dialog',
  imports: [MatDialogContent, MatDialogActions],
  templateUrl: './duplicate-dialog.html',
  styleUrl: './duplicate-dialog.scss',
})
export class DuplicateDialogComponent {
  private dialogRef= inject (MatDialogRef<DuplicateDialogComponent>)
  constructor(
    @Inject(MAT_DIALOG_DATA)
    public data: {
      duplicates: Ingredient[];
    }
    ) {}

  confirm() {
    this.dialogRef.close(true);
  }

  cancel() {
    this.dialogRef.close(false);
  }
}
