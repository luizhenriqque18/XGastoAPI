import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PainelRoutingModule} from './painel-routing.module';
import {PainelComponent} from './painel.component';
import { ContaComponent } from './conta/conta.component';
import { LancamentoComponent } from './lancamento/lancamento.component';

@NgModule({
  imports: [
    PainelRoutingModule,
    CommonModule
  ],
  declarations: [PainelComponent, ContaComponent, LancamentoComponent],
})
export class PainelModule { }
