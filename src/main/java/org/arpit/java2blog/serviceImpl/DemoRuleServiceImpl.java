package org.arpit.java2blog.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.arpit.java2blog.dao.DemoRuleDao;
import org.arpit.java2blog.model.Account;
import org.arpit.java2blog.model.Discount;
import org.arpit.java2blog.model.Offer;
import org.arpit.java2blog.model.OrderLine;
import org.arpit.java2blog.model.Product;
import org.arpit.java2blog.model.RuleSetup;
import org.arpit.java2blog.model.StandardRuleSetup;
import org.arpit.java2blog.model.form.DemoForm;
import org.arpit.java2blog.revListner.CustomAgendaEventListener;
import org.arpit.java2blog.service.DemoRuleService;
import org.constants.Constants;
import org.kie.internal.event.KnowledgeRuntimeEventManager;
import org.kie.internal.logger.KnowledgeRuntimeLogger;
import org.kie.internal.logger.KnowledgeRuntimeLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.technorage.demo.drools.FactFinder;
import com.technorage.demo.drools.monitoring.TrackingAgendaEventListener;
import com.technorage.demo.drools.monitoring.TrackingWorkingMemoryEventListener;
import com.technorage.demo.drools.spring.DefaultKieSessionBean;
import com.technorage.demo.drools.spring.KieContainerBean;
import com.technorage.demo.drools.spring.KieServicesBean;
import com.technorage.demo.drools.spring.KieSessionBean;

@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode=ScopedProxyMode.INTERFACES)
public class DemoRuleServiceImpl implements DemoRuleService{

	@Autowired
	DemoRuleDao demoRuleDao;

	public KieSessionBean kieSession;
	private TrackingAgendaEventListener agendaEventListener;
	private TrackingWorkingMemoryEventListener workingMemoryEventListener;

	@Autowired
	public DemoRuleServiceImpl(
			@Qualifier("demoKieContainer") KieContainerBean kieContainer,@Qualifier("demoKieServices") KieServicesBean kieServices) {

		kieSession = new DefaultKieSessionBean(kieServices, kieContainer);

		agendaEventListener = new TrackingAgendaEventListener();
		workingMemoryEventListener = new TrackingWorkingMemoryEventListener();

		kieSession.addEventListener(agendaEventListener);
		kieSession.addEventListener(workingMemoryEventListener);
		kieSession.addEventListener( new CustomAgendaEventListener() ); //audit

		//using global variable in drool
		//kieSession.setGlobal("isRuleValid", true);

	}

	@Override
	public void addRule(DemoForm demoForm) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		RuleSetup ruleSetup = new RuleSetup();
		ruleSetup.setRuleNumber(demoForm.getRuleNumber());
		ruleSetup.setRuleName(demoForm.getRuleName());

		Account account = new Account();
		account.setAccountNumber(demoForm.getAccountNumber());
		if(demoForm.getAccountType().equals("")) {
			account.setAccountType(null);
		}else {
			account.setAccountType(demoForm.getAccountType());
		}
		ruleSetup.setAccount(account);

		Product product = new Product();
		if(demoForm.getFc().equals("")) {
			product.setFamilyCode(null);
		}else {
			product.setFamilyCode(demoForm.getFc());
		}
		product.setIsbn(demoForm.getIsbn());
		if(demoForm.getDgp().equals("")) {
			product.setProductGroupCode(null);
		}else {
			product.setProductGroupCode(demoForm.getDgp());
		}
		ruleSetup.setProduct(product);

		Discount discount = new Discount();
		discount.setPercentage(demoForm.getDiscount());
		ruleSetup.setDiscount(discount);

		Offer offer =new Offer();
		offer.setComboField(demoForm.getCombo());
		offer.setHardcode(demoForm.isHardcode());
		offer.setPriority(demoForm.getPriority());
		offer.setOverridenExplicitly(demoForm.isOverridenExplicitly());
		offer.setDays(demoForm.getTerms());
		offer.setFrieghtCharge(demoForm.getFrieghtCharge());
		ruleSetup.setOffer(offer);

		ruleSetup.setDiscountRange1(demoForm.getDiscountRange1());
		ruleSetup.setDiscountRange2(demoForm.getDiscountRange2());
		ruleSetup.setQuantityRange1(demoForm.getQuantityRange1());
		ruleSetup.setQuantityRange2(demoForm.getQuantityRange2());

		if(demoForm.getQuantityRange1()!=null && demoForm.getDiscountRange1()!=null) {
			map.put(demoForm.getQuantityRange1(), demoForm.getDiscountRange1());
		}
		if(demoForm.getQuantityRange2()!=null && demoForm.getDiscountRange2()!=null) {
			map.put(demoForm.getQuantityRange2(), demoForm.getDiscountRange2());
		}
		ruleSetup.setMap(map);

		kieSession.insert(ruleSetup);
		kieSession.insert(ruleSetup.getOffer());

		demoRuleDao.addRuleSetUp(ruleSetup);
	}

	@Override
	public List<RuleSetup> getRuleSetupList() {
		// TODO Auto-generated method stub
		return demoRuleDao.getAllRuleSetup();
	}

	@Override
	public void addStandardRule(DemoForm demoForm) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		StandardRuleSetup standardRuleSetup = new StandardRuleSetup();
		standardRuleSetup.setRuleNumber(demoForm.getRuleNumber());
		standardRuleSetup.setRuleName(demoForm.getRuleName());

		Account account = new Account();
		account.setAccountNumber(demoForm.getAccountNumber());
		if("".equals(demoForm.getAccountType())) {
			account.setAccountType(null);
		}else {
			account.setAccountType(demoForm.getAccountType());
		}
		standardRuleSetup.setAccount(account);

		Product product = new Product();
		if("".equals(demoForm.getFc())) {
			product.setFamilyCode(null);
		}else {
			product.setFamilyCode(demoForm.getFc());
		}
		product.setIsbn(demoForm.getIsbn());
		if("".equals(demoForm.getDgp())) {
			product.setProductGroupCode(null);
		}else {
			product.setProductGroupCode(demoForm.getDgp());
		}
		standardRuleSetup.setProduct(product);

		Discount discount = new Discount();
		discount.setPercentage(demoForm.getDiscount());
		standardRuleSetup.setDiscount(discount);
		standardRuleSetup.setDiscountRange1(demoForm.getDiscountRange1());
		standardRuleSetup.setDiscountRange2(demoForm.getDiscountRange2());
		standardRuleSetup.setQuantityRange1(demoForm.getQuantityRange1());
		standardRuleSetup.setQuantityRange2(demoForm.getQuantityRange2());
		standardRuleSetup.setQuantityRange3(demoForm.getQuantityRange3());
		standardRuleSetup.setDiscountRange3(demoForm.getDiscountRange3());

		if(demoForm.getQuantityRange1()!=null && demoForm.getDiscountRange1()!=null) {
			map.put(demoForm.getQuantityRange1(), demoForm.getDiscountRange1());
		}
		if(demoForm.getQuantityRange2()!=null && demoForm.getDiscountRange2()!=null) {
			map.put(demoForm.getQuantityRange2(), demoForm.getDiscountRange2());
		}
		standardRuleSetup.setMap(map);

		kieSession.insert(standardRuleSetup );
		demoRuleDao.addStandradRuleSetUp(standardRuleSetup);

	}

	@Override
	public List<StandardRuleSetup> getStandardRuleSetupList() {
		return demoRuleDao.getAllStandardRuleSetup();

	}

	@Override
	public List<OrderLine> getOrderSetupList() {
		return demoRuleDao.getAllOrderLineSetup();
	}

	@Override
	public void addOrder(DemoForm demoForm) {
		OrderLine orderLine = new OrderLine();
		orderLine.setOrderLineId(demoForm.getOrderLineNumber());

		Account account = new Account();
		account.setAccountNumber(demoForm.getAccountNumber());
		account.setAccountType(demoForm.getAccountType());
		orderLine.setAccount(account);

		Product product = new Product();
		product.setFamilyCode(demoForm.getFc());
		product.setIsbn(demoForm.getIsbn());
		product.setProductGroupCode(demoForm.getDgp());
		orderLine.setProduct(product);
		orderLine.setQuantity(demoForm.getQuantity());

		kieSession.insert( orderLine );
		demoRuleDao.addOrderLineSetUp(orderLine);

	}

	@Override
	public String generateOffer(DemoForm demoForm, Model model) {

		//fire all rules
		System.out.println("Rules fired: " + kieSession.fireAllRules());
		List<RuleSetup> tempRulesQualified = new ArrayList<RuleSetup>();

		Collection<StandardRuleSetup> standardRulesQualified = findQualifiedStdRuleSetupList(null);
		Collection<RuleSetup> rulesQualifiedList = findQualifiedRuleSetupList(null);

		Double netDiscount = 0.0;
		String displayWinnerRule = "";
		String displayWinnerTerms = "";
		String resultString = " ";
		String displayQualifierRule = " ";
		int tempDiscount = 0;

		//fetch order line quantity; only one order line will be processed in single time
		int usedQuantity = 0;
		for(OrderLine line :getOrderSetupList()) {
			if(line.getQuantity()!=null) {
				usedQuantity = line.getQuantity();	
			}

		}

		//for case rule is qualified
		for(RuleSetup ruleSetup : rulesQualifiedList) {
			displayQualifierRule = displayQualifierRule + ", " + ruleSetup.getRuleName();
			tempRulesQualified.add(ruleSetup);

			tempDiscount = getDiscountOnBasisOfQty(usedQuantity, ruleSetup.getMap());
			if(tempDiscount == 0) {

				//case no standard rule exists
				if(ruleSetup.getDiscount()!=null && ruleSetup.getDiscount().getPercentage()!=null) {
					tempDiscount = ruleSetup.getDiscount().getPercentage().intValue();
				}

				//take discount from standard rule if exists
				for(StandardRuleSetup stdRule : standardRulesQualified) {
					tempDiscount = getDiscountOnBasisOfQty(usedQuantity, stdRule.getMap());
				}

			}

			resultString = "  " + ruleSetup.getRuleName() + " wins with discount: " + tempDiscount + "%";
		}

		sortListOnBasisOfRule(tempRulesQualified);

		// standard rule will execute only when none of account rules is qualified
		if(tempRulesQualified.isEmpty()) {
			for(StandardRuleSetup setup : standardRulesQualified) {
				displayQualifierRule = displayQualifierRule + ", " + setup.getRuleName();
				tempDiscount = getDiscountOnBasisOfQty(usedQuantity, setup.getMap());
				resultString = "  " +  setup.getRuleName() + " wins with discount: " + tempDiscount + "%";
			}
		}

		for(RuleSetup setup : tempRulesQualified) {
			//Display winner with combo field parameters included
			if(setup.getIsWinner()) {
				if(setup.getDiscount()!=null && setup.getDiscount().getPercentage()!=null) {
					resultString = resultString + ", " + setup.getRuleName();
					netDiscount = netDiscount + setup.getDiscount().getPercentage();
					displayWinnerRule = displayWinnerRule + ", " + setup.getRuleNumber();
				}

				if(setup.getOffer().getDays() != null) {
					displayWinnerTerms = " and Term " + setup.getOffer().getDays() + " days from Rule " + setup.getRuleNumber();
				}
				//if freight charge is false, it is free freight 
				if(setup.getOffer().getFrieghtCharge().equalsIgnoreCase(Constants.BOOLEAN_FALSE)) {
					displayWinnerTerms = "\n" + displayWinnerTerms + "\n having free freight from Rule " + setup.getRuleNumber();
				}
			}

		}

		if(!displayWinnerRule.isEmpty()) {
			resultString = "  Rule " + displayWinnerRule.substring(2) + " wins with discount: " + netDiscount + "%" + displayWinnerTerms;
		}

		if(!resultString.equals(" ")) {
			model.addAttribute(Constants.NET_OUTPUT, resultString.substring(2));
		}
		if(!displayQualifierRule.equals(" ")) {
			model.addAttribute("qualifiers", displayQualifierRule.substring(2));
		}

		//close sessions
		kieSession.dispose();

		return ("index");
	}

	private static Integer getDiscountOnBasisOfQty(Integer quantity, HashMap<Integer, Integer> map) {
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (quantity <= entry.getKey()) {
				return entry.getValue();
			}
		}

		return 0;
	}

	private static void sortListOnBasisOfRule(List<RuleSetup> rulesQualified) {
		Collections.sort(rulesQualified, new Comparator<RuleSetup>(){
			public int compare(RuleSetup o1, RuleSetup o2){
				return o1.getRuleNumber() - o2.getRuleNumber();
			}
		});
	}

	private Collection<StandardRuleSetup> findQualifiedStdRuleSetupList(DemoForm demoForm) {
		List<StandardRuleSetup> stdRuleQualified = new ArrayList<StandardRuleSetup>();

		//TODO
		for(StandardRuleSetup rule : new FactFinder<StandardRuleSetup>(StandardRuleSetup.class).findFacts(kieSession)) {
			if(rule.getIsQualified()) {
				stdRuleQualified.add(rule);
			}
			rule.setIsQualified(false);
		}

		return stdRuleQualified;
	}

	private Collection<RuleSetup> findQualifiedRuleSetupList(DemoForm demoForm) {
		List<RuleSetup> finalRule = new ArrayList<RuleSetup>();

		//TODO
		for(RuleSetup rule : new FactFinder<RuleSetup>(RuleSetup.class).findFacts(kieSession)) {
			if(rule.getIsQualified()) {
				finalRule.add(rule);
			}
			rule.setIsQualified(false);
		}

		return finalRule;
	}

}



