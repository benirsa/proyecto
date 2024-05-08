import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuComponent } from './menu-component/menu-component.component';
import { LoginComponent } from './login-component/login-component.component';
import { FooterComponent } from './footer-component/footer-component.component';
import { ListaPistasComponent } from './lista-pistas-component/lista-pistas.component';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, MenuComponent, LoginComponent, FooterComponent, ListaPistasComponent]
})
export class AppComponent {
  title = 'polideportivo-app';
}
