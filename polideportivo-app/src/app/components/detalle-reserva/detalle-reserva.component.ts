import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../models/reserva';
import { ReservaService } from '../../services/reserva.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TipoPista } from '../../models/tipoPista';
import { TipoPistaService } from '../../services/tipo-pista.service';
import { TipoHora } from '../../models/tipoHora';
import { TipoHoraService } from '../../services/tipo-hora.service';
import { AbonadoService } from '../../services/abonado.service';
import { Abonado } from '../../models/abonado';

@Component({
  selector: 'app-detalle-reserva',
  standalone: true,
  imports: [],
  templateUrl: './detalle-reserva.component.html',
  styleUrl: './detalle-reserva.component.css'
})
export class DetalleReservaComponent implements OnInit {
  
  reserva!: Reserva;
  pistas: TipoPista[] = [];
  tipoHoras: TipoHora[] = [];
  abonados: Abonado[] = [];
  id!: any;

  constructor(private reservaService: ReservaService, private route: ActivatedRoute,
    private tipoPistaService: TipoPistaService, private tipoHoraService: TipoHoraService,
    private abonadoService: AbonadoService, private router: Router) {  }
  
  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.reservaService.findById(this.id).subscribe(reserva => this.reserva = reserva);
    this.tipoPistaService.findAll().subscribe(tipoPistas => this.pistas = tipoPistas);
    this.tipoHoraService.findAll().subscribe(tipoHoras => this.tipoHoras = tipoHoras);
    this.abonadoService.findAll().subscribe(abonados => this.abonados = abonados);
  }

  cancelar(){
    this.router.navigate(['reservas']);
  }
}
