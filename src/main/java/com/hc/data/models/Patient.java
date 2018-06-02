package com.hc.data.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@EntityScan
@Table(value = "hc_patients")
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1038959824171306315L;
	
	@PrimaryKey(value = "patient_id")
	private UUID patientId;
	@Column(value = "user_id")
	private UUID userId;
	@Column(value = "full_name")
	private String fullName;
	private String gender;
	private String weight;
	private String height;
	private String age;
	@Column(value = "critical_disease")
	private String disease;
	private String tags;
	private String devices;
	
	public String getDevices() {
		return devices;
	}
	public void setDevices(String devices) {
		this.devices = devices;
	}
	Patient() {
		this.patientId = UUID.randomUUID();
	}
	public UUID getPatientId() {
		return patientId;
	}
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
}
