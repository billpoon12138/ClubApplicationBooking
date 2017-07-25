package iss.sa42.team8.service;

import java.util.List;

import iss.sa42.team8.exception.StudentNotFound;
import iss.sa42.team8.model.Student;

public interface StudentService {
	
	public Student create(Student s);
	public Student delete(long id) throws StudentNotFound;
	public List<Student> findAll();
	public Student update(Student s) throws StudentNotFound;
	public Student findById(long id);

}
