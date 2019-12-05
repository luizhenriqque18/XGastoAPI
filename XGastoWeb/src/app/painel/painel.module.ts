import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PainelRoutingModule} from './painel-routing.module';
import {PainelComponent} from './painel.component';
import { ContaComponent } from './conta/conta.component';
import { LancamentoComponent } from './lancamento/lancamento.component';
import { CreateOrUpdateComponent } from './conta/create-or-update/create-or-update.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    PainelRoutingModule
  ],
  declarations: [PainelComponent, ContaComponent, LancamentoComponent, CreateOrUpdateComponent],
})
export class PainelModule { }
