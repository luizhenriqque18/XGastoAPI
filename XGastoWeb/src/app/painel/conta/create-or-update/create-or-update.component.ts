import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ContaDto} from "../../../shared/xGastoApi";

@Component({
  selector: 'app-create-or-update',
  templateUrl: './create-or-update.component.html',
  styleUrls: ['./create-or-update.component.css']
})
export class CreateOrUpdateComponent implements OnInit {

  public formulario: FormGroup = new FormGroup({
    'descricao': new FormControl(null),
    'saldo': new FormControl(null)
  });

  constructor() { }

  ngOnInit() {
  }

  save() {
    const { saldo, descricao } = this.formulario.value;
    let conta: ContaDto;
    conta.descricao = descricao;
    conta.saldo = saldo;
    console.log(conta);
  }

}
