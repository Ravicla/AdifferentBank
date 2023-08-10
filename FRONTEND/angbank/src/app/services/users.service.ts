import { Injectable } from '@angular/core';
import { User } from '../interfaces/user.interface';
import { USERS } from '../db/user.db';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private arrUsers: User[] = [];
  id: number = 4
  constructor() { 
    this.arrUsers = USERS
  }
  getAll(): User[] {
    return this.arrUsers;
  }
}
