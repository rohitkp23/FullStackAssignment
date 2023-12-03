import { Routes } from '@angular/router';
import StudentComponent from './student/student.component';
import { LoginComponent } from './login/login.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { authGuard } from './auth.guard';
import { SignupComponent } from './signup/signup.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';


export const routes: Routes = [
    {path:'login',component:LoginComponent},
    {path:'students',component:StudentComponent,canActivate:[authGuard]},
    {path:'home',component:HomeComponent,canActivate:[authGuard]},
    {path:'aboutus',component:AboutusComponent},
    {path:'contactus', component:ContactusComponent},
    {path:'register', component:RegisterComponent,canActivate:[authGuard]},
    {path:'logout',component:LogoutComponent},
    {path:'signup',component:SignupComponent},
    {path:'updateprofile',component:UpdateProfileComponent,canActivate:[authGuard]}
];
