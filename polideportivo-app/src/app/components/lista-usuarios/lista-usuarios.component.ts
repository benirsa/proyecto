import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import { UsuarioService } from '../../services/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-usuarios',
  standalone: true,
  imports: [],
  templateUrl: './lista-usuarios.component.html',
  styleUrl: './lista-usuarios.component.css'
})
export class ListaUsuariosComponent implements OnInit{
  
  usuarios: Usuario[] = [];
  
  constructor(private service: UsuarioService, private router: Router) {}
  
  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.usuarios = data);
  }

  eliminarUsuario(id: number){
    this.service.delete(id);
  }

  modificarUsuario(id: number): void{
    this.router.navigate(['usuarios/edit', id]);
  }
}
