import { Component, inject } from '@angular/core';
import { MatList } from "@angular/material/list";
import { MatCard } from "@angular/material/card";
import { IngredientComponent } from "../ingredient/ingredient";
import { RecipeService } from '../services/recipe.service';
import { Recipe } from '../models/recipe.model';
import { RecipeComponent } from "../recipe/recipe";

@Component({
  selector: 'app-recipe-list',
  imports: [MatList, MatCard, IngredientComponent, RecipeComponent],
  templateUrl: './recipe-list.html',
  styleUrl: './recipe-list.scss',
})
export class RecipeList {

  rs = inject(RecipeService);
  allRecipes = this.rs.allRecRO;
  selectedRecipe? : Recipe; 

  selectRecipe(rec: Recipe) {
    this.selectedRecipe = rec;
    console.log(rec)
    
  }
}
