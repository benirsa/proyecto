import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuComponent } from './components/menu/menu-component.component';
import { FooterComponent } from './components/footer/footer-component.component';
import { Abonado } from './models/abonado';
import { DetalleUsuarioComponent } from './components/detalle-usuario/detalle-usuario.component';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet,
      MenuComponent,
      FooterComponent,
      DetalleUsuarioComponent,
      ReactiveFormsModule]
})
export class AppComponent{
  title = 'polideportivo-app';
  abonados!: Abonado[];
  
  constructor(){}
}
