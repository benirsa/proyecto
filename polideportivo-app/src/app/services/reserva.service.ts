import { Injectable } from '@angular/core';
import { Reserva } from '../models/reserva';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  private url: string = 'http://localhost:8080/reservas/';

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Reserva[]> {
    return this.httpClient.get<Reserva[]>(this.url);
  } 

  findById(id: number): Observable<Reserva> {
    return this.httpClient.get<Reserva>(this.url + id);
  }

  create(reserva: Reserva): void {

  }

  update(reserva: Reserva): void {

  }

  delete(id: number): void {
    this.httpClient.delete(this.url + id);
  }
}
