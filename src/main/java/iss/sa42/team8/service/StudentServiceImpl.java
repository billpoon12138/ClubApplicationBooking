package iss.sa42.team8.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa42.team8.exception.StudentNotFound;
import iss.sa42.team8.model.Student;
import iss.sa42.team8.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentRepository studentRepository;

	@Override
	@Transactional
	public Student create(Student s) {
		Student createdStudent = s;
		return studentRepository.save(createdStudent);
	}
	
	@Override
	@Transactional
	public Student findById(long id) {
		return studentRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=StudentNotFound.class)
	public Student delete(long id) throws StudentNotFound {
		Student deletedStudent = studentRepository.findOne(id);
		
		if (deletedStudent == null)
			throw new StudentNotFound();
		
		studentRepository.delete(deletedStudent);
		return deletedStudent;
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=StudentNotFound.class)
	public Student update(Student s) throws StudentNotFound {
		Student updatedStudent = studentRepository.findOne(s.getId());
		
		if (updatedStudent== null)
			throw new StudentNotFound();
		
		updatedStudent.setName(s.getName());
		updatedStudent.setNick(s.getNick());
		updatedStudent.setFee(s.getFee());
		updatedStudent.setGrade(s.getGrade());
		studentRepository.flush();
		return updatedStudent;
	}

}
