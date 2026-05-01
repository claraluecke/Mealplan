import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Recipe } from '../models/recipe.model';
import { Ingredient } from '../models/ingredient.model';

@Injectable({
  providedIn: 'root',
})
export class RecipeService {
  httpClient= inject(HttpClient)
  private backendURL = 'http://localhost:8080/api';

  private allRecipes= signal<Recipe[]>([]);
  allRecRO = this.allRecipes.asReadonly();

  constructor () {
    this.fetchRecipes(this.backendURL+"/recipes");
  }
  saveRecipe(value: any) {
      this.httpClient.post<Recipe>(this.backendURL+'/recipes', value).subscribe({
          next: (value) => this.fetchRecipes(this.backendURL+'/recipes'),}
        );
  }


  fetchRecipes(url: string): void {
    this.httpClient.get<Recipe[]>(url).subscribe({
        next: (resData) => {this.allRecipes.set(resData)}
      });
  }
  
}
