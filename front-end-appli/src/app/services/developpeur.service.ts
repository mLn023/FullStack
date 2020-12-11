import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Developpeur } from '../models/Developpeur';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class DeveloppeurService {

  constructor(private http: HttpClient) { }

  public getDeveloppeursList(): Observable<Developpeur[]> {
    return this.http.get<Developpeur[]>(`${environment.url}/devs`);
  }

  public getDeveloppeurById(id: number): Observable<Developpeur> {
    return this.http.get<Developpeur>(`${environment.url}/devs/${id}`);
  }

  public deleteDeveloppeur(id: number): Observable<any> {
    return this.http.delete(`${environment.url}/devs/${id}`);
  }

  public createDeveloppeur(developpeur: Developpeur): Observable<Developpeur> {
    return this.http.post<Developpeur>(`${environment.url}/devs`, developpeur);
  }
}
