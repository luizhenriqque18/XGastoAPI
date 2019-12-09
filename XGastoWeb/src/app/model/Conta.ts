import {ContaDto} from '../shared/xGastoApi';

export class Conta implements ContaDto {
  descricao?: string;
  id?: number;
  imgUrl?: string;
  saldo?: number;

  constructor(descricao?: string, saldo?: number, id?: number, imgUrl?: string) {
    this.descricao = descricao;
    this.id = id ;
    this.imgUrl = imgUrl;
    this.saldo = saldo;
  }
}
