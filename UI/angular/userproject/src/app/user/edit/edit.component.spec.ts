import {
    async,
    ComponentFixture,
    TestBed,
    fakeAsync,
    tick
  } from "@angular/core/testing";
  
  import { EditComponent } from "./edit.component";
  import { UserService } from "../user.service";
  
  describe("EditComponent", () => {
    let component: EditComponent;
    let fixture: ComponentFixture<EditComponent>;
    let uService: UserService;
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        declarations: [ EditComponent]
      }).compileComponents();
    }));
  
    beforeEach(() => {
      fixture = TestBed.createComponent(EditComponent);
      component = fixture.componentInstance;
      // Inject Service in Component
      uService = fixture.debugElement.injector.get(UserService);
      fixture.detectChanges();
    });
  
    
    it('should create', () => {
      expect(component).toBeTruthy();
    });
  });
  