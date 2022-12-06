import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConteinerComponent } from './conteiner.component';

describe('ConteinerComponent', () => {
  let component: ConteinerComponent;
  let fixture: ComponentFixture<ConteinerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConteinerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConteinerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
