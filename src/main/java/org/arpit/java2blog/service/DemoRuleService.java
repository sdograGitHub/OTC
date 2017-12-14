package org.arpit.java2blog.service;

import java.util.List;

import org.arpit.java2blog.model.OrderLine;
import org.arpit.java2blog.model.RuleSetup;
import org.arpit.java2blog.model.StandardRuleSetup;
import org.arpit.java2blog.model.form.DemoForm;
import org.springframework.ui.Model;


public interface DemoRuleService<T> {
    void addRule(DemoForm demoForm);
	public List<RuleSetup>getRuleSetupList();
	void addStandardRule(DemoForm demoForm);
	public List<StandardRuleSetup>getStandardRuleSetupList();
	public List<OrderLine>getOrderSetupList();
	void addOrder(DemoForm demoForm);
	public String generateOffer(DemoForm demoForm, Model model);
	public List<RuleSetup> getRuleSetUpRev(int id);
	
}
