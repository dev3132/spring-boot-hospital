package com.orchard.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDoctorApplication.class, args);
	}

}
