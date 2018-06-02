package com.hc.controllers;

import java.util.List;
import java.util.UUID;

import org.apache.http.entity.ContentType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hc.data.models.DeviceData;
import com.hc.data.models.Patient;
import com.hc.data.repositories.IDeviceDataRepository;
import com.hc.data.repositories.IPatientRepository;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {
	@Autowired
	private IDeviceDataRepository deviceDataRepository;

	@Autowired
	private IPatientRepository patientRepository;

	public DeviceController() {
		System.out.println("DeviceController()");
	}

	@RequestMapping(value = "/sync", method = RequestMethod.POST)
	public ResponseEntity<String> syncData(@RequestBody String data) throws JSONException {
		
		JSONObject deviceData = new JSONObject(data);
		if (deviceData != null) {
			if (deviceData.has("mobile") && deviceData.has("device_id") && deviceData.has("data")) {
				String mobile = deviceData.getString("mobile");
				String deviceId = deviceData.getString("device_id");
				JSONArray dataRows = deviceData.optJSONArray("data");
				
				Patient patient = patientRepository.findByDeviceId(deviceId);
				UUID patientId = patient.getPatientId();
				
				if (dataRows != null) {
					for (int i = 0; i <= dataRows.length(); i++) {
						JSONObject row = dataRows.optJSONObject(i);
						if (row != null) {

							String dataType = row.getString("type");
							String rawData = row.getString("response");
							String uniqueId = row.getString("unique_id");
							String dateTime = row.getString("timestamp");
							long epoch = System.currentTimeMillis();
							DeviceData dData = new DeviceData(UUID.randomUUID(), mobile, deviceId, patientId, dataType, rawData,
									uniqueId, dateTime, epoch);
							deviceDataRepository.save(dData);
						}
					}
				}
			}
		}
			
		
			JSONObject response = new JSONObject();
			JSONObject responseBody = new JSONObject();
			responseBody.put("msg", "successfully synced");
			responseBody.put("status", "success");

			response.put("status", "200");
			response.put("responseBody", responseBody);
			return ResponseEntity
			        .status(HttpStatus.OK)
			        .body(response.toString());
	}

	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
	public List<DeviceData> search(@PathVariable("patientId") UUID patientId) {
		return deviceDataRepository.findByPatientId(patientId);
	}

	@RequestMapping(value = "/patient/{patientId}/type/{type}", method = RequestMethod.GET)
	public List<DeviceData> search(@PathVariable("patientId") UUID patientId, @PathVariable("type") String type) {
		return deviceDataRepository.findByPatientIdAndDataType(patientId, type);
	}
}
