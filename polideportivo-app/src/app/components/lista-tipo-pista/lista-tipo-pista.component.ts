import { Component, OnInit } from '@angular/core';
import { TipoPista } from '../../models/tipoPista';
import { TipoPistaService } from '../../services/tipo-pista.service';

@Component({
  selector: 'app-lista-tipo-pista',
  standalone: true,
  imports: [],
  templateUrl: './lista-tipo-pista.component.html',
  styleUrl: './lista-tipo-pista.component.css'
})
export class ListaTipoPistaComponent implements OnInit{
  
  tipoPistas: TipoPista[] = [];
  
  constructor(private service: TipoPistaService) {}
  
  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.tipoPistas = data);
  }

  eliminarTipoPista(id: number): void {
    
  }
  
  modificarTipoPista(tipoPista: TipoPista): void {

  }
}
