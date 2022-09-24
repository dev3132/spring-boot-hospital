package com.orchard.doctor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orchard.doctor.entity.Doctor;
import com.orchard.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getAllDoctor() {
		
		return doctorRepository.findAll();
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor findByDoctorId(Long doctorId) {
		List<Doctor> doctors = doctorRepository.findAll();
		Doctor foundDoctor = null;
		for (Doctor doctor : doctors) {
			if(doctor.getDoctorId() == doctorId) {
				foundDoctor = doctor;
			}
		}
		return foundDoctor;
//		return doctorRepository.findByDoctorId(doctorId);
	}


	

	
	
	

}
