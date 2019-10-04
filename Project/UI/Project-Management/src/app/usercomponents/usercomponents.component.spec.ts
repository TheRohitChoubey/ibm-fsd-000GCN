import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsercomponentsComponent } from './usercomponents.component';

describe('UsercomponentsComponent', () => {
  let component: UsercomponentsComponent;
  let fixture: ComponentFixture<UsercomponentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsercomponentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsercomponentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
