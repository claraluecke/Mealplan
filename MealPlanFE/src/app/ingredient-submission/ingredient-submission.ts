import { Component, inject } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { IngredientService } from '../services/ingredient.service';

@Component({
  selector: 'app-ingredient-submission',
  imports: [ReactiveFormsModule, MatFormFieldModule, MatButtonModule, MatInputModule],
  templateUrl: './ingredient-submission.html',
  styleUrl: './ingredient-submission.scss',
})
export class IngredientSubmission {
  form;
  ingredientService = inject(IngredientService);

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
    name: ['', Validators.required],
    unit: ['', Validators.required]
  });
  }

     
  onSubmit() {
    if (this.form.valid){
      const {name, unit} = this.form.value as {
        name: string;
        unit: string;
      };
      this.ingredientService.addIngredient({'name': name, 'unit': unit, 'conversions': []})
     
    }
    
  }
}
