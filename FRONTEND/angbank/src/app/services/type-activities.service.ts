import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { TypeActivity } from '../interfaces/type-activity.interface';

@Injectable({
  providedIn: 'root'
})
export class TypeActivitiesService {

  baseUrl: string = 'http://localhost:8080/dbbank/api/typeActivities/';
  constructor(private httpClient: HttpClient) {
  }

  create(pTypeActivity: TypeActivity): Promise<any> {  
    return lastValueFrom(this.httpClient.post<TypeActivity>(this.baseUrl+'save', pTypeActivity))
  }

  getAll(): Promise<any> {
    return lastValueFrom(this.httpClient.get<any>(`${this.baseUrl+'all'}`))
  }

  getById(pId: number): Promise<any> {
    return lastValueFrom(this.httpClient.get<any>(`${this.baseUrl}${pId}`))
  }

  update(pTypeActivity: TypeActivity): Promise<any> {
    return lastValueFrom(this.httpClient.put<any>(`${this.baseUrl+'update'}`, pTypeActivity))
  }

  delete(pId: number): Promise<any> {
    return lastValueFrom(this.httpClient.delete<any>(`${this.baseUrl+'delete/'}${pId}`))
  }
}
