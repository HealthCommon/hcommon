package com.hc.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hc.data.models.Patient;
import com.hc.data.repositories.IPatientRepository;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
	@Autowired
	private IPatientRepository patientRepository;

	public PatientController() {
		System.out.println("PatientController()");
	}

	@RequestMapping(method = RequestMethod.POST)
	public Patient create(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") UUID id) {
		patientRepository.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Patient findById(@PathVariable("id") UUID id) {
		return patientRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Patient update(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public List<Patient> search(@PathVariable("userId") UUID userId) {
		return patientRepository.findByUserId(userId);
	}
}
