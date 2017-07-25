package iss.sa42.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iss.sa42.team8.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
      
}
