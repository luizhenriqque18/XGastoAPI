import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PainelRoutingModule} from './painel-routing.module';
import {PainelComponent} from './painel.component';

@NgModule({
  imports: [
    PainelRoutingModule,
    CommonModule
  ],
  declarations: [PainelComponent],
})
export class PainelModule { }
