import { Component, inject, Input } from '@angular/core';
import { Ingredient } from '../models/ingredient.model';
import { IngredientService } from '../services/ingredient.service';

@Component({
  selector: 'app-ingredient',
  imports: [],
  templateUrl: './ingredient.html',
  styleUrl: './ingredient.scss',
})
export class IngredientComponent {
  @Input() ingredient!: Ingredient;
  


}
