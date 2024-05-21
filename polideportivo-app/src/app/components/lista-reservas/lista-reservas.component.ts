import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../models/reserva';
import { ReservaService } from '../../services/reserva.service';

@Component({
  selector: 'app-lista-reservas',
  standalone: true,
  imports: [],
  templateUrl: './lista-reservas.component.html',
  styleUrl: './lista-reservas.component.css'
})
export class ListaReservasComponent implements OnInit{
  
  reservas: Reserva[] = [];
  
  constructor(private service: ReservaService) {}
  
  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.reservas = data
      console.log(this.reservas)
    });
  }

  eliminarReserva(id:number):void {
    
  }

  modificarReserva(reserva: Reserva): void {

  }
}
