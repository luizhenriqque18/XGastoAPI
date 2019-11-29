import { Injectable } from '@angular/core';
import {UsuarioControllerService, UsuarioDto} from '../../shared/xGastoApi';
import {tap} from 'rxjs/operators';
import {UserService} from '../user/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private api: UsuarioControllerService,
              private userService: UserService) { }

  public authenticate(email: string, senha: string) {
      return this.api.signInUsingPOST(email, senha).pipe( tap(resp => {
        const authToken = resp.data as UsuarioDto;
        this.userService.setToken(authToken);
      }));
  }
}
