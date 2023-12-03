    import { Component } from '@angular/core';
    import { CommonModule } from '@angular/common';
    import { Student } from '../../model/Student';
    import { SortComponent } from '../sort/sort.component';
    import { StudentService } from '../service/student.service';
    import { StudentUpdateComponent } from '../student-update/student-update.component';
    import {MatButtonModule} from '@angular/material/button';
import { StudentRestService } from '../service/student-rest.service';


    @Component({
      selector: 'app-student',
      standalone: true,
      imports: [CommonModule,SortComponent,StudentUpdateComponent,MatButtonModule],
      templateUrl: './student.component.html',
      styleUrl: './student.component.css'
    })
    class StudentComponent {
      students:Student[] = [];
      message:string=''
      colorClass:string=''

      selectedStudent!:Student

      updateClicked: boolean = false; 
      
      constructor(private service:StudentRestService){
       this.showStudents();
      }

      showStudents(){
        this.service.findAllStudents().subscribe(
          Response=>this.students=Response
        );
      }

      deleteStudent(rollno:number){
        const result = confirm('Do you want to delete student with roll number '+ rollno);
        if(result){
            this.service.deleteByRollNo(rollno).subscribe(
            Response=>{
              this.students=this.students.filter(s => s.rollno != rollno);
              this.message = 'Record Deleted!!'
              this.colorClass = 'success'
            })
        } 
        
        else{
          this.message = 'Deletion Cancelled'
          this.colorClass = 'error'
        }
      }
      
      updateStudent(s: Student){
        console.log(s);
        this.selectedStudent=s;
        this.updateClicked = true;
      }
      
      doUpdate(updatedStudent:Student){
      //map is a built-in function of javascript that transforms every element of the array
      let modifiedStudents = this.students.map(s=>{
            if(s.rollno==updatedStudent.rollno){
              //following line make use of spread operator
              //spread operator was added in ES6
              //using following line we are changing the value of noOfAttempts field
              return {...s,numberOfAttempts:updatedStudent.numberOfAttempts}
            }
            else{
              return s;
            }
        })
          this.students=modifiedStudents;
          this.updateClicked=false;
      }

      sortStudents(criteria: string) {
      switch (criteria) {
        case 'percentage':
          this.students.sort((a, b) => b.percentage - a.percentage);
          break;
        case 'attempts':
          this.students.sort((a, b) => a.numberOfAttempts - b.numberOfAttempts);
          break;
        case 'subjects':
          this.students.sort((a, b) => b.subjectsLearning.length - a.subjectsLearning.length);
          break;
        default:
          break;
      }
    }
  }
  export default StudentComponent;
