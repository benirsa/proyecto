import { Component, OnInit } from '@angular/core';
import { TipoHora } from '../../models/tipoHora';
import { TipoHoraService } from '../../services/tipo-hora.service';

@Component({
  selector: 'app-lista-tipo-hora',
  standalone: true,
  imports: [],
  templateUrl: './lista-tipo-hora.component.html',
  styleUrl: './lista-tipo-hora.component.css'
})
export class ListaTipoHoraComponent implements OnInit{
  
  horas: TipoHora[] = [];
  
  constructor(private service: TipoHoraService) {}

  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.horas = data);
  }

  eliminarHora(id:number): void {
    
  } 

  modificarHora(hora: TipoHora): void {

  }
}
