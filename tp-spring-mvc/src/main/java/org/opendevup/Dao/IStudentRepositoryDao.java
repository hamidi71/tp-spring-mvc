package org.opendevup.Dao;

import java.util.Date;
import java.util.List;

import org.opendevup.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepositoryDao extends JpaRepository<Student, Long>{
	public List<Student> findByNom(String n);
	public Page<Student> findByNom(String n,Pageable pageable);
	@Query("select e from Student e where e.nom like:x")
	public Page<Student> chercherStudent(@Param("x") String mc,Pageable pageable);
	
	@Query("select e from Student e where e.dateNaissance >:x and e.dateNaissance<:y")
	public List<Student> chercherStudent(@Param("x") Date d1,@Param("y")Date d2);
} 
