import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleAbonadoComponent } from './detalle-abonado.component';

describe('DetalleAbonadoComponent', () => {
  let component: DetalleAbonadoComponent;
  let fixture: ComponentFixture<DetalleAbonadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalleAbonadoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetalleAbonadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
