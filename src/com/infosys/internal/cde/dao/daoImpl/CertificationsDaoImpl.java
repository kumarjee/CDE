package com.infosys.internal.cde.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.internal.cde.dao.CertificationDao;
import com.infosys.internal.cde.model.Certification;
import com.infosys.internal.cde.model.User;

@Repository("certificationDao")
public class CertificationsDaoImpl implements CertificationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Certification> listCertification() {
		return (List<Certification>) sessionFactory.getCurrentSession()
				.createCriteria(Certification.class).list();
	}

	@Override
	public List<Certification> getCertificationByCertificationId(Long certificationId) {
		return sessionFactory.getCurrentSession().createQuery(
				"from Certification where certificationId=:certificationId").setParameter(
				"certificationIdId", certificationId).list();
	}
}
