package in.co.vwits.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.co.vwits.sms.model.Student;

//Jpa repository gives us lot of built-in methods for CRUD operations which
//we dont have to implement it at all.
public interface StudentRepository extends JpaRepository<Student, Integer> {
	//But also we have freedom of writing our custom methods.
	//We just have to declare our custom methods we dont have to define them.
	//But for custom methods we have to write JPQL on top of respective custom methods.
	//This is done using @Query annotation.
	
	@Query("SELECT DISTINCT s FROM Student AS s LEFT JOIN FETCH s.subjectsLearning")
	List<Student> findAllWithSubjects();
	
	@Query("FROM Student AS s LEFT JOIN FETCH s.subjectsLearning WHERE s.rollno = :rno")
	Student findOneWithSubjects(@Param(value = "rno") int rollNo);
}

