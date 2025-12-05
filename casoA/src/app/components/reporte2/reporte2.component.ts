import { Component } from '@angular/core';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { FormsModule } from '@angular/forms';
import { NgFor } from '@angular/common';

import { Historial } from '../../models/Historial';
import {ConsumptionHistoryService} from "../../services/Historial";

@Component({
  selector: 'app-reporte2',
  standalone: true,
  imports: [
    NgxChartsModule, FormsModule, NgFor
  ],
  templateUrl: './reporte2.component.html',
  styleUrl: './reporte2.component.css'
})
export class Reporte2Component {
  chartData: any[] = [];
  filterType: string = '';
  filterDate: string = '';
  filterStartDate: string = '';
  filterEndDate: string = '';
  filterConsumption: string = '';

  // Configuración del gráfico
  view: [number, number] = [800, 400];
  showXAxis = true;
  showYAxis = true;
  showLegend = false;
  showXAxisLabel = true;
  showYAxisLabel = true;
  xAxisLabel = 'Tipo';
  yAxisLabel = 'Cantidad';
  colorScheme = 'vivid';

  constructor(private service: ConsumptionHistoryService) {}

  // Filtrar por tipo
  filtrarPorTipo() {
    if (!this.filterType) return;
    this.service.getByType(this.filterType).subscribe(data => this.mapToChart(data));
  }

  // Filtrar por fecha exacta
  filtrarPorFecha() {
    if (!this.filterDate) return;
    this.service.getByDate(this.filterDate).subscribe(data => this.mapToChart(data));
  }

  // Filtrar por rango de fechas
  filtrarPorRango() {
    if (!this.filterStartDate || !this.filterEndDate) return;
    this.service.getByDateRange(this.filterStartDate, this.filterEndDate).subscribe(data => this.mapToChart(data));
  }

  // Filtrar por consumo
  filtrarPorConsumo() {
    if (!this.filterConsumption) return;
    this.service.getByConsumption(this.filterConsumption).subscribe(data => this.mapToChart(data));
  }
  private mapToChart(data: Historial[]) {
    const counts: { [key: string]: number } = {};
    data.forEach(d => {
      const type = d.type || 'Desconocido';
      counts[type] = (counts[type] || 0) + 1;
    });

    this.chartData = Object.keys(counts).map(key => ({
      name: key,
      value: counts[key]
    }));
  }

}
