import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {MatFormField, MatLabel, MatSuffix} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {DispositivoService} from "../../services/Dispositivo";
import {ConsumptionHistoryService} from "../../services/Historial";
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";

@Component({
  selector: 'app-historial',
  standalone: true,
  imports: [
    FormsModule,
    MatCard,
    MatCardContent,
    MatCardTitle,
    MatFormField,
    MatInput,
    MatLabel,
    ReactiveFormsModule,
    MatDatepicker,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatSuffix
  ],
  templateUrl: './historial.component.html',
  styleUrl: './historial.component.css'
})
export class HistorialComponent {

  fb = inject(FormBuilder);
  service = inject(ConsumptionHistoryService);
  snackBar = inject(MatSnackBar);

  // Formulario
  historialForm: FormGroup = this.fb.group({
    id: [''],
    type: ['', Validators.required],
    message: ['', Validators.required],
    datetimeStar: ['', Validators.required],
    consumption: ['', Validators.required],
    datetimeEnd: ['', Validators.required],
    price: ['', Validators.required],

  });

  // Registrar puntos
  registrarPago() {
    if (this.historialForm.invalid) {
      this.historialForm.markAllAsTouched();
      return;
    }

    const puntosData = this.historialForm.value;

    this.service.registrar(puntosData).subscribe({
      next: () => {
        this.snackBar.open("Historial registrados correctamente", "Cerrar", { duration: 3000 });
        this.historialForm.reset();
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open("Error al registrar dispositivo", "Cerrar", { duration: 4000 });
      }
    });
  }

}
