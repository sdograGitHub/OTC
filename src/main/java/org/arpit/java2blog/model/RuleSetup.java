package org.arpit.java2blog.model;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * @author raghav.rampal
 *
 */
@Entity
@Audited
@Table(name="Rule_SetUp")
public class RuleSetup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public RuleSetup() {
		isQualified = false;
		isWinner = false;
		winningPriority = "";
	}
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="ruleNumber")
	private Integer ruleNumber;

	@Column(name="customerName")
	private String ruleName;

	@OneToOne(cascade = CascadeType.ALL,targetEntity=Account.class)
	private Account account;
	
	@OneToOne(cascade = CascadeType.ALL,targetEntity=Product.class)
	private Product product;
	
	@OneToOne(cascade = CascadeType.ALL,targetEntity=Discount.class)
	private Discount discount;
	
	@OneToOne(cascade = CascadeType.ALL,targetEntity=Offer.class)
	private Offer offer;

	@Column(name = "isActive")
	private boolean isActive;

	private Boolean isQualified;
	private Boolean isWinner;

	@Column(name = "winningPriority")
	private String winningPriority ;

	@Column(name = "discountRange1")
	private Integer discountRange1;

	@Column(name = "discountRange2")
	private Integer discountRange2;

	@Column(name = "quantityRange1")
	private Integer quantityRange1;

	@Column(name = "quantityRange2")
	private Integer quantityRange2;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

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

	public Boolean getIsQualified() {
		return isQualified;
	}

	public void setIsQualified(Boolean isQualified) {
		this.isQualified = isQualified;
	}

	public String getWinningPriority() {
		return winningPriority;
	}

	public void setWinningPriority(String winningPriority) {
		this.winningPriority = winningPriority;
	}

	public Boolean getIsWinner() {
		return isWinner;
	}

	public void setIsWinner(Boolean isWinner) {
		this.isWinner = isWinner;
	}

	public Integer getDiscountRange1() {
		return discountRange1;
	}

	public void setDiscountRange1(Integer discountRange1) {
		this.discountRange1 = discountRange1;
	}

	public Integer getDiscountRange2() {
		return discountRange2;
	}

	public void setDiscountRange2(Integer discountRange2) {
		this.discountRange2 = discountRange2;
	}

	public Integer getQuantityRange1() {
		return quantityRange1;
	}

	public void setQuantityRange1(Integer quantityRange1) {
		this.quantityRange1 = quantityRange1;
	}

	public Integer getQuantityRange2() {
		return quantityRange2;
	}

	public void setQuantityRange2(Integer quantityRange2) {
		this.quantityRange2 = quantityRange2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public HashMap<Integer, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, Integer> map) {
		this.map = map;
	}

}
