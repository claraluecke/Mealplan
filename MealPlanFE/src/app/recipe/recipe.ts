import { Component, inject, Input } from '@angular/core';
import { Recipe } from '../models/recipe.model';
import { IngredientService } from '../services/ingredient.service';
import { Ingredient } from '../models/ingredient.model';
import { RecipeIngredient } from '../models/recipeIngredient.model';
@Component({
  selector: 'app-recipe',
  imports: [],
  templateUrl: './recipe.html',
  styleUrl: './recipe.scss',
})
export class RecipeComponent {
  is : IngredientService =inject(IngredientService); 
  @Input({required: true}) recipe!: Recipe;
  
  buildString(ri: RecipeIngredient) {
    console.log(ri.ingredient.id)
    //let ing: Ingredient = this.is.findbyId(ri.ingredient.id);
    const ing = ri.ingredient;
    return ri.amount + " " +ing.unit + " " + ing.name;

  }
}
