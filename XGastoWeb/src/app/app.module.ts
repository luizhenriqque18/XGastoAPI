import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BASE_PATH,  ApiModule as XGastoApi } from './shared/xGastoApi/';
import {environment} from '../environments/environment';
import {HttpClientModule} from '@angular/common/http';
import { HeaderComponent } from './core/header/header.component';
import {CoreModule} from './core/core.module';
import {HomeModule} from './home/home.module';
import { PainelComponent } from './painel/painel.component';


@NgModule({
  declarations: [
    AppComponent,
    PainelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CoreModule,
    HomeModule,
    XGastoApi
  ],
  providers: [{
    provide: BASE_PATH, useValue: environment.basePath
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
