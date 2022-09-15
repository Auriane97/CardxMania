import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  pseudo: string;
  password: string;
  loginError: boolean = false;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  valider() {
    this.authService.login(this.pseudo, this.password).subscribe((resp) => {
      this.authService.utilisateur = resp;
      this.router.navigate(["/"]);
    }, error => {
      if(error.status == "403") {
        this.loginError = true;
      }
    });;
  }

}
