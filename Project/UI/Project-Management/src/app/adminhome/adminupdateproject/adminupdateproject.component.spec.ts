import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminupdateprojectComponent } from './adminupdateproject.component';

describe('AdminupdateprojectComponent', () => {
  let component: AdminupdateprojectComponent;
  let fixture: ComponentFixture<AdminupdateprojectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminupdateprojectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminupdateprojectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
