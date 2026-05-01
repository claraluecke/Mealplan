import { Ingredient } from "./ingredient.model";

export interface RecipeIngredient{
    id: number;
    recipeId: number;
    ingredient: Ingredient;
    amount: number;
    unit: string;
}