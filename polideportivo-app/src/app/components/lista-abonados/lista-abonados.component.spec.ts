import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaAbonadosComponent } from './lista-abonados.component';

describe('ListaAbonadosComponent', () => {
  let component: ListaAbonadosComponent;
  let fixture: ComponentFixture<ListaAbonadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaAbonadosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaAbonadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
