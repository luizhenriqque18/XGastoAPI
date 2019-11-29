import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SignInComponent} from './home/sign-in/sign-in.component';
import {PainelComponent} from './painel/painel.component';
import {AuthGuard} from './core/auth/auth.guard';


const routes: Routes = [
  {
    path: '',
    component: SignInComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'painel/:id',
    component: PainelComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
