import { Component } from '@angular/core';
import { ChartDataset, ChartType } from 'chart.js';
import { CertificationsService } from '../../../services/certifications.service';
import { BaseChartDirective } from 'ng2-charts';

@Component({
  selector: 'app-montoinvuser',
  standalone: true,
  imports: [BaseChartDirective],
  templateUrl: './montoinvuser.component.html',
  styleUrl: './montoinvuser.component.css'
})
export class MontoinvuserComponent {
  barChartOptions = {
    responsive: true,
  };
  
  barChartLabels: string[] = [];
  //barChartType: ChartType = 'pie';
  barChartType: ChartType = 'line';
  //barChartType: ChartType = 'line';
  //barChartType: ChartType = 'bar';
  //barChartType: ChartType = 'polarArea';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];

  constructor(public cS: CertificationsService){}

  ngOnInit(): void {
      this.cS.getMonto().subscribe((data) => {
        this.barChartLabels = data.map((item) => item.username);
        this.barChartData = [
          {
            data: data.map((item) => item.quantity),
            label: 'Cantidad de Monto Invertido por Usuario',
            backgroundColor: [
              'rgba(192, 80, 77, 0.5)', // rojo semi-transparente
              'rgba(192, 80, 77, 0.5)', // rojo semi-transparente
              'rgba(192, 80, 77, 0.5)', // rojo semi-transparente
            ],
            borderColor: 'rgba(173, 216, 230, 1)',
            borderWidth: 1,
          }
        ]
      })
  }
}
