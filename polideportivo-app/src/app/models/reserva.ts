import { Abonado } from "./abonado";
import { Pista } from "./pista";
import { TipoHora } from "./tipoHora";
import { TipoPista } from "./tipoPista";

export class Reserva{
    id!:number;
    pista!: Pista;
    tipoHora!: TipoHora;
    abonado!: Abonado;
    fechaReserva!: Date;
    precioReserva!: number;
}