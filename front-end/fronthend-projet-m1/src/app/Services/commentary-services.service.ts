import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Commentary } from '../Models/Commentary'

@Injectable({
  providedIn: 'root'
})
export class CommentaryServicesService {

  constructor(private http: HttpClient) { }

  public createCommentary(commentary: Commentary): Observable<Commentary>{
    return this.http.post<Commentary>(`${environment.url}/commentary/`, commentary);
  }

  public getCommentaryList(): Observable<Commentary[]>{
    return this.http.get<Commentary[]>(`${environment.url}/commentaries`);
  }

  public deleteCommentary(id: number): Observable<any> {
    return this.http.delete(`${environment.url}/commentary/`);
  }
}
