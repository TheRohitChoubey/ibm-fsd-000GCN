import {
  async,
  ComponentFixture,
  TestBed,
  fakeAsync,
  tick
} from "@angular/core/testing";

import { UserAddComponent } from "./user-add.component";
import { UserService } from "../user.service";

describe("UserAddComponent", () => {
  let component: UserAddComponent;
  let fixture: ComponentFixture<UserAddComponent>;
  let uService: UserService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAddComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAddComponent);
    component = fixture.componentInstance;
    // Inject Service in Component
    uService = fixture.debugElement.injector.get(UserService);
    fixture.detectChanges();
  });

  
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("should add a new user", fakeAsync(() => {
    let user = [{
      id: 5,
      name: "Rohit",
      age: 23
    }]
    const _users = component.addUser(user);

    const _usersFromService = uService.getUsers();
    tick(10);
    console.log("From getUser : "+_usersFromService);
    console.log("From addUser : "+_users);
    expect(_usersFromService).toBe(_users);
  }));
});
