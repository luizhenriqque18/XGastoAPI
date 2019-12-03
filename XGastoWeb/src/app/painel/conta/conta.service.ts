import { Injectable } from '@angular/core';
import {Conta} from '../../shared/xGastoApi';
import {ContaControllerService} from '../../shared/xGastoApi';
import {UserService} from '../../core/user/user.service';

@Injectable({
  providedIn: 'root'
})
export class ContaService {

  constructor(
    private contaControllerService: ContaControllerService,

  ) { }

  public listarContas(idUsuario: number) {
    return this.contaControllerService.findContaByUsuarioUsingGET(idUsuario);
  }
}
