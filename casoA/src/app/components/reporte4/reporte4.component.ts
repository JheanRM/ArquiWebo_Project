
import { Component } from '@angular/core';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { FormsModule } from '@angular/forms';
import { NgFor } from '@angular/common';
import {TransactionsService} from "../../services/Puntos";


@Component({
  selector: 'app-reporte4',
  templateUrl: './reporte4.component.html',
  standalone: true,
  imports: [
    NgxChartsModule, FormsModule, NgFor
  ],
  styleUrls: ['./reporte4.component.css']
})
export class Reporte4Component {

  promedioData: { name: string, value: number }[] = [];
  totalData: { name: string, value: number }[] = [];

  // Opciones del gráfico
  view: [number, number] = [700, 400];
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabelPromedio = 'Cliente';
  showYAxisLabel = true;
  yAxisLabelPromedio = 'Promedio de puntos';
  colorScheme = 'vivid';

  constructor(private transactionsService: TransactionsService) {}

  ngOnInit(): void {
    this.cargarPromedio();
    this.cargarTotal();
  }

  cargarPromedio(): void {
    this.transactionsService.promedioPuntos().subscribe(data => {
      this.promedioData = data.map(d => ({
        name: d.nombreCliente,
        value: d.promedioPuntos
      }));
    });
  }

  cargarTotal(): void {
    this.transactionsService.totalPuntos().subscribe(data => {
      this.totalData = data.map(d => ({
        name: d.nombreCliente,
        value: d.totalPuntos
      }));
    });
  }
}
