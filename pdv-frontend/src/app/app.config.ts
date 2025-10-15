import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZoneChangeDetection, isDevMode } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi} from '@angular/common/http';
import { provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { produtoReducer } from './store/produto.reducer';
import { InterceptorAutorizacao } from './servicos/auth/interceptor-autorizacao';

export const appConfig: ApplicationConfig = {

 
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),

    { provide: HTTP_INTERCEPTORS, useClass: InterceptorAutorizacao, multi: true },
    provideHttpClient(withInterceptorsFromDi()),
    provideRouter(routes),
    provideStore(),
    provideEffects(),
    provideStoreDevtools({ maxAge: 25, logOnly: !isDevMode() }),
    provideStore({ produtos: produtoReducer })
]
};
