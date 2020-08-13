package com.meet.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meet.entity.Student;
import com.meet.exeptionHandler.StudentNotFoudExeption;
import com.meet.studentService.StudentService;

/*
 *	@RestController is used to create RESTful web services and takes care of mapping request data   
*/

@RestController
public class StudentRestController {

	private StudentService studentService;

	@Autowired
	public StudentRestController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return studentService.studentList();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentByID(@PathVariable int studentId)  {
		
		Student student = studentService.findStudentByID(studentId);
		
		if (student == null) {
			throw new StudentNotFoudExeption("Student Not Found" + studentId);
		}	
		return student;
	}
	
	/*
	 * For Add A Entity Click on Body -> set POST -> Add A Data Than Hit Send Button
	 * 
	 * For Update Change Put to PUT
	 *  
	 * For Delete Change Put to DELETE 
	 */
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {		
		student.setID_STUDENT(0);
		studentService.addNewStudent(student);
		 return student;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
				student = studentService.addNewStudent(student);
		return student;
	}
	
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		studentService.deleteCustomerId(studentId);
		return "Deleted Student id is:"+studentId;
	}
	
}
