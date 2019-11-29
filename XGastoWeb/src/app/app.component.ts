import { Component, OnInit } from '@angular/core';
import {UsuarioControllerService} from './shared/xGastoApi/api/api';
@Component({
  selector: 'app-root',
  template: '<app-header></app-header> <router-outlet></router-outlet>'
})
export class AppComponent implements OnInit{
  title = 'XGastoWeb';
  constructor(private api: UsuarioControllerService) { }

  ngOnInit(): void {
  }
}
