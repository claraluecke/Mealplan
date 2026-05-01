import { RecipeIngredient } from "./recipeIngredient.model";

export interface Recipe {
    id: number;
    name: string;
    ingredients: RecipeIngredient[];
    instructions: string;
    tags: string[];

}