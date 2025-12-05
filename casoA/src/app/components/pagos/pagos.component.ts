import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { PaymentMethodServiceService } from '../../services/payment-method-service.service';
import { PaymentMethod } from '../../models/PaymentMethod';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from "@angular/material/card";
import { MatInputModule } from "@angular/material/input";
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatNativeDateModule, MatOption} from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import {MatSelect} from "@angular/material/select";

import { MatSelectModule } from "@angular/material/select";
import { MatOptionModule } from "@angular/material/core";



@Component({
  selector: 'app-pagos',
  standalone: true,
  templateUrl: './pagos.component.html',
  styleUrls: ['./pagos.component.css'],
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatCardModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    MatSnackBarModule,
    MatSelectModule,
    MatOptionModule
  ]
})
export class PagosComponent {

  fb = inject(FormBuilder);
  service = inject(PaymentMethodServiceService);
  snackBar = inject(MatSnackBar);

  paymentForm: FormGroup = this.fb.group({
    id:[''],
    nameTitular: ['', Validators.required],
    numberCard: ['', [Validators.required, Validators.pattern(/^\d{12}$/)]],
    cv: ['', [Validators.required, Validators.pattern(/^\d{3}$/)]],
    expiration: ['', Validators.required],
    price: [null, Validators.required]
  });

  registrarPago() {
    if (this.paymentForm.invalid) {
      this.paymentForm.markAllAsTouched();
      return;
    }

    const raw = this.paymentForm.value;

    const payment: PaymentMethod = {
      nameTitular: raw.nameTitular,
      numberCard: Number(raw.numberCard),
      cv: Number(raw.cv),
      expiration: raw.expiration.toISOString().split("T")[0],
      price: raw.price
    };

    this.service.registrar(payment).subscribe({
      next: () => {
        this.snackBar.open("Pago registrado correctamente", "Cerrar", { duration: 3000 });
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open("Error al registrar el pago", "Cerrar", { duration: 4000 });
      }
    });
  }
}
