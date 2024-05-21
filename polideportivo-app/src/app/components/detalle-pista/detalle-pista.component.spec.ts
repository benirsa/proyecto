import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallePistaComponent } from './detalle-pista.component';

describe('DetallePistaComponent', () => {
  let component: DetallePistaComponent;
  let fixture: ComponentFixture<DetallePistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetallePistaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetallePistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
