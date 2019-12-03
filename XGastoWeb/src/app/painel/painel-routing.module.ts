import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PainelComponent} from './painel.component';
import {AuthGuard} from '../core/auth/auth.guard';
import {LancamentoComponent} from "./lancamento/lancamento.component";
import {PainelResolver} from "./painel-resolver";


const routes: Routes = [
    {
      path: '',
      component: PainelComponent,
      resolve: {
        PainelResolver
      }
    },
    {
      path: 'conta',
      component: LancamentoComponent,
    },
    { path: '', redirectTo: '', pathMatch: 'full' },
    { path: '**', redirectTo: '' }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PainelRoutingModule { }
