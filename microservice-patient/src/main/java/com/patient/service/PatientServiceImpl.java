package com.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Patient;
import com.patient.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatient() {
		
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		
		return patientRepository.save(patient);
	}

	@Override
	public Patient findByPatientId(Long patientId) {
		
		return patientRepository.findByPatientId(patientId);
	}
}
