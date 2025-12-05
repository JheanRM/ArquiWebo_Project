import { Injectable } from '@angular/core';
import { environment } from '../../enviroments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Historial} from "../models/Historial";

@Injectable({
  providedIn: 'root'
})
export class ConsumptionHistoryService {

  private url = `${environment.base}/api/ConsumptionHistory`;

  constructor(private http: HttpClient) {}

  // Registrar historial de consumo
  registrar(data: any): Observable<any> {
    return this.http.post(`${this.url}/registrar`, data);
  }

  getByType(type: string): Observable<Historial[]> {
    return this.http.get<Historial[]>(`${this.url}/by-type/${type}`);
  }


  // Obtener por fecha exacta (formato YYYY-MM-DD)
  getByDate(date: string): Observable<any> {
    return this.http.get(`${this.url}/by-date/${date}`);
  }

  // Obtener por valor de consumo
  getByConsumption(consumption: string): Observable<any> {
    return this.http.get(`${this.url}/by-consumption/${consumption}`);
  }

  // Obtener por rango de fechas
  getByDateRange(start: string, end: string): Observable<any> {
    return this.http.get(`${this.url}/by-date-range`, {
      params: { start, end }
    });
  }
  list():Observable<any> {
    return this.http.get<Historial[]>(this.url + "/listar");
  }

}
