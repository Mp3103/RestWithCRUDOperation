package com.meet.studentService;

import java.util.List;

import com.meet.entity.Student;

public interface StudentService {

	public List<Student> studentList();
	
	public Student findStudentByID(int id);
	
	public Student addNewStudent(Student student);
	
	public void deleteCustomerId(int id);
	
}
