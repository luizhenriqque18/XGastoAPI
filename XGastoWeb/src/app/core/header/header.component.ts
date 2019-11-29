import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {UsuarioDto} from "../../shared/xGastoApi";
import {UserService} from "../user/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {


  user$: Observable<UsuarioDto>;

  constructor(
    private userService: UserService,
    private router: Router) {

    this.user$ = userService.getUser();
  }

  logout() {
    this.userService.logout();
    this.router.navigate(['']);
  }

}
