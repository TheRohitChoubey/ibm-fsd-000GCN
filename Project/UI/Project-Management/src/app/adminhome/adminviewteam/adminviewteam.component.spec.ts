import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminviewteamComponent } from './adminviewteam.component';

describe('AdminviewteamComponent', () => {
  let component: AdminviewteamComponent;
  let fixture: ComponentFixture<AdminviewteamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminviewteamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminviewteamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
