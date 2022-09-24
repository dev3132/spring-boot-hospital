package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entity.Patient;
import com.patient.service.PatientService;
import com.patient.service.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/")
	public ResponseEntity<List<Patient>> getAllPatient(){
		try {
			return new ResponseEntity<List<Patient>>(patientServiceImpl.getAllPatient(), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		try {
			return new ResponseEntity<Patient>(patientServiceImpl.savePatient(patient), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{patientId}")
	public ResponseEntity<Patient> findByPatientId(@PathVariable("patientId") Long patientId){
		try {
			return new ResponseEntity<Patient>(patientServiceImpl.findByPatientId(patientId), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}












