import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleTipoPistaComponent } from './detalle-tipo-pista.component';

describe('DetalleTipoPistaComponent', () => {
  let component: DetalleTipoPistaComponent;
  let fixture: ComponentFixture<DetalleTipoPistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalleTipoPistaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetalleTipoPistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
