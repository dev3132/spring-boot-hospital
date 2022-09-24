package com.orchard.doctor.controller;

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

import com.orchard.doctor.entity.Doctor;
import com.orchard.doctor.repository.DoctorRepository;
import com.orchard.doctor.services.DoctorServiceImpl;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class DoctorController {
	
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	
	@GetMapping("/")
	public ResponseEntity<List<Doctor>> getAllDoctor(){
		try {
			return new ResponseEntity<List<Doctor>>(doctorServiceImpl.getAllDoctor(), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		try {
			return new ResponseEntity<Doctor>(doctorServiceImpl.saveDoctor(doctor), HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	
	
	@GetMapping("/{doctorId}")
	public ResponseEntity<Doctor> findByDoctorId(@PathVariable("doctorId") Long doctorId) {
		try {
			return new ResponseEntity<Doctor>(doctorServiceImpl.findByDoctorId(doctorId), HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
}






