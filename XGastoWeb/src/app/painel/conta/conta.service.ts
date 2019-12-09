import { Injectable } from '@angular/core';
import {Conta, ContaDto, ResponseListContaDto} from '../../shared/xGastoApi';
import {ContaControllerService} from '../../shared/xGastoApi';
import {UserService} from '../../core/user/user.service';
import { StorageMap } from '@ngx-pwa/local-storage';
import {BehaviorSubject} from 'rxjs';

const KEY = 'contas';

@Injectable({
  providedIn: 'root'
})
export class ContaService {

  public data$: BehaviorSubject<Array<Conta>> = new BehaviorSubject<Array<Conta>>(new Array<Conta>());

  constructor(
    private contaControllerService: ContaControllerService,
    private userService: UserService,
    private storageMap: StorageMap
  ) {  }

  public listarContas() {
    this.contaControllerService.findContaByUsuarioUsingGET(this.userService.getId()).subscribe(resp => {
        this.setToken(resp.data);
    });
  }

  public cadastrarConta(conta: Conta) {
    this.contaControllerService.createUsingPOST(this.userService.getId(), conta).subscribe( resp => {
      this.listarContas();
    });
  }

  public atualizarConta(conta: Conta) {
    this.contaControllerService.updateUsingPUT(conta.id, conta).subscribe( resp => {
      this.listarContas();
    });
  }

  public deletarConta(id: number) {
    this.contaControllerService.deleteUsingDELETE(id).subscribe(resp => {
        if (this.data$.getValue().length === 1) {
          this.storageMap.delete(KEY).subscribe();
          this.data$.next(new Array<Conta>()); return;
        }
        this.listarContas();
    });
  }

  setToken(contas: Array<ContaDto>) {
    this.storageMap.set(KEY, contas).subscribe(res => {
      this.storageMap.get(KEY).subscribe( resp => {
        this.data$.next(resp as Array<Conta>);
      });
    });
  }
}

