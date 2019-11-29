import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PainelComponent} from './painel.component';
import {AuthGuard} from '../core/auth/auth.guard';


const routes: Routes = [
    {
      path: '',
      component: PainelComponent,
    },
    { path: '', redirectTo: '', pathMatch: 'full' },
    { path: '**', redirectTo: '' }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PainelRoutingModule { }
