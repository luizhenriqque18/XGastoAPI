import {Component, Input, OnInit, LOCALE_ID, ViewChild, ElementRef} from '@angular/core';
import {FormControl, FormGroup, Validator, Validators} from '@angular/forms';
import {ContaControllerService} from '../../../shared/xGastoApi';
import {Conta} from '../../../model/Conta';
import {BehaviorSubject} from 'rxjs';
import {PainelService} from "../../painel.service";
import {UserService} from "../../../core/user/user.service";
import {Router} from "@angular/router";
import {ContaService} from "../conta.service";
@Component({
  selector: 'app-create-or-update',
  templateUrl: './create-or-update.component.html',
  styleUrls: ['./create-or-update.component.css']
})
export class CreateOrUpdateComponent implements OnInit {

  // @ts-ignore
  @ViewChild('idsave', { static: 'false'}) valor: ElementRef

  public isUpdate: boolean;

  private conta: Conta;

  public formulario: FormGroup = new FormGroup({
    descricao: new FormControl( null, [Validators.required]),
    saldo: new FormControl(null)
  });

  constructor(
    private contaService: ContaService,
    private painelService: PainelService,
    private userService: UserService,
    private router: Router) { }

  ngOnInit() {
    this.painelService.$getModalData().subscribe(resp => {
      this.conta = resp;
      if (resp) {
        this.isUpdate = true;
        const { descricao, saldo} = this.painelService.getModalData();
        this.formulario.patchValue({
          descricao,
          saldo
        });
      } else {
        this.isUpdate = false;
        this.formulario.patchValue({
          descricao: '',
          saldo: ''
        });
      }
    });
  }

  saveOrUpdate() {
    if (this.formulario.valid) {
      const {descricao, saldo} = this.formulario.value;

      if (!this.conta) {

        this.conta = new Conta(descricao, saldo);
        this.contaService.cadastrarConta(this.conta);
        this.valor.nativeElement.attributes[2].value = 'modal'; //apagar modal
        return;
      }

      this.conta.saldo = saldo;
      this.conta.descricao = descricao;
      this.contaService.atualizarConta(this.conta);
      this.valor.nativeElement.attributes[2].value = 'modal'; //apagar modal
    }
    setTimeout(() => {
      this.valor.nativeElement.attributes[2].value = '';
    },  1000);
  }
}
