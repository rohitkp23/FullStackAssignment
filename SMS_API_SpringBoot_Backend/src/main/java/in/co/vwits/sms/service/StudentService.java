package in.co.vwits.sms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.co.vwits.model.exception.StudentNotFoundException;
import in.co.vwits.sms.model.Student;

public interface StudentService {

	//Single line comment
	/*
	 * This is Multi-line comment
	 */
	/**
	 * This is documentation comment.
	 * Finds all the student details who scored more than given percentage
	 * @param percentage
	 * @return java.uti.List<Student>
	 */
	List<Student> findAllStudentsScoredMoreThanGivenPercentage(double percentage);

	List<Student> findAllStudentsScoredMoreThanGivenPercentageAndLessThanAttempts(double percentage, int attempts);

	long findTotalcountOfStudentsWithNameStartingWith(char c);

	List<Student> findAllStudentsSortedByPercentage();

	List<String> findAllStudentsNameWhoScoredMoreThanGivenPercentage(double percentage);

	List<Student> findAllStudentsLearningSpecificSubject(String subject);

	List<Student> findStudentsBornAftereSpecificDate(LocalDate specificDate);

	List<Student> findStudentsBornBeforeSpecificDate(LocalDate specificDate);

	long findStudentCountBornAfterSpecificDate(LocalDate specificDate);

	List<Student> findStudentsBornBetweenDates(LocalDate startDate, LocalDate endDate);

	Map<Boolean, List<Student>> partitionStudentBasedOnMarks(double mark);

	long findCountOfUniqueSubjects();

	List<Student> findAll();

	void save(Student s);

	Optional<Student> findByRollNo(int rollNo) throws StudentNotFoundException;

	void deleteByRollNo(int rollNo);

	void updateByRollNo(int rollno, double newPercentage);

	void update(Student s);
	
	List<Student> findAllWithSubjects();
	
	public Student findOneWithSubjects(int rollNo);

}