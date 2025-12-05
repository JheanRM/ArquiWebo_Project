import { Component } from '@angular/core';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { NgFor } from '@angular/common';
import {DispositivoService} from "../../services/Dispositivo";
import {Dispositivo} from "../../models/dispositivo";


@Component({
  selector: 'app-reporte1',
  standalone: true,
  imports: [
    NgxChartsModule,
    FormsModule,
    MatTableModule,
    NgFor
  ],
  templateUrl: './reporte1.component.html',
  styleUrls: ['./reporte1.component.css']
})
export class Reporte1Component {

  inicio!: number;
  fin!: number;
  chartData: any[] = [];

  // Configuración de ngx-charts
  view: [number, number] = [700, 400];
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = false;
  showXAxisLabel = true;
  showYAxisLabel = true;
  xAxisLabel = 'Dispositivo';
  yAxisLabel = 'Cantidad';
  colorScheme = 'vivid';

  constructor(private dispositivoService: DispositivoService) { }

  filtrar() {
    if (!this.inicio || !this.fin) return;

    this.dispositivoService.listarPorFechas(this.inicio, this.fin).subscribe({
      next: (data: Dispositivo[]) => {
        // Agrupar por nombre de dispositivo y contar
        const counts: { [key: string]: number } = {};
        data.forEach(d => {
          counts[d.name] = (counts[d.name] || 0) + 1;
        });

        // Transformar al formato que ngx-charts necesita
        this.chartData = Object.keys(counts).map(name => ({
          name: name,
          value: counts[name]
        }));
      },
      error: (err) => console.error('Error al cargar datos', err)
    });
  }
}
