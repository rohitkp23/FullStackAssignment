import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-update-profile',
  standalone: true,
  imports: [CommonModule, FormsModule,MatFormFieldModule,MatInputModule,MatButtonModule],
  templateUrl: './update-profile.component.html',
  styleUrl: './update-profile.component.css'
})
export class UpdateProfileComponent {
  username: string = '';
  password: string = '';

  constructor(private user: UserService, private router: Router) {}

  updateprofile() {
    this.user.updateProfile(this.username, this.password).subscribe({
      next: (response) => {
        alert('Profile updated successfully');
        // Optionally, you can navigate to a different route after updating the profile
        this.router.navigate(['/home']);
      },
      error: (error) => {
        console.error('Error updating profile', error);
      },
    });
  }

}
