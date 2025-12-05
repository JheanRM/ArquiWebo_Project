import { Component, OnInit } from '@angular/core';
import { ChartDataset, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { CertificationsService } from '../../../services/certifications.service';

@Component({
  selector: 'app-canticertiuser',
  standalone: true,
  imports: [BaseChartDirective],
  templateUrl: './canticertiuser.component.html',
  styleUrl: './canticertiuser.component.css'
})
export class CanticertiuserComponent implements OnInit {
  barChartOptions = {
    responsive: true,
  };
  
  barChartLabels: string[] = [];
  //barChartType: ChartType = 'pie';
  barChartType: ChartType = 'polarArea';
  //barChartType: ChartType = 'line';
  //barChartType: ChartType = 'bar';
  //barChartType: ChartType = 'polarArea';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];

  constructor(public cS: CertificationsService){}

  ngOnInit(): void {
    this.cS.getCantCerti().subscribe((data) => {
      this.barChartLabels = data.map((item) => item.username);
      this.barChartData = [
        {
          data: data.map((item) => item.quantity),
          label: 'Cantidad de certificaciones',
          backgroundColor: [
            'rgba(192, 80, 77, 0.5)', // rojo semi-transparente
            'rgba(192, 80, 77, 0.5)', // rojo semi-transparente
            'rgba(192, 80, 77, 0.5)', // rojo semi-transparente
          ],
          borderColor: 'rgba(173, 216, 230, 1)',
          borderWidth: 1,
        }
      ];
    });
  }

}
