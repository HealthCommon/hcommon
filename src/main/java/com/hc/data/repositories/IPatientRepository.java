package com.hc.data.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hc.data.models.Patient;

@Repository
public interface IPatientRepository  extends CrudRepository<Patient, UUID> {
	@Query("SELECT * FROM hc_patients WHERE user_id = ?0 ALLOW FILTERING")
	List<Patient> findByUserId(UUID userId);
	
	@Query("SELECT * FROM hc_patients WHERE devices = ?0 ALLOW FILTERING")
	Patient findByDeviceId(String deviceId);
}
