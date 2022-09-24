package com.orchard.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orchard.doctor.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
//	@Query(name = "SELECT doctor_name FROM doctor",nativeQuery = true)
//	List<String> findByDoctorName(@Param("doctorName") String DoctorName);
	
	@Query(value= "select doctor_name from doctor",nativeQuery = true)
	public List<String> getAll();

	public Doctor findByDoctorId(Long doctorId);
}
