import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private url: string = 'http://localhost:8080/usuarios/';

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Usuario[]> {
    return this.httpClient.get<Usuario[]>(this.url);
  }

  findById(id: number): Observable<Usuario> {
    return this.httpClient.get<Usuario>(this.url + id);
  }

  create(usuario: Usuario): void {

  }

  update(usuario: Usuario): void {

  }

  delete(id: number): void {
    this.httpClient.delete(this.url + id);
  }
}
