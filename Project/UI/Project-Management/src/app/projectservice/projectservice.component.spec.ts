import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectserviceComponent } from './projectservice.component';

describe('ProjectserviceComponent', () => {
  let component: ProjectserviceComponent;
  let fixture: ComponentFixture<ProjectserviceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectserviceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
