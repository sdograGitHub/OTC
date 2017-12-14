package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.OrderLine;
import org.arpit.java2blog.model.RuleSetup;
import org.arpit.java2blog.model.StandardRuleSetup;;

public interface DemoRuleDao {
	
	public void addRuleSetUp(RuleSetup ruleSetUp);
	public List<RuleSetup> getAllRuleSetup();
	public void addStandradRuleSetUp(StandardRuleSetup standardRuleSetUp);
	public List<StandardRuleSetup> getAllStandardRuleSetup();
	public List<OrderLine> getAllOrderLineSetup();
	public void addOrderLineSetUp(OrderLine orderLine);
	public void deleteRuleSetUp(int id) ;
	public void updateRuleSetUp(RuleSetup ruleSetUp);
	public List<RuleSetup> getRuleSetUpAudit(int id);

}
