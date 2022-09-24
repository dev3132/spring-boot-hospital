package com.patient.service;

import java.util.List;

import com.patient.entity.Patient;

public interface PatientService {
	
	public List<Patient> getAllPatient();
	public Patient savePatient(Patient patient);
	public Patient findByPatientId(Long patientId);
}
