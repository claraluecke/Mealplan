import { FormArray, FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { IngredientService } from './../services/ingredient.service';
import { Component, inject, OnInit } from '@angular/core';
import { MatFormField, MatFormFieldModule } from "@angular/material/form-field";
import { MatOption } from '@angular/material/autocomplete';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { CommonModule } from '@angular/common'; 
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { Observable, startWith, map } from 'rxjs';
import { Ingredient } from '../models/ingredient.model';
import { RecipeService } from '../services/recipe.service';

@Component({
  selector: 'app-recipe-submission',
  imports: [MatFormField, MatFormFieldModule, ReactiveFormsModule, MatOption, MatIcon, 
    MatInputModule, MatIconModule, MatButtonModule, MatSelectModule, CommonModule, MatAutocompleteModule],
  templateUrl: './recipe-submission.html',
  styleUrl: './recipe-submission.scss',
})
export class RecipeSubmission implements OnInit{
  recipeForm!: FormGroup;
  fb = inject(FormBuilder)

  recipeService = inject(RecipeService)
  ingredientService = inject(IngredientService);
  allIngr = this.ingredientService.ROIngredients;
  filteredIngredients : Observable<Ingredient[]>[]= [];



  ngOnInit(): void {
    this.recipeForm = this.fb.group({
      name: ['',Validators.required],
      servings: [1, Validators.required],
      instructions: ['', Validators.required],
      ingredients: this.fb.array([]),
    })
    this.addIngredientRow();
  }

  get ingredientForms(): FormArray {
    return this.recipeForm.get('ingredients') as FormArray;
  }

  addIngredientRow() {
    
    const group = this.fb.group({
      ingredient: [null],
      amount: [null]
    });
    this.ingredientForms.push(group);

    const control = group.get('ingredient');

    this.filteredIngredients.push(
      control!.valueChanges.pipe(
        startWith(''),
        map(value => this.filterIngredients(value))
      ));
    }


  filterIngredients(value: any): Ingredient[] {

    const text =
      typeof value === 'string'
        ? value
        : value?.name ?? '';

    const filterValue =
      text.toLowerCase();

    return this.allIngr().filter(
      (ingredient: Ingredient) =>
        ingredient.name
          .toLowerCase()
          .includes(filterValue)
    );
}

  removeIngredientRow(index: number) {
    this.ingredientForms.removeAt(index);
  }

  getUnit(index: number): string {
    const id =
      this.ingredientForms.at(index)
        .get('ingredientId')?.value;

    const found =
      this.allIngr().find(i => i.id === id);

    return found?.unit ?? '';
  }

  displayIngredient(ingredient: Ingredient): string {
  return ingredient?.name ?? '';
}

  submit() {
    if (this.recipeForm.valid) {
     
      const recdata =this.recipeForm.value;
      let ingrs : {"ingredient": Ingredient, "amount": number }[] = []
      recdata.ingredients.forEach( (i: { ingredient: Ingredient; amount: any; })=> ingrs.push({"ingredient" : i.ingredient, "amount": i.amount}));
      const createdRecipe =  {
        name : recdata.name,
        servings : recdata.servings,
        instructions : recdata.instructions,
        ingredients: ingrs,
        tags: []
      }
      console.log(createdRecipe);
      this.recipeService.saveRecipe(createdRecipe)
    }
  }

}
