import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Student } from '../../model/Student';
import { FormsModule } from '@angular/forms';
import { StudentService } from '../service/student.service';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule,MatInputModule,MatFormFieldModule,MatButtonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  newStudent: Student = new Student(0, '', 0, 0, []);

  constructor(private studentService: StudentService) {}

  addStudent() {
    this.studentService.addStudent(this.newStudent);
    this.newStudent = { ...this.newStudent, rollno: 0, name: '', numberOfAttempts: 0,
     percentage: 0, subjectsLearning: [] };
    alert('Student Added!!');
  }
  
}
