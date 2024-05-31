import { Component, OnInit } from '@angular/core';
import { Pista } from '../../models/pista';
import { PistaService } from '../../services/pista.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-pistas-component',
  standalone: true,
  imports: [],
  templateUrl: './lista-pistas.component.html',
  styleUrl: './lista-pistas.component.css'
})
export class ListaPistasComponent implements OnInit{
  
  pistas: Pista[] = [];
  
  constructor(private service: PistaService, private router: Router) {}

  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.pistas = data);
  }

  eliminarPista(id: number): void {
    this.service.delete(id);
  }

  modificarPista(id: any): void {
    this.router.navigate(['pistas/edit', id]);
  }
}
