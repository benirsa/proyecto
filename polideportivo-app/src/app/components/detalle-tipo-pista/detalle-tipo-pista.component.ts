import { Component, OnInit } from '@angular/core';
import { TipoPista } from '../../models/tipoPista';
import { TipoPistaService } from '../../services/tipo-pista.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-detalle-tipo-pista',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './detalle-tipo-pista.component.html',
  styleUrl: './detalle-tipo-pista.component.css'
})
export class DetalleTipoPistaComponent implements OnInit {

  tipoPista!: TipoPista;
  id!: any;

  miFormulario!: FormGroup;

  urlActual!: any;

  constructor(private service: TipoPistaService, private route: ActivatedRoute, private router: Router,
    private fb: FormBuilder) {  }

  ngOnInit(): void {
    
    this.urlActual = this.route.url;
    console.log(this.urlActual)
    this.id = this.route.snapshot.paramMap.get('id');
        if(this.urlActual.value[1].path == 'edit'){
          this.service.findById(this.id).subscribe(tipoPista =>{ 
            this.tipoPista = tipoPista; 
            
            this.miFormulario = this.fb.group({
              descripcion: [this.tipoPista.descripcion],
              precio: [this.tipoPista.precio]
            });
          });
        }
        else{
          this.tipoPista = new TipoPista();
          this.miFormulario = this.fb.group({
            descripcion: [this.tipoPista.descripcion],
            precio: [this.tipoPista.precio]
          });
        }
    
  }

  guardar(){
    this.tipoPista.precio = this.miFormulario.get('precio')!.value;
    this.tipoPista.descripcion = this.miFormulario.get('descripcion')!.value;
  }

  cancelar(){
    this.router.navigate(['tipo-pista']);
  }
}
