import {Component, LOCALE_ID, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Conta, ContaControllerService, ContaDto} from '../../shared/xGastoApi';
import {PainelService} from "../painel.service";
import {ContaService} from "./conta.service";
import ptBr from '@angular/common/locales/pt';
import {registerLocaleData} from "@angular/common";
registerLocaleData(ptBr)
@Component({
  selector: 'app-conta',
  templateUrl: './conta.component.html',
  styleUrls: ['./conta.component.css'],
  providers: [{provide: LOCALE_ID, useValue: 'pt-PT'}]
})
export class ContaComponent implements OnInit {

  constructor(
    private activatedRoute: ActivatedRoute,
    private painelService: PainelService,
    private contaService: ContaService,
    private contaControllerService: ContaControllerService
  ) { }

  private contas: Array<ContaDto>;

  ngOnInit() {
    this.contaService.listarContas()
    this.contaService.data$.subscribe( resp => {
      this.contas = resp as Array<Conta>;
    });
  }

  public editar(conta: ContaDto) {
    this.painelService.setModalData(conta);
  }

  public delete(id: number) {
    this.contaService.deletarConta(id);
  }
}
