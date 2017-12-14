/**
 * 
 */
package org.arpit.java2blog.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.envers.Audited;

/**
 * @author raghav.rampal
 *
 */
@Entity
@Audited
@Proxy(lazy=false)
@Table(name="Offer")
public class Offer {
	@Id
	@Column(name="offer_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="hardcode")
	private Boolean hardcode = false;
	
	@Column(name="overridenExplicitly")
	private Boolean overridenExplicitly = false;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="comboField")
	private Integer comboField;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "OFFER_TERM", joinColumns = { @JoinColumn(name = "offer_Id") }, inverseJoinColumns = { @JoinColumn(name = "term_id") })
	private List<Terms> terms = new ArrayList<Terms>();
	
	@Column(name="days")
	private Integer days;
	
	@Column(name="promoCode")
    private String promoCode;
	
	@Column(name="frieghtCharge")
    private String frieghtCharge;
	
	public Offer() {
		
	}
	
	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public Boolean getHardcode() {
		return hardcode;
	}

	public void setHardcode(Boolean hardcode) {
		this.hardcode = hardcode;
	}

	public Boolean getOverridenExplicitly() {
		return overridenExplicitly;
	}

	public void setOverridenExplicitly(Boolean overridenExplicitly) {
		this.overridenExplicitly = overridenExplicitly;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public List<Terms> getTerms() {
		return terms;
	}

	public void setTerms(List<Terms> terms) {
		this.terms = terms;
	}

	public Integer getComboField() {
		return comboField;
	}

	public void setComboField(Integer comboField) {
		this.comboField = comboField;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getFrieghtCharge() {
		return frieghtCharge;
	}

	public void setFrieghtCharge(String frieghtCharge) {
		this.frieghtCharge = frieghtCharge;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
