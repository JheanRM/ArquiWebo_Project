import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideCharts, withDefaultRegisterables } from 'ng2-charts';
import { JwtModule } from '@auth0/angular-jwt';
import {provideNativeDateAdapter} from "@angular/material/core";


export function tokenGetter() {
  return sessionStorage.getItem('token');

}
export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    provideHttpClient(withInterceptorsFromDi()),
    provideCharts(withDefaultRegisterables()),
    importProvidersFrom(
      JwtModule.forRoot({
        config: {
          tokenGetter: tokenGetter,
          allowedDomains: ['localhost:8081'],
          disallowedRoutes: ['http://localhost:8081/login/forget'],

        },
      })
    ),
    provideAnimationsAsync(),
    provideAnimationsAsync(),
    provideNativeDateAdapter(),
  ]
};
