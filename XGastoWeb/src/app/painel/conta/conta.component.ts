import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Conta, ContaDto} from "../../shared/xGastoApi";

@Component({
  selector: 'app-conta',
  templateUrl: './conta.component.html',
  styleUrls: ['./conta.component.css']
})
export class ContaComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute) { }

  private contas: Array<ContaDto>;
  public edit: boolean;

  ngOnInit() {
    this.contas = this.activatedRoute.snapshot.data.PainelResolver.data;
  }

  public editar() {
    this.edit = true;
  }
}
