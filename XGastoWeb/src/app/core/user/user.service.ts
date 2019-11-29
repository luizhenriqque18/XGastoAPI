import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {UsuarioDto} from '../../shared/xGastoApi';
import {TokenService} from '../token/token.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userSubject = new BehaviorSubject<UsuarioDto>(null);
  private userName: string;
  private id: number;

  constructor(private tokenService: TokenService) {

    this.tokenService.hasToken() &&
    this.decodeAndNotify();
  }

  setToken(token: UsuarioDto){
    this.tokenService.setToken(JSON.stringify(token));
  }

  getUser() {
    return this.userSubject.asObservable();
  }

  private decodeAndNotify() {
    const user = this.tokenService.getToken() as UsuarioDto;
    this.userName = user.email;
    this.id = user.id;
    this.userSubject.next(user);
  }

  logout() {
    this.tokenService.removeToken();
    this.userSubject.next(null);
  }

  isLogged() {
    console.log('hasToken');
    return this.tokenService.hasToken();
  }

  getUserName() {
    return this.userName;
  }

  getId() {
    return this.id;
  }
}
