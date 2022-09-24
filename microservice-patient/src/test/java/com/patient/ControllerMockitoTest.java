package com.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.patient.controller.PatientController;
import com.patient.entity.Patient;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientService;
import com.patient.service.PatientServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { ControllerMockitoTest.class })
public class ControllerMockitoTest {

	@Mock
	PatientServiceImpl patientServiceImpl;

	@InjectMocks
	PatientController patientController;

	List<Patient> listPatients = new ArrayList<>();
	Patient patient;

	@Test
	@Order(1)
	public void test_getAllPatient() {

		listPatients.add(new Patient(1l, "rahul", 23, "rahul", "22-08-2022"));

		when(patientServiceImpl.getAllPatient()).thenReturn(listPatients);

		ResponseEntity<List<Patient>> res = patientController.getAllPatient();

		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	@Test
	@Order(2)
	public void test_savePatient() {

		patient = new Patient(1l, "rahul", 23, "rahul", "22-08-2022");

		when(patientServiceImpl.savePatient(patient)).thenReturn(patient);

		ResponseEntity<Patient> res = patientController.savePatient(patient);

		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(patient, res.getBody());
	}

	@Test
	@Order(3)
	public void test_findByPatientId() {

		patient = new Patient(1l, "rahul", 23, "rahul", "22-08-2022");
		long id = 1l;

		when(patientServiceImpl.findByPatientId(id)).thenReturn(patient);

		ResponseEntity<Patient> res = patientController.findByPatientId(id);

		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(id, res.getBody().getPatientId());
	}
}
