package com.hc.data.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hc.data.models.DeviceData;
import com.hc.data.models.Document;

@Repository
public interface IDeviceDataRepository  extends CrudRepository<DeviceData, UUID> {
	@Query("SELECT * FROM hc_device_data WHERE patient_id = ?0 ALLOW FILTERING")
	List<DeviceData> findByPatientId(UUID patientId);
	@Query("SELECT * FROM hc_device_data WHERE patient_id = ?0 AND data_type = ?1 ALLOW FILTERING")
	List<DeviceData> findByPatientIdAndDataType(UUID patientId, String dataType);
}
