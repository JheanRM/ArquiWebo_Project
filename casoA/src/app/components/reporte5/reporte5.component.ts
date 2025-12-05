import { Component } from '@angular/core';
import {Reconpensas} from "../../models/reconpensas";
import {RewardsService} from "../../services/Reconpensa";
import {MatCard, MatCardContent, MatCardSubtitle, MatCardTitle} from "@angular/material/card";
import {FormsModule} from "@angular/forms";
import { CommonModule } from '@angular/common';
import {RewardsByClient} from "../../models/RewardsByClient";
@Component({
  selector: 'app-reporte5',
  standalone: true,
  imports: [
    MatCardTitle,
    MatCardContent,
    MatCardSubtitle,
    MatCard,
    FormsModule,
    CommonModule
  ],
  templateUrl: './reporte5.component.html',
  styleUrl: './reporte5.component.css'
})
export class Reporte5Component {
  rewards: RewardsByClient[] = [];
  clientNameInput: string = '';

  constructor(private rewardsService: RewardsService) {}

  ngOnInit(): void {

  }

  fetchRewards(name: string): void {
    if (!name) return;
    this.rewardsService.getRewardsByClient(name).subscribe({
      next: (data) => {
        console.log('Datos recibidos:', data);
        this.rewards = data;
      },
      error: (err) => console.error('Error al cargar recompensas:', err)
    });
  }

}
