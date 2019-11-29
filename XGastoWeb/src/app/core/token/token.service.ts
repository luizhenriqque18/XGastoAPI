import { Injectable } from '@angular/core';

const KEY = 'authToken';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  hasToken() {
    return this.getToken() != null;
  }

  setToken(token) {
    window.localStorage.setItem(KEY, token);
  }

  getToken() {
    return JSON.parse(window.localStorage.getItem(KEY));
  }

  removeToken() {
    window.localStorage.removeItem(KEY);
  }
}
