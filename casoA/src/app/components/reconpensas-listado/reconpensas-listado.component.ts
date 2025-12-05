import {Component, inject, ViewChild} from '@angular/core';
import {MatTable, MatTableDataSource, MatTableModule} from "@angular/material/table";
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {DatePipe} from "@angular/common";
import {Router} from "@angular/router";
import {Reconpensas} from "../../models/reconpensas";
import {RewardsService} from "../../services/Reconpensa";
import {MatSnackBar} from "@angular/material/snack-bar";


@Component({
  selector: 'app-reconpensas-listado',
  standalone: true,
  imports: [
    MatTableModule,
    MatPaginatorModule,
    DatePipe
  ],
  templateUrl: './reconpensas-listado.component.html',
  styleUrl: './reconpensas-listado.component.css'
})
export class ReconpensasListadoComponent {
  lista: Reconpensas[] = [];
  displayedColumns: string[] = ['id', 'titulo', 'descipcion','category'];
  dataSource: MatTableDataSource<Reconpensas> = new MatTableDataSource<Reconpensas>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  reconpenzaService: RewardsService = inject(RewardsService);
  route : Router = inject(Router);

  constructor() {
    console.log("Constructor")
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
    console.log('Component ngOnInit');
    this.reconpenzaService.list().subscribe(
      data => {
        this.dataSource.data = data;
      }
    )
  }

}
