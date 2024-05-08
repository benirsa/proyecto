import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaPistasComponent } from './lista-pistas.component';

describe('ListaPistasComponent', () => {
  let component: ListaPistasComponent;
  let fixture: ComponentFixture<ListaPistasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaPistasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaPistasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
