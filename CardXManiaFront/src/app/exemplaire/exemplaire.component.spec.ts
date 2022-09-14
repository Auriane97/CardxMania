import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExemplaireComponent } from './exemplaire.component';

describe('ExemplaireComponent', () => {
  let component: ExemplaireComponent;
  let fixture: ComponentFixture<ExemplaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExemplaireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExemplaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
