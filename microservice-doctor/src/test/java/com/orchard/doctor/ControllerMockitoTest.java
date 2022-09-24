package com.orchard.doctor;

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

import com.orchard.doctor.controller.DoctorController;
import com.orchard.doctor.entity.Doctor;
import com.orchard.doctor.services.DoctorServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { ControllerMockitoTest.class })
public class ControllerMockitoTest {
		
	 @Mock
	 DoctorServiceImpl doctorServiceImpl;
	 
	 @InjectMocks
	 DoctorController doctorController;
	   
	 List<Doctor> listDoctors = new ArrayList<>();
	 Doctor doctor;
	 
	 @Test
	 @Order(1)
	 public void test_getAllDoctors() {
		 
		 listDoctors.add(new Doctor(1l, "rahul",23, "male", "eye"));
		 
		 when(doctorServiceImpl.getAllDoctor()).thenReturn(listDoctors);
		 
		 ResponseEntity<List<Doctor>> res = doctorController.getAllDoctor();
		 
		 assertEquals(HttpStatus.OK, res.getStatusCode());
		 assertEquals(1, res.getBody().size());
	 }
	 
	 @Test
	 @Order(2)
	 public void test_saveDoctor() {
		 
		 doctor = new Doctor(1l, "rahul",23, "male", "eye");
		 
		 when(doctorServiceImpl.saveDoctor(doctor)).thenReturn(doctor);
	 
		 ResponseEntity<Doctor> res = doctorController.saveDoctor(doctor);
		 
		 assertEquals(doctor, res.getBody());
	 }
	 
	 @Test
	 @Order(3)
	 public void test_findByDoctorId() {
	
		 doctor = new Doctor(1l, "rahul",23, "male", "eye");
		 long id = 1l;
		 
		 when(doctorServiceImpl.findByDoctorId(id)).thenReturn(doctor);
		 
		 ResponseEntity<Doctor> res = doctorController.findByDoctorId(id);
		 
		 assertEquals(id, res.getBody().getDoctorId());
	 
	 }
}

















