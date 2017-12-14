package org.arpit.java2blog.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.arpit.java2blog.dao.DemoRuleDao;
import org.arpit.java2blog.model.OrderLine;
import org.arpit.java2blog.model.RuleSetup;
import org.arpit.java2blog.model.StandardRuleSetup;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;;

@Repository
public class DemoRuleDaoImpl implements DemoRuleDao {

	@Autowired
	private SessionFactory sessionFactory;
	@PersistenceContext
	private EntityManager entityManager;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	@Transactional
	public void addRuleSetUp(RuleSetup ruleSetUp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(ruleSetUp);
	}
	@Override
	@Transactional
	public List<RuleSetup> getAllRuleSetup() {
		Session session = this.sessionFactory.getCurrentSession();
		List<RuleSetup>  ruleSetUpList = session.createQuery("from RuleSetup").list();
		return ruleSetUpList;
	}
	@Override
	@Transactional
	public void updateRuleSetUp(RuleSetup ruleSetUp) {
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(ruleSetUp);
		session.update(ruleSetUp);
	}
	@Override
	@Transactional
	public void deleteRuleSetUp(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		RuleSetup p = (RuleSetup) session.load(RuleSetup.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
	@Override
	@Transactional
	public void addStandradRuleSetUp(StandardRuleSetup standardRuleSetUp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(standardRuleSetUp);

	}
	@Override
	@Transactional
	public List<StandardRuleSetup> getAllStandardRuleSetup() {
		Session session = this.sessionFactory.getCurrentSession();
		List<StandardRuleSetup>  standardRuleSetUpList = session.createQuery("from StandardRuleSetup").list();
		return standardRuleSetUpList;
	}
	@Override
	@Transactional
	public List<OrderLine> getAllOrderLineSetup() {
		Session session = this.sessionFactory.getCurrentSession();
		List<OrderLine>  orderLineSetUpList = session.createQuery("from OrderLine").list();
		return orderLineSetUpList;
	}
	@Override
	@Transactional
	public void addOrderLineSetUp(OrderLine orderLine) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(orderLine);

	}

	@Override
	@Transactional
	public List<RuleSetup> getRuleSetUpAudit(int id) {
		List<RuleSetup>rulesList=new ArrayList<RuleSetup>();
		Session session = this.sessionFactory.getCurrentSession();
		AuditReader reader = AuditReaderFactory.get(session);
		List<Number> revisions = reader.getRevisions(RuleSetup.class, id);
		for(Number revNum:revisions){
			RuleSetup article =reader.find(RuleSetup.class, id, revNum);
			rulesList.add(article);

		}
		return rulesList;

	}

}
