import { Component, OnInit } from '@angular/core';
import { Pista } from '../../models/pista';
import { PistaService } from '../../services/pista.service';

@Component({
  selector: 'app-lista-pistas-component',
  standalone: true,
  imports: [],
  templateUrl: './lista-pistas.component.html',
  styleUrl: './lista-pistas.component.css'
})
export class ListaPistasComponent implements OnInit{
  
  pistas: Pista[] = [];
  
  constructor(private service: PistaService) {}

  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.pistas = data);
  }

  eliminarPista(id: number): void {

  }

  modificarPista(pista: Pista): void {

  }
}
