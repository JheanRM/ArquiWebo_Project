import { HttpInterceptorFn } from '@angular/common/http';

export const interceptorTsInterceptor: HttpInterceptorFn = (req, next) => {

  const token = sessionStorage.getItem('token');


  // Si existe el token, clonamos la petición y agregamos el header
  if (token) {
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
  }

  return next(req);
};
