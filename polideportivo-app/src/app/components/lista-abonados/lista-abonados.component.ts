import { Component, OnInit } from '@angular/core';
import { Abonado } from '../../models/abonado';
import { AbonadoService } from '../../services/abonado.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lista-abonados',
  standalone: true,
  imports: [],
  templateUrl: './lista-abonados.component.html',
  styleUrl: './lista-abonados.component.css'
})
export class ListaAbonadosComponent implements OnInit{

  abonados: Abonado[] = [];

  constructor (private route: ActivatedRoute, private service: AbonadoService) {   }
  
  ngOnInit(): void {
    this.service.findAll().subscribe(data => this.abonados = data);
  }

  eliminarAbonado(id: number): void {
    this.service.delete(id);
  }

  modificarAbonado(abonado: Abonado): void{
    let id: number = abonado.id;
    this.route.paramMap.subscribe(params => {
      const id: number = +(params.get('id') || 0);

      if(id > 0){
        
      }
    });
  }
}
