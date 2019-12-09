import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {Conta} from "../model/Conta";

@Injectable({
  providedIn: 'root'
})
export class PainelService {

  constructor() { }

  private modalData: BehaviorSubject<Conta> = new BehaviorSubject<Conta>(null);

  public setModalData(data?: Conta) {
    this.modalData.next(data || null);
  }

  public getModalData(): Conta {
    return this.modalData.getValue();
  }

  public $getModalData() {
    return this.modalData;
  }
}

