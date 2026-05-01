export interface Ingredient {
    id: number;
    name: string;
    unit: string;
    conversions: {unit: string; quotient: number}[] ;
    
}