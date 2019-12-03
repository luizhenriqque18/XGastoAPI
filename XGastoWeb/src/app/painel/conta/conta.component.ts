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

  ngOnInit() {
    this.contas = this.activatedRoute.snapshot.data['PainelResolver'].data;
  }

}
