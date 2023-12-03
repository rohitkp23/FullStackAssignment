import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule,FormsModule,MatFormFieldModule,MatInputModule,MatButtonModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  username: string = '';
  password: string = '';

  constructor(private user: UserService, private router: Router) {}

  performsignup() {
    this.user.performSignup(this.username, this.password).subscribe({
      next: (response) => {
        alert("Signup successful");
        this.router.navigate(['/login']);
      },
      error: (error) => {
        console.error('Error during signup', error);
      },
    });
  }
}
