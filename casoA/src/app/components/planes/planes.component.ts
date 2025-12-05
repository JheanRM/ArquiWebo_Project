import {Component, inject, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {MatCard, MatCardActions, MatCardContent} from '@angular/material/card';
import {MatList, MatListItem} from '@angular/material/list';
import {MatIcon} from '@angular/material/icon';
import {Router} from '@angular/router';

@Component({
  selector: 'app-planes',
  standalone: true,
  imports: [CommonModule, FormsModule, MatCard, MatCardContent, MatListItem, MatIcon, MatCardActions, MatList],
  templateUrl: './planes.component.html',
  styleUrls: ['./planes.component.css']
})
export class PlanesComponent{
  constructor(){}

  router: Router = inject(Router);
  irHistorial(){
    this.router.navigate(['/Pagos']);
  }
}
