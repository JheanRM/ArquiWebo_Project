import {Component, inject, ViewChild} from '@angular/core';
import {CurrencyPipe, DatePipe} from "@angular/common";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow, MatRowDef, MatTable, MatTableDataSource, MatTableModule
} from "@angular/material/table";
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {PaymentMethod} from "../../models/PaymentMethod";
import {PaymentMethodServiceService} from "../../services/payment-method-service.service";
import {Router} from "@angular/router";
import {Historial} from "../../models/Historial";
import {ConsumptionHistoryService} from "../../services/Historial";

@Component({
  selector: 'app-historial-listado',
  standalone: true,
  imports: [
    CurrencyPipe,
    DatePipe,
    MatTableModule,
    MatPaginatorModule
  ],
  templateUrl: './historial-listado.component.html',
  styleUrl: './historial-listado.component.css'
})
export class HistorialListadoComponent {

  lista: Historial[] = [];
  displayedColumns: string[] = ['id', 'type', 'message', 'datetimeStar', 'consumption', 'datetimeEnd','price'];
  dataSource: MatTableDataSource<Historial> = new MatTableDataSource<Historial>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  historialService: ConsumptionHistoryService = inject(ConsumptionHistoryService);
  route: Router = inject(Router);

  constructor() {
    console.log("Constructor");
  }

  ngOnInit() {
    this.historialService.list().subscribe(
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
