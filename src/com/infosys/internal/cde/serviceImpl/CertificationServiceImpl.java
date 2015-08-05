package com.infosys.internal.cde.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.internal.cde.dao.CertificationDao;
import com.infosys.internal.cde.model.Certification;
import com.infosys.internal.cde.service.CertificationService;

@Service("certificationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CertificationServiceImpl implements CertificationService {
	@Autowired
	private CertificationDao certificationDao;
	
	public List<Certification> listCertifications(){		   
		   return certificationDao.listCertification();	 
	 }
	
	public List<Certification> getCertificationByCertificationId(Long certificationId){
		   return certificationDao.getCertificationByCertificationId(certificationId);
	 }

}
