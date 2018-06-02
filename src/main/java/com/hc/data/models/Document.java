package com.hc.data.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("hc_documents")
public class Document implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1028959824171306315L;
	
	@PrimaryKey("document_id")
	private UUID documentId;
	@Column("patient_id")
	private UUID patientId;
	@Column("docu_name")
	private String docuName;
	@Column("docu_meta")
	private String docuMeta;
	private boolean validated;
	private String tags;
	
	public UUID getDocumentId() {
		return documentId;
	}
	public void setDocumentId(UUID documentId) {
		this.documentId = documentId;
	}
	public UUID getPatientId() {
		return patientId;
	}
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}
	public String getDocuName() {
		return docuName;
	}
	public void setDocuName(String docuName) {
		this.docuName = docuName;
	}
	public String getDocuMeta() {
		return docuMeta;
	}
	public void setDocuMeta(String docuMeta) {
		this.docuMeta = docuMeta;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
