import { Component, OnInit } from '@angular/core';
import { TipoPista } from '../../models/tipoPista';
import { TipoPistaService } from '../../services/tipo-pista.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-tipo-pista',
  standalone: true,
  imports: [],
  templateUrl: './lista-tipo-pista.component.html',
  styleUrl: './lista-tipo-pista.component.css'
})
export class ListaTipoPistaComponent implements OnInit{
  
  tipoPistas: TipoPista[] = [];
  
  constructor(private service: TipoPistaService, private router: Router) {}
  
  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.tipoPistas = data);
  }

  eliminarTipoPista(id: number): void {
    this.service.delete(id);
  }
  
  modificarTipoPista(id: any): void {
    this.router.navigate(['tipo-pista/edit', id]);
  }
}
