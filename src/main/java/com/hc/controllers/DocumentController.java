package com.hc.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hc.data.models.Document;
import com.hc.data.models.Patient;
import com.hc.data.repositories.IDocumentRepository;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {
	@Autowired
	private IDocumentRepository documentRepository;

	public DocumentController() {
		System.out.println("DocumentController()");
	}

	@RequestMapping(method = RequestMethod.POST)
	public Document create(@RequestBody Document document) {
		return documentRepository.save(document);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") UUID id) {
		documentRepository.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Document findById(@PathVariable("id") UUID id) {
		return documentRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Document update(@RequestBody Document document) {
		return documentRepository.save(document);
	}
	
	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
	public List<Document> search(@PathVariable("patientId") UUID patientId) {
		return documentRepository.findByPatientId(patientId);
	}
}
