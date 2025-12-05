import { Routes } from '@angular/router';
import { ReportsComponent } from './components/reports/reports.component';
import { MontoinvuserComponent } from './components/reports/montoinvuser/montoinvuser.component';
import { HomeComponent } from './components/home/home.component';
import { segGuard } from './guard/seguridad.guard';
import { LoginComponent } from './components/login/login.component';
import {PlanesComponent} from "./components/planes/planes.component";
import {PagosComponent} from "./components/pagos/pagos.component";
import {RecompensasComponent} from "./components/reconpensas/reconpensas.component";
import {PuntosComponent} from "./components/puntos/puntos.component";
import {DispositivoComponent} from "./components/dispositivo/dispositivo.component";
import {HistorialComponent} from "./components/historial/historial.component";
import {PlanesListadoComponent} from "./components/planes-listado/planes-listado.component";
import {ReconpensasListadoComponent} from "./components/reconpensas-listado/reconpensas-listado.component";
import {HistorialListadoComponent} from "./components/historial-listado/historial-listado.component";
import {Reporte1Component} from "./components/reporte1/reporte1.component";
import {Reporte5Component} from "./components/reporte5/reporte5.component";
import {Reporte4Component} from "./components/reporte4/reporte4.component";
import {Reporte2Component} from "./components/reporte2/reporte2.component";


export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'reportes',
    component: ReportsComponent,
    children: [
      {
        path: 'montoinv',
        component: MontoinvuserComponent,
      },
    ],
  },
  {
    path: 'homes',
    component: HomeComponent,
    canActivate: [segGuard], // solo construcciones, se debe agregar a cada uno
  },
  {path: 'Planes', component: PlanesComponent},
  {path: 'Pagos', component: PagosComponent},
  {path: 'Recompensas',component: RecompensasComponent},
  {path: 'Puntos', component: PuntosComponent},
  {path: 'Dispositivo',component: DispositivoComponent},
  { path:'historial', component: HistorialComponent },
  {path:'reportes-tipo',component:ReportsComponent},
  {path:'planes-listado',component:PlanesListadoComponent},
  {path:'listado-recompensas',component:ReconpensasListadoComponent},
  {path:'listado-historial',component:HistorialListadoComponent},
  {path:'reporteUno',component:Reporte1Component},
  {path:'reporteDos',component:Reporte2Component},
  {path:'reporteCuatro',component:Reporte4Component},
  {path:'reporteCinco',component:Reporte5Component}

];
