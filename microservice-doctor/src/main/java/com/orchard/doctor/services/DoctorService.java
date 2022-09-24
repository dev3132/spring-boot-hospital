package com.orchard.doctor.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.orchard.doctor.entity.Doctor;

public interface DoctorService {
	
	public List<Doctor> getAllDoctor();
	public Doctor saveDoctor(Doctor doctor);
//	public List<String> getAllDoctorsName();
	public Doctor findByDoctorId(Long doctorId);
}
