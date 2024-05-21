import { Injectable } from '@angular/core';
import { TipoPista } from '../models/tipoPista';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipoPistaService {

  private url: string = 'http://localhost:8080/tipo-pista/';

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<TipoPista[]> {
    return this.httpClient.get<TipoPista[]>(this.url);
  }

  findById(id: number): Observable<TipoPista> {
    return this.httpClient.get<TipoPista>(this.url + id);
  }

  create(tipoPista: TipoPista): void {

  }

  update(tipoPista: TipoPista): void {

  }

  delete(id: number): void {
    this.httpClient.delete(this.url + id);
  }
}
