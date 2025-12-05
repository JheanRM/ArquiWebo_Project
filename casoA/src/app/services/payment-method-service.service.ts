import { Injectable } from '@angular/core';
import {environment} from "../../enviroments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Reconpensas} from "../models/reconpensas";
import {PaymentMethod} from "../models/PaymentMethod";


@Injectable({
  providedIn: 'root'
})
export class PaymentMethodServiceService {

  private url = `${environment.base}/api/payment`;

  constructor(private http: HttpClient) {}

  // Registrar método de pago
  registrar(data: any): Observable<any> {
    return this.http.post(`${this.url}/registrar`, data);
  }

  // Listar clientes con tarjeta vencida
  listarClientesTarjetasVencidas(): Observable<PaymentMethod[]> {
    return this.http.get<PaymentMethod[]>(`${this.url}/clientes-tarjetas-vencidas`);
  }


  // Modificar
  modificar(data: any): Observable<void> {
    return this.http.put<void>(`${this.url}`, data);
  }

  // Eliminar por ID
  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }

  list():Observable<any> {
    return this.http.get<PaymentMethod[]>(this.url + "/listar");
  }

}

