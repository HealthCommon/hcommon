package com.hc.data.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("hc_device_data")
public class DeviceData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1028959824171306315L;
	
	@PrimaryKey("row_id")
	private UUID rowId;
	@Column("mobile")
	private String mobile;
	@Column("device_id")
	private String deviceId;
	@Column("patient_id")
	private UUID patientId;
	@Column("data_type")
	private String dataType;
	@Column("data")
	private String data;
	@Column("unique_id")
	private String uniqueId;
	@Column("date_time")
	private String dateTime;
	@Column("timestamp")
	private long timestamp;

	DeviceData() {
		this.setRowId(UUID.randomUUID());
	}

	public DeviceData(UUID rowId, String mobile, String device_id,
			UUID patientId, String dataType, 
			String data, String uniqueId,
			String dateTime, long timestamp) {
		this.setRowId(rowId);
		this.setMobile(mobile);
		this.setDeviceId(device_id);
		this.setPatientId(patientId);
		this.setDataType(dataType);
		this.setData(data);
		this.setUniqueId(uniqueId);
		this.setDateTime(dateTime);
		this.setTimestamp(timestamp);
	}

	public UUID getRowId() {
		return rowId;
	}

	public void setRowId(UUID rowId) {
		this.rowId = rowId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
