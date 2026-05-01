import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { IngredientService } from './services/ingredient.service';
import { IngredientComponent } from "./ingredient/ingredient";
import { MatList } from '@angular/material/list';
import { MatCard } from '@angular/material/card';
import { IngredientSubmission } from './ingredient-submission/ingredient-submission';
import { RecipeSubmission } from "./recipe-submission/recipe-submission";
import { RecipeList } from './recipe-list/recipe-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, IngredientComponent, MatList, MatCard, IngredientSubmission, RecipeSubmission, RecipeList],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('MealPlanFE');
  private ingredientService = inject(IngredientService);
  allIngr = this.ingredientService.ROIngredients;

}
