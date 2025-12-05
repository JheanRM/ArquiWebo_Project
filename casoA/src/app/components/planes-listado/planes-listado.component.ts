import { Component, ViewChild, inject } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { Router } from '@angular/router';
import { CurrencyPipe, DatePipe } from '@angular/common';
import { PaymentMethod } from '../../models/PaymentMethod';
import { PaymentMethodServiceService } from '../../services/payment-method-service.service';

@Component({
  selector: 'app-planes-listado',
  standalone: true,
  imports: [
    MatTableModule,
    MatPaginatorModule,
    DatePipe,
    CurrencyPipe
  ],
  templateUrl: './planes-listado.component.html',
  styleUrls: ['./planes-listado.component.css']
})
export class PlanesListadoComponent {
  lista: PaymentMethod[] = [];
  displayedColumns: string[] = ['nameTitular', 'numberCard', 'cv', 'expiration', 'price'];
  dataSource: MatTableDataSource<PaymentMethod> = new MatTableDataSource<PaymentMethod>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  paymentMethodService: PaymentMethodServiceService = inject(PaymentMethodServiceService);
  route: Router = inject(Router);

  constructor() {
    console.log("Constructor");
  }

  ngOnInit() {
    this.paymentMethodService.list().subscribe(
      data => {
        this.dataSource.data = data;
      },
      err => console.error(err)
    );
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
}
