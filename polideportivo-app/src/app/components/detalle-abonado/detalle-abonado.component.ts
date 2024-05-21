import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Abonado } from '../../models/abonado';

@Component({
  selector: 'app-detalle-abonado',
  standalone: true,
  imports: [],
  templateUrl: './detalle-abonado.component.html',
  styleUrl: './detalle-abonado.component.css'
})
export class DetalleAbonadoComponent {

  @Input() abonado!: Abonado;

  @Output() crearAbonadoEventEmitter: EventEmitter<Abonado> = new EventEmitter();
  @Output() editarAbonadoEventEmitter: EventEmitter<Abonado> = new EventEmitter();
}
