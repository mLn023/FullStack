import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Developper } from '../Models/Developper'

@Injectable({
  providedIn: 'root'
})
export class DevelopperServiceService {

  constructor(private http: HttpClient) {}

  public createDevelopper(developper: Developper): Observable<Developper>{
    return this.http.post<Developper>(`${environment.url}/devs/`, developper);
  }

  public getDeveloppersList(): Observable<Developper[]>{
    return this.http.get<Developper[]>(`${environment.url}/devs/`);
  }

  public deleteDeveloppers(id: number): Observable<any>{
    return this.http.delete(`${environment.url}/devs/${id}`);
  }

}
