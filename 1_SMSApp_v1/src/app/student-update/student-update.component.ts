import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Student } from '../../model/Student';
import { FormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog'

@Component({
  selector: 'app-student-update',
  standalone: true,
  imports: [CommonModule,FormsModule,MatFormFieldModule,
    MatInputModule,MatButtonModule,MatDialogModule],
  templateUrl: './student-update.component.html',
  styleUrl: './student-update.component.css'
})
export class StudentUpdateComponent {
  @Input()
  updatedStudent = new Student(0,'',0,0,[]);

  //To send data from child to parent we need to use @Output decorator

  @Output()
  studentEmitter = new EventEmitter<Student>();
  performUpdate(){
    this.studentEmitter.emit(this.updatedStudent);
  }

}
