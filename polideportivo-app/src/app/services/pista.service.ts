import { Injectable } from '@angular/core';
import { Pista } from '../models/pista';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PistaService {

  private url: string = 'http://localhost:8080/pistas/';

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Pista[]> {
    return this.httpClient.get<Pista[]>(this.url);
  }

  findById(id: number): Observable<Pista> {
    return this.httpClient.get<Pista>(this.url + id);
  }

  create(pista: Pista): void {

  }

  update(pista: Pista): void{

  }

  delete(id: number): void {
    this.httpClient.delete(this.url + id);
  }
}
