package com.hc.data.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hc.data.models.Document;

@Repository
public interface IDocumentRepository  extends CrudRepository<Document, UUID> {
	@Query("SELECT * FROM hc_documents WHERE patient_id = ?0 ALLOW FILTERING")
	List<Document> findByPatientId(UUID patient_id);
}
