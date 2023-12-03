package in.co.vwits.sms.service.impl;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.vwits.model.exception.StudentNotFoundException;
import in.co.vwits.sms.model.Student;
import in.co.vwits.sms.repository.StudentRepository;
import in.co.vwits.sms.service.StudentService;

@Service
@Transactional//This annotation instruct spring framework to invoke all methods of this class in transaction.
public class StudentServiceImpl implements StudentService {
	
	//using reference of interface  to communicate other layer of application is known as Coding to Interface.
	//Coding to interface is the best practice as it gives loose coupling among layers.
	@Autowired
	private StudentRepository repo;

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
	@Override
	public List<Student> findAllStudentsScoredMoreThanGivenPercentage(double percentage){
		return repo.findAll().stream()
				.filter(student -> student.getPercentage() > percentage)
				.collect(Collectors.toList());	        
	}

	@Override
	public List<Student> findAllStudentsScoredMoreThanGivenPercentageAndLessThanAttempts(double percentage, int attempts) {
		return repo.findAll().stream()
				.filter(student -> student.getPercentage() > percentage)
				.filter(student -> student.getNumberOfAttempts() < attempts)
				.collect(Collectors.toList());
	}

	@Override
	public long findTotalcountOfStudentsWithNameStartingWith(char c) {
		return repo.findAll().stream()
				.filter(student -> student.getName().charAt(0)==c)
				.count();
	}

	@Override
	public List<Student> findAllStudentsSortedByPercentage() {

		return repo.findAll().stream().sorted().collect(Collectors.toList());
	}

	@Override
	public List<String> findAllStudentsNameWhoScoredMoreThanGivenPercentage(double percentage) {
		return repo.findAll().stream()
				.filter(student -> student.getPercentage() > percentage)
				.map(Student::getName) 
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> findAllStudentsLearningSpecificSubject(String subject)
	{
		return repo.findAll().stream()
				.filter(student -> student.getSubjectsLearning().stream().anyMatch(sub->sub.equals(subject)))
				.collect(Collectors.toList());

	}

	@Override
	public List<Student> findStudentsBornAftereSpecificDate(LocalDate specificDate) {
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isAfter(specificDate))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Student> findStudentsBornBeforeSpecificDate(LocalDate specificDate) {
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isBefore(specificDate))
				.collect(Collectors.toList());
	}

	@Override
	public long findStudentCountBornAfterSpecificDate(LocalDate specificDate) {
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isAfter(specificDate))
				.count();
	}

	@Override
	public List<Student> findStudentsBornBetweenDates(LocalDate startDate, LocalDate endDate) {
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isBefore(startDate))
				.filter(student -> student.getDateOfBirth().isAfter(endDate))
				.collect(Collectors.toList());
	}

	@Override
	public Map<Boolean, List<Student>> partitionStudentBasedOnMarks(double mark)
	{
		return repo.findAll()
				.stream()
				.collect(Collectors.partitioningBy(s -> s.getPercentage() > mark));
	}

	@Override
	public long findCountOfUniqueSubjects() {
	    return repo.findAll().stream()
	            .flatMap(s -> s.getSubjectsLearning().stream())
	            .distinct()
	            .count();
	}

	@Override
	public List<Student> findAll(){
		return repo.findAll();
	}

	@Override
	public void save(Student s)
	{
		repo.save(s);
	}

	@Override
	public Optional<Student> findByRollNo(int rollNo) throws StudentNotFoundException 
	{
		Optional <Student> p = repo.findById(rollNo);
		if(p.isPresent()) {
		return p; 
		}
		else {
			//throw user defined exception "StudentNotFound"
			throw new StudentNotFoundException();
		}
	}

	@Override
	public void deleteByRollNo(int rollNo) 
	{
		repo.deleteById(rollNo);
	}

	@Override
	public void updateByRollNo(int rollno, double newPercentage) 
	{
		//repo.updateByRollNo(rollno, newPercentage);
	}
	@Override
	public void update(Student ss) {
		this.repo.save(ss);
		
	}
	@Override
	public List<Student> findAllWithSubjects() {
		return this.repo.findAllWithSubjects();
	}
	@Override
	public Student findOneWithSubjects(int rollNo) {
		return this.repo.findOneWithSubjects(rollNo);
	}

}
