import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {Conta, ContaDto, ResponseContaDto, ResponseListContaDto} from '../shared/xGastoApi';
import {UserService} from '../core/user/user.service';
import {ContaService} from './conta/conta.service';
import {Injectable} from "@angular/core";

@Injectable({ providedIn: 'root'})
export class PainelResolver implements Resolve<Observable<Array<ContaDto>>> {

  constructor(
    private userService: UserService,
    private contaService: ContaService
  ) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):
    Observable<Observable<Array<ContaDto>>> |
    Promise<Observable<Array<ContaDto>>> |
    Observable<Array<ContaDto>> {

    return null;//this.contaService.listarContas(this.userService.getId());
  }
}
