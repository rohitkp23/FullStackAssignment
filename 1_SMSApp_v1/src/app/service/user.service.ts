import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  isUserLoggedIn: boolean = false;
  message: string = '';

  readonly BASE_URL='http://localhost:8080/api/user'
  constructor(private http:HttpClient) {
    
  }
  

  performLogin(username: string, password: string): Observable<any> {
    const user = { username, password };

    return this.http.post<any>(`${this.BASE_URL}/login`, user).pipe(
      tap((resultData)=>{
        if (resultData.message === 'Login Success') {
          this.isUserLoggedIn = true;
        }

      }),
      catchError((error)=>{
        console.error('Error during login',error);
        throw error;
      })
    );
  }

  performSignup(username: string, password: string): Observable<any> {
    const user = { username, password };
  
    return this.http.post<any>(`${this.BASE_URL}/signup`, user).pipe(
      catchError((error) => {
        console.error('Error during signup', error);
        throw error;
      })
    );
  }
  
  updateProfile(username: string, password: string): Observable<any> {
    const updatedUser = { username, password };
  
    return this.http.put<any>(`${this.BASE_URL}/update-profile`, updatedUser).pipe(
      catchError((error) => {
        console.error('Error updating profile', error);
        throw error;
      })
    );
  }
  

}
