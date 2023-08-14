import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../interfaces/login.interface';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl: string = 'http://localhost:8080/dbbank/api/users/';
  constructor(private httpClient: HttpClient) {
  }

  login(pLogin: Login): Promise<any> {  
    return lastValueFrom(this.httpClient.post<Login>(this.baseUrl+'login', pLogin))
  }
}
