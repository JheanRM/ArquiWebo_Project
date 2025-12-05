import { Injectable } from '@angular/core';
import {environment} from "../../enviroments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Dispositivo} from "../models/dispositivo";

@Injectable({
  providedIn: 'root'
})
export class DispositivoService {
  private url = `${environment.base}/api/device`;

  constructor(private http: HttpClient) {}

  // Registrar dispositivo
  registrar(data: any): Observable<any> {
    return this.http.post(`${this.url}/registrar`, data);
  }

  // Listar dispositivos por fecha (usa query params)
  listarPorFechas(inicio: number, fin: number): Observable<any[]> {
    return this.http.get<Dispositivo[]>(`${this.url}/por-fechas?inicio=${inicio}&fin=${fin}`);
  }

  // Modificar dispositivo
  modificar(data: any): Observable<void> {
    return this.http.put<void>(`${this.url}`, data);
  }

  // Eliminar por ID
  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
