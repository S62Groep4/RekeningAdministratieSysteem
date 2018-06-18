import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {Router} from '@angular/router';
import {AuthenticationService} from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User('', '');
  error: String;

  constructor(private authService: AuthenticationService, private router: Router) {
  }

  ngOnInit() {
  }

  onSubmit(): void {
    this.login();
  }

  login(): void {
    this.authService.login(this.user.email, this.user.password).subscribe(res => {
      localStorage.setItem('token', res.headers.get('Authorization'));
      this.router.navigate(['/']);
    }, err => {
      if (err.status === 401) {
        this.error = 'Email or password incorrect';
      } else {
        this.error = 'Unknown error';
      }
      console.log('Encountered an error; status: ' + err.status);
    });
  }
}
