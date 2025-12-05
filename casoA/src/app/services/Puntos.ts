import { Injectable } from '@angular/core';
import {environment} from "../../enviroments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PromedioPuntosPorCliente} from "../models/PromedioPuntosPorCliente";
import {TotalPuntosCliente} from "../models/TotalPuntosCliente";

@Injectable({
  providedIn: 'root'
})
export class TransactionsService {

  private url = `${environment.base}/api/Transacciones`;

  constructor(private http: HttpClient) {}

  // Registrar una transacción
  registrar(data: any): Observable<any> {
    return this.http.post(`${this.url}/registrar`, data);
  }

  // Obtener promedio de puntos por cliente
  promedioPuntos(): Observable<PromedioPuntosPorCliente[]> {
    return this.http.get<PromedioPuntosPorCliente[]>(`${this.url}/promedio-puntos`);
  }

  totalPuntos(): Observable<TotalPuntosCliente[]> {
    return this.http.get<TotalPuntosCliente[]>(`${this.url}/total-puntos`);
  }
}
