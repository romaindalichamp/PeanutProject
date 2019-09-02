import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../api/auth/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  authService: any;
  constructor(private router: Router, private authservice : AuthService) { }

  ngOnInit() {
    this.isloginn();
  }

  isloginn(){
    if (localStorage.getItem('token')){
      return true;
    }
  }
  isadmin(){
      console.log(localStorage.getItem('role_admin')); //bidouille à corriger plus tard
      if(localStorage.getItem('role_admin')=='ADMIN'){
          return true;
      }
      return false;
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('role_admin');
    this.router.navigate(['login']);
  }
}