import {Component, inject} from '@angular/core';
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {PaymentMethodServiceService} from "../../services/payment-method-service.service";
import {PaymentMethod} from "../../models/PaymentMethod";
import {DispositivoService} from "../../services/Dispositivo";
import {TransactionsService} from "../../services/Puntos";

@Component({
  selector: 'app-dispositivo',
  standalone: true,
  imports: [
    MatCard,
    MatCardContent,
    MatCardTitle,
    FormsModule,
    MatFormField,
    MatInput,
    MatLabel,
    ReactiveFormsModule
  ],
  templateUrl: './dispositivo.component.html',
  styleUrl: './dispositivo.component.css'
})
export class DispositivoComponent {

  fb = inject(FormBuilder);
  service = inject(DispositivoService);
  snackBar = inject(MatSnackBar);

  // Formulario
  dispositivoForm: FormGroup = this.fb.group({
    id: [''],
    name: ['', Validators.required],
    instalationDate: ['', Validators.required],

  });

  // Registrar puntos
  registrarPago() {
    if (this.dispositivoForm.invalid) {
      this.dispositivoForm.markAllAsTouched();
      return;
    }

    const puntosData = this.dispositivoForm.value;

    this.service.registrar(puntosData).subscribe({
      next: () => {
        this.snackBar.open("Dispositivo registrados correctamente", "Cerrar", { duration: 3000 });
        this.dispositivoForm.reset();
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open("Error al registrar dispositivo", "Cerrar", { duration: 4000 });
      }
    });
  }

}
