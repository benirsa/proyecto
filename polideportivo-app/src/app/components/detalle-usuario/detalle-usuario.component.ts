import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import { UsuarioService } from '../../services/usuario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-detalle-usuario',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './detalle-usuario.component.html',
  styleUrl: './detalle-usuario.component.css'
})
export class DetalleUsuarioComponent implements OnInit{
  
  usuario!: Usuario;
  id !: any;
  
  constructor(private service: UsuarioService, private route: ActivatedRoute, private router: Router) {  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.service.findById(this.id).subscribe(usuario => this.usuario = usuario);


  }

  cancelar(){
    this.router.navigate(['usuarios'])
  }

  guardar(){
    
  }
}
