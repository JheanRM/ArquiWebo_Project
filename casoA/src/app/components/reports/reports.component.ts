import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { CanticertiuserComponent } from './canticertiuser/canticertiuser.component';

@Component({
  selector: 'app-reports',
  standalone: true,
  imports: [RouterOutlet, CanticertiuserComponent],
  templateUrl: './reports.component.html',
  styleUrl: './reports.component.css'
})
export class ReportsComponent implements OnInit{
  constructor(public route: ActivatedRoute){}
  ngOnInit(): void {
      
  }
}
