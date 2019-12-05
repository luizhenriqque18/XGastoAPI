import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ContaControllerService} from '../../../shared/xGastoApi';
import {Conta} from '../../../model/Conta';

@Component({
  selector: 'app-create-or-update',
  templateUrl: './create-or-update.component.html',
  styleUrls: ['./create-or-update.component.css']
})
export class CreateOrUpdateComponent implements OnInit {
  public formulario: FormGroup = new FormGroup({
    desc_conta: new FormControl(null),
    saldo: new FormControl(null)
  });

  @Input() public isUpdate: boolean;
  @Input() public idConta: number;

  private conta: Conta;

  constructor(private contaControllerService: ContaControllerService) { }

  ngOnInit() {
  }

  save() {
    const { saldo, desc_conta } = this.formulario.value;
    const conta = new Conta(desc_conta, saldo);
    console.log(conta);
    //this.contaControllerService.createUsingPOST();
  }
}
