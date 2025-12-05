
import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";
import {PaymentMethod} from "../../models/PaymentMethod";
import {TransactionsService} from "../../services/Puntos";
import {RewardsService} from "../../services/Reconpensa";

@Component({
  selector: 'app-recompensas',
  standalone: true,
  imports: [
    FormsModule,
    MatCard,
    MatCardContent,
    MatCardTitle,
    MatFormField,
    MatInput,
    MatLabel,
    ReactiveFormsModule
  ],
  templateUrl: './reconpensas.component.html',
  styleUrl: './reconpensas.component.css'
})
export class RecompensasComponent {
  fb = inject(FormBuilder);
  service = inject(RewardsService);
  snackBar = inject(MatSnackBar);

  // Formulario
  llenadoForm: FormGroup = this.fb.group({
    id: [''],
    titulo: ['', Validators.required],
    descipcion: ['', Validators.required],
    category: ['', Validators.required]

  });

  // Registrar puntos
  registrarForm() {
    if (this.llenadoForm.invalid) {
      this.llenadoForm.markAllAsTouched();
      return;
    }

    const puntosData = this.llenadoForm.value;

    this.service.registrar(puntosData).subscribe({
      next: () => {
        this.snackBar.open("Reconpensa registrados correctamente", "Cerrar", { duration: 3000 });
        this.llenadoForm.reset();
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open("Error al registrar los puntos", "Cerrar", { duration: 4000 });
      }
    });
  }
}
