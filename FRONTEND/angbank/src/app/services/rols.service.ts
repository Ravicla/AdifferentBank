import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Rol } from '../interfaces/rol.interface';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RolsService {

  baseUrl: string = 'http://localhost:8080/dbbank/api/rols/';
  constructor(private httpClient: HttpClient) {
  }

  create(pRol: Rol): Promise<any> {  
    return lastValueFrom(this.httpClient.post<Rol>(this.baseUrl+'save', pRol))
  }

  getAll(): Promise<any> {
    return lastValueFrom(this.httpClient.get<any>(`${this.baseUrl+'all'}`))
  }

  getById(pId: number): Promise<any> {
    return lastValueFrom(this.httpClient.get<any>(`${this.baseUrl}${pId}`))
  }

  update(pRol: Rol): Promise<any> {
    return lastValueFrom(this.httpClient.put<any>(`${this.baseUrl+'update'}`, pRol))
  }

  delete(pId: number): Promise<any> {
    return lastValueFrom(this.httpClient.delete<any>(`${this.baseUrl+'delete/'}${pId}`))
  }
}
