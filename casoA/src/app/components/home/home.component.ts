import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  MatCard,
  MatCardActions,
  MatCardContent,
  MatCardFooter, MatCardHeader,
  MatCardSubtitle,
  MatCardTitle
} from '@angular/material/card';
import {MatList, MatListItem} from '@angular/material/list';
import {MatIcon} from '@angular/material/icon';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatDivider} from '@angular/material/divider';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, MatCard, MatCardContent, MatListItem, MatIcon, MatCardActions, MatList, MatCardSubtitle, MatCardTitle, MatCardFooter, MatLabel, MatFormField, MatCardHeader, MatDivider],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

}
