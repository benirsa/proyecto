import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../models/reserva';
import { ReservaService } from '../../services/reserva.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-reservas',
  standalone: true,
  imports: [],
  templateUrl: './lista-reservas.component.html',
  styleUrl: './lista-reservas.component.css'
})
export class ListaReservasComponent implements OnInit{
  
  reservas: Reserva[] = [];
  
  constructor(private service: ReservaService, private router: Router) {}
  
  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.reservas = data);
  }

  eliminarReserva(id:number):void {
    this.service.delete(id);
  }

  modificarReserva(id: any): void {
    this.router.navigate(['reservas/edit', id]);
  }
}
