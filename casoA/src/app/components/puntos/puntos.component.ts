import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {PaymentMethod} from "../../models/PaymentMethod";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {PaymentMethodServiceService} from "../../services/payment-method-service.service";
import {TransactionsService} from "../../services/Puntos";


@Component({
  selector: 'app-puntos',
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
    MatOption,
    MatSelect
  ],
  templateUrl: './puntos.component.html',
  styleUrl: './puntos.component.css'
})
export class PuntosComponent {
  fb = inject(FormBuilder);
  service = inject(TransactionsService);
  snackBar = inject(MatSnackBar);

  // Formulario
  puntosForm: FormGroup = this.fb.group({
    id: [''],
    points: ['', Validators.required],
    typeTransactions: ['', Validators.required],

  });

  // Registrar puntos
  registerForm() {
    if (this.puntosForm.invalid) {
      this.puntosForm.markAllAsTouched();
      return;
    }

    const puntosData = this.puntosForm.value;

    this.service.registrar(puntosData).subscribe({
      next: () => {
        this.snackBar.open("Puntos registrados correctamente", "Cerrar", { duration: 3000 });
        this.puntosForm.reset();
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open("Error al registrar los puntos", "Cerrar", { duration: 4000 });
      }
    });
  }

}
