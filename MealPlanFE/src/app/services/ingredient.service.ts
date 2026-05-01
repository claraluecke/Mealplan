import { HttpClient } from '@angular/common/http';
import { inject, Injectable, OnInit, signal } from '@angular/core';
import { Ingredient } from '../models/ingredient.model';
import { timer } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { DuplicateDialogComponent } from '../duplicate-dialog/duplicate-dialog';


@Injectable({
  providedIn: 'root',
})
export class IngredientService {
 
  private httpClient = inject(HttpClient);
  private allIngredients = signal<Ingredient[]>([]);
  ROIngredients = this.allIngredients.asReadonly();
  private backendURL = 'http://localhost:8080/api'
  private dialog = inject(MatDialog);
  constructor() {
    console.log('ingr service constructed');
    this.fetchIngredients(this.backendURL+'/ingredients');
    console.log(this.allIngredients())
  }

  fetchIngredients(url: string) {
    this.httpClient.get<Ingredient[]>(url).subscribe({
      next: (resData) => {this.allIngredients.set(resData)}
    });
  }

  addIngredient(i: {name:string, unit: string, conversions:{unit: string;quotient: number;}[]; }){
    let candidates: Ingredient[] = [];
    this.allIngredients().forEach((ingr) => 
    {
      if (i.name.substring(0, ingr.name.length)===ingr.name.substring(0, i.name.length)) {
        console.log(i.name + "   " + ingr.name)
        candidates.push(ingr)
    }})

    if (candidates.length !=0) {
      this.openDuplicateDialog(candidates, i)
        .afterClosed()
        .subscribe( (confirmed)=>{
          if (!confirmed) return;
        })
    }
    this.saveIngredient(i);
 }

openDuplicateDialog(duplicates: Ingredient[], newIngredient:{name:string, unit: string, conversions:{unit: string;quotient: number;}[]; }) {
  return this.dialog.open(DuplicateDialogComponent, {
    data: { duplicates, newIngredient }
  });
}

  saveIngredient(i: { name: string; unit: string; conversions: { unit: string; quotient: number; }[]; }) {
    this.httpClient.post<Ingredient>(this.backendURL+'/ingredients', i).subscribe({
      next: (value) => this.fetchIngredients(this.backendURL+'/ingredients'),}
    );
    console.log(i.name+"   " + i.unit);
  } 
  
  findbyId(id: number): any {
    console.log(id);
    this.allIngredients().forEach((i)=> console.log(i.id));
    return this.allIngredients().find((i) => i.id===id)
  }
}
