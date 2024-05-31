import { Component, OnInit } from '@angular/core';
import { Abonado } from '../../models/abonado';
import { AbonadoService } from '../../services/abonado.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detalle-abonado',
  standalone: true,
  imports: [],
  templateUrl: './detalle-abonado.component.html',
  styleUrl: './detalle-abonado.component.css'
})
export class DetalleAbonadoComponent implements OnInit{

  abonado!: Abonado;
  id!: any;

  constructor(private service: AbonadoService, private route: ActivatedRoute, private router: Router) {  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.service.findById(this.id).subscribe(abonado => this.abonado = abonado);
  }

  cancelar(){
    this.router.navigate(['abonados']);
  }
}
