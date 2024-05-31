import { Component, OnInit } from '@angular/core';
import { Pista } from '../../models/pista';
import { PistaService } from '../../services/pista.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TipoPista } from '../../models/tipoPista';
import { TipoPistaService } from '../../services/tipo-pista.service';

@Component({
  selector: 'app-detalle-pista',
  standalone: true,
  imports: [],
  templateUrl: './detalle-pista.component.html',
  styleUrl: './detalle-pista.component.css'
})
export class DetallePistaComponent implements OnInit {
  
  pista!: Pista;
  tipoPistas: TipoPista[] = [];
  id!: any;

  constructor(private pistaService: PistaService, private route: ActivatedRoute, private router: Router,
    private tipoPistaService: TipoPistaService) {  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.pistaService.findById(this.id).subscribe(pista => this.pista = pista);
    this.tipoPistaService.findAll().subscribe(tipoPistas => this.tipoPistas = tipoPistas);
  }

  cancelar(){
    this.router.navigate(['pistas']);
  }
}
