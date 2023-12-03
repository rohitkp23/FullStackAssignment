import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import HeaderComponent from './header/header.component';
import FooterComponent from './footer/footer.component';
import StudentComponent from './student/student.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { RegisterComponent } from './register/register.component';
import { ContactusComponent } from './contactus/contactus.component';
import { SortComponent } from './sort/sort.component';
import { MenuComponent } from './menu/menu.component';




@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HeaderComponent, FooterComponent, StudentComponent,
    LoginComponent, FormsModule, HomeComponent,AboutusComponent,RegisterComponent,
  ContactusComponent,SortComponent, MenuComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Student Management Portal';
}
