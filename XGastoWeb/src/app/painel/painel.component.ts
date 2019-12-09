import { Component, OnInit } from '@angular/core';
import {PainelService} from "./painel.service";
@Component({
  selector: 'app-painel',
  templateUrl: './painel.component.html',
  styleUrls: ['./painel.component.css']
})
export class PainelComponent implements OnInit {

  constructor(private painelService: PainelService ) { }

  ngOnInit() {
  }

  public dispatchCreate(): void {
    this.painelService.setModalData(null);
  }
}
