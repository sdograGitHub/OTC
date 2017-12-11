/**
 * 
 */
package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * @author raghav.rampal
 *
 */

@Entity
@Audited
@Table(name="Rule_Qualifier")
public class RuleQualifier {
	
    @Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer ruleQualifierId;
	
	public Integer getRuleQualifierId() {
		return ruleQualifierId;
	}

	public void setRuleQualifierId(Integer ruleQualifierId) {
		this.ruleQualifierId = ruleQualifierId;
	}

	@Column(name="ruleNumber")
	private Integer ruleNumber;
	
	@Column(name="ruleName")
	private String ruleName;


	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Integer getRuleNumber() {
		return ruleNumber;
	}

	public void setRuleNumber(Integer ruleNumber) {
		this.ruleNumber = ruleNumber;
	}
	
}
