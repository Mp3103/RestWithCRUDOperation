package com.meet.studentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meet.StudentIterface.StudentInterface;
import com.meet.entity.Student;
@Service
public class StudentServiceImpl implements StudentService {

	private StudentInterface studentInterface;
	
	
	@Autowired
	public StudentServiceImpl(StudentInterface studentInterface) {
		super();
		this.studentInterface = studentInterface;
	}


	@Override
	public List<Student> studentList() {
		
		return studentInterface.findAll();
	}


	@Override
	public Student findStudentByID(int id) {
		return studentInterface.getOne(id);
	}


	@Override
	public Student addNewStudent(Student student) {
		return studentInterface.save(student);
	}


	@Override
	public void deleteCustomerId(int id) {
		 studentInterface.deleteById(id);	
	}
	

}
