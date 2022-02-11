import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Trainer } from './trainer';
import { Observable } from 'rxjs';
import { Pokemon } from './pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokedexService {
  
  url:string = "https://pokeapi.co/api/v2/pokemon/";
  url2:string = "http://localhost:8083/data/";

  constructor(private http:  HttpClient) { }

  getAllTrainers() {

    return this.http.get(this.url2 + "trainer") as Observable<Trainer[]>;
   
  }

  getTrainer(id:number){
    return this.http.get(this.url2 + "trainer/" + id) as Observable<Trainer>; 
  }

  addTrainer(t:Trainer): Observable<Trainer[]> {
    return this.http.post<Trainer[]>(this.url2 + "trainer", t);
  }

  getPoke(id:number): Observable<any> {
    return this.http.get(this.url + id) as Observable<any>;
  }

  addPoke(p:Pokemon): Observable<Trainer[]> {

    return this.http.post<Trainer[]>(this.url2 + "pokemon", p)
    
  }
}
