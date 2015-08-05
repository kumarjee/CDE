package com.infosys.internal.cde.dao;

import java.util.List;

import com.infosys.internal.cde.model.Certification;

public interface CertificationDao {
	public List<Certification> listCertification();

	public List<Certification> getCertificationByCertificationId(Long certificationId);
}
