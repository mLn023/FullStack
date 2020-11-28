import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Bug } from '../Models/Bug'

@Injectable({
  providedIn: 'root'
})
export class BugServicesService {

  constructor(private http:HttpClient) { }
  

  public createBug(bug: Bug): Observable<Bug>{
    return this.http.post<Bug>(`${environment.url}/bugs/`, bug);
  }

  public getBugList(): Observable<Bug[]>{
    return this.http.get<Bug[]>(`${environment.url}/bugs`)
  }

  public deleteBugs(id:number): Observable<any> {
    return this.http.delete(`${environment.url}/bug/${id}`)
  }
}
