package org.arpit.java2blog.controller;

import  org.arpit.java2blog.model.form.DemoForm;
import org.arpit.java2blog.service.DemoRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CustomerController {

	@Autowired
	DemoRuleService ruleService;

	@RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model,@ModelAttribute("demoForm") DemoForm formData) {
		return getIndex(model);
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
    public String getHomePageindex(Model model,@ModelAttribute("demoForm") DemoForm formData) {
		return getHomeIndex(model);
	}
  /*  Add Rule*/
    @RequestMapping(value="/addRule", method=RequestMethod.POST)
    public String addRule(@ModelAttribute DemoForm demoForm,Model model) {
		ruleService.addRule(demoForm);
		return getIndex(model);
    }
    
    /*Add Order*/
    @RequestMapping(value="/addOrder", method=RequestMethod.POST)
    public String addOrder(@ModelAttribute DemoForm demoForm, Model model) {
    	
    	ruleService.addOrder(demoForm);
		return getIndex(model);
    }
    
    /*Generate Offer*/
    @RequestMapping(value="/generateOffer", method=RequestMethod.POST)
    public String generateOffer(@ModelAttribute DemoForm demoForm, Model model) {
    	
    	ruleService.generateOffer(demoForm, model);
		return getIndex(model);
    }
    
    /*Add StandardRule*/
    @RequestMapping(value="/addStandardRule", method=RequestMethod.POST)
    public String addStandardRule(@ModelAttribute DemoForm demoForm, Model model) {
    	
    	ruleService.addStandardRule(demoForm);
		return getIndex(model);
    }
    
    /*Delete Order*/
    @RequestMapping(value="/deleteOrder", method=RequestMethod.POST)
    public String deleteOrder(@ModelAttribute DemoForm demoForm, Model model) {
    	
    	ruleService.addRule(demoForm);
		return getIndex(model);
    }
  
    /*Delete RuleSet*/
    @RequestMapping(value="/deleteRuleSet", method=RequestMethod.POST)
    public String deleteRuleSet(@ModelAttribute DemoForm demoForm, Model model) {
    	
    	ruleService.addRule(demoForm);
		return getIndex(model);
    }
    
    /*ExportRuleData*/
    @RequestMapping(value="/exportRuleData", method=RequestMethod.POST)
    public String exportRuleData(@ModelAttribute DemoForm demoForm, Model model) {
    	
    	ruleService.addRule(demoForm);
		return getIndex(model);
    }
  
    private String getIndex(Model model){
    	model.addAttribute("ruleSetUpList", ruleService.getRuleSetupList());
    	model.addAttribute("standardRuleSetUpList", ruleService.getStandardRuleSetupList());
    	model.addAttribute("orderLineList",  ruleService.getOrderSetupList());
    	model.addAttribute("demoForm", new DemoForm());
		return "index";
	}
    
    private String getHomeIndex(Model model){
    	model.addAttribute("ruleSetUpList", ruleService.getRuleSetupList());
    	model.addAttribute("standardRuleSetUpList", ruleService.getStandardRuleSetupList());
    	model.addAttribute("orderLineList",  ruleService.getOrderSetupList());
    	model.addAttribute("demoForm", new DemoForm());
		return "home";
	}
}
