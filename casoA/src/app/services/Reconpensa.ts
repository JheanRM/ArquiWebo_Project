import { Injectable } from '@angular/core';
import {environment} from "../../enviroments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Reconpensas} from "../models/reconpensas";
import {RewardsByClient} from "../models/RewardsByClient";

@Injectable({
  providedIn: 'root'
})
export class RewardsService {

  private url = `${environment.base}/api/Recompensa`;

  constructor(private http: HttpClient) {}

  // Registrar una recompensa
  registrar(data: any): Observable<any> {
    return this.http.post(`${this.url}/Registrar`, data);
  }

  // Obtener recompensas por cliente
  getRewardsByClient(name: string): Observable<RewardsByClient[]> {
    return this.http.get<RewardsByClient[]>(`${this.url}/find-client/${name}`);
  }

  // Modificar una recompensa
  modificar(data: Reconpensas): Observable<void> {
    return this.http.put<void>(`${this.url}`, data);
  }

  // Eliminar una recompensa por ID
  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }

  list():Observable<any> {
    return this.http.get<Reconpensas[]>(this.url + "/listar");
  }

}
