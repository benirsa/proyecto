import { Injectable } from '@angular/core';
import { Abonado } from '../models/abonado';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AbonadoService {

  private url: string = 'http://localhost:8080/abonados/';

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Abonado[]> {
    return this.httpClient.get<Abonado[]>(this.url);
  }

  findById(id:number): Observable<Abonado> {
    return this.httpClient.get<Abonado>(this.url + id);
  }

  /*create(abonado: Abonado): Observable<Abonado> {
    
  }

  update(abonado: Abonado): Observable<Abonado> {
    
  }*/

  delete(id: number): void {
    this.httpClient.delete(this.url + id);
  }
}
