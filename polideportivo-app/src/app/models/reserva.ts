import { Abonado } from "./abonado";
import { Pista } from "./pista";
import { TipoHora } from "./tipoHora";

export class Reserva{
    id!:number;
    pista!: Pista;
    tipoHora!: TipoHora;
    abonado!: Abonado;
    fechaReserva!: Date;
    precioReserva!: number;
}