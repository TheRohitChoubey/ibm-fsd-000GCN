import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DepositeOtherComponent } from './deposite-other.component';

describe('DepositeOtherComponent', () => {
  let component: DepositeOtherComponent;
  let fixture: ComponentFixture<DepositeOtherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DepositeOtherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DepositeOtherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
