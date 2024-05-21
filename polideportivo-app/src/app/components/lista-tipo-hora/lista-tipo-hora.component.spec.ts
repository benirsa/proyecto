import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaTipoHoraComponent } from './lista-tipo-hora.component';

describe('ListaTipoHoraComponent', () => {
  let component: ListaTipoHoraComponent;
  let fixture: ComponentFixture<ListaTipoHoraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaTipoHoraComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaTipoHoraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
