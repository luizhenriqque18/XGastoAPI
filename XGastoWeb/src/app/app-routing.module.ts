import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SignInComponent} from './home/sign-in/sign-in.component';
import {AuthGuard} from './core/auth/auth.guard';
import {NotFoundComponent} from './errors/not-found/not-found.component';


const routes: Routes = [
  {
    path: 'painel',
    loadChildren: () => import('./painel/painel.module')
      .then( m => m.PainelModule),
  },
  {
    path: '',
    component: SignInComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
