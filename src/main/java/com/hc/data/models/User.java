package com.hc.data.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.data.rest.core.annotation.RestResource;

@EntityScan
@Table(value = "hc_users")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1098959824171306315L;
	
	@PrimaryKey(value = "user_id")	
	private UUID userId;
	@Column(value = "full_name")
	private String fullName;
	private String mobile;
	private String password;
	private String email;
	@Column(value = "image_url")
	private String imageURL;
	private String otp;
	
	User() {
		this.userId = UUID.randomUUID();
	}
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getUserId() {
		return userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
}
