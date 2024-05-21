import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaTipoPistaComponent } from './lista-tipo-pista.component';

describe('ListaTipoPistaComponent', () => {
  let component: ListaTipoPistaComponent;
  let fixture: ComponentFixture<ListaTipoPistaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaTipoPistaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaTipoPistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
