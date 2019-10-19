import { TestBed } from '@angular/core/testing';

import { UserService } from './user.service';

describe('UserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));
  let service:UserService;
  it('should be created', () => {
    const service: UserService = TestBed.get(UserService);
    expect(service).toBeTruthy();
  });

  it('should return all users',()=>{
    let user;
    service.getUserByEmail(data=>{
        user = data
    },"rohitc.choubey@gmail.com");
    expect(user.length).not.toBeNull();

  });
});
