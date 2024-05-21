import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-lista-usuarios',
  standalone: true,
  imports: [],
  templateUrl: './lista-usuarios.component.html',
  styleUrl: './lista-usuarios.component.css'
})
export class ListaUsuariosComponent implements OnInit{
  
  usuarios: Usuario[] = [];
  
  constructor(private service: UsuarioService) {}
  
  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.usuarios = data);
  }

  eliminarUsuario(id: number){
    
  }

  modificarUsuario(usuario: Usuario): void{
    
  }
}
