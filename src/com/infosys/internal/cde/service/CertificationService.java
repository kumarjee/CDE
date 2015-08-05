package com.infosys.internal.cde.service;

import java.util.List;

import com.infosys.internal.cde.model.Certification;

public interface CertificationService {
	public List<Certification> listCertifications();

	public List<Certification> getCertificationByCertificationId(Long certificationId);
}
