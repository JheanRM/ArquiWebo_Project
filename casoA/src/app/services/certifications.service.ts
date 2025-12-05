import { Injectable } from '@angular/core';
import { environment } from '../../enviroments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CantCertiUserDTO } from '../models/cantcertiUserDTO';
import { MontoInvUserDTO } from '../models/montoinvUserDTO';



const base_url = environment.base;
@Injectable({
  providedIn: 'root'
})
export class CertificationsService {
  private url = `${base_url}/certifications`;
  constructor(private httpClient: HttpClient) {}

  getCantCerti(): Observable<CantCertiUserDTO[]>{
    return this.httpClient.get<CantCertiUserDTO[]>(`${this.url}/apellido/certificationsquery`);
  }
  getMonto(): Observable<MontoInvUserDTO[]>{
    return this.httpClient.get<MontoInvUserDTO[]>(`${this.url}/apellido/montoinvquery`);
  }
}
