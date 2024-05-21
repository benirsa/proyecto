import { Injectable } from '@angular/core';
import { TipoHora } from '../models/tipoHora';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipoHoraService {

  private url: string = 'http://localhost:8080/tipo-hora/';

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<TipoHora[]> {
    return this.httpClient.get<TipoHora[]>(this.url);
  }

  findById(id: number): Observable<TipoHora> {
    return this.httpClient.get<TipoHora>(this.url + id);
  }

  create(tipoHora: TipoHora): void {

  }

  update(tipoHora: TipoHora): void {

  }

  delete(id: number): void{
    this.httpClient.delete(this.url + id);
  }
}
