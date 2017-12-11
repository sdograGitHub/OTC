package org.arpit.java2blog.model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name="OrderLine")
public class OrderLine implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer orderLineId;
    
    @OneToOne(cascade = CascadeType.ALL,targetEntity=Item.class)
    private Item item;
    
    @Column(name="quantity")
    private Integer quantity;
    
    @OneToOne(cascade = CascadeType.ALL,targetEntity=Discount.class)
    private Discount discount;
    
    @OneToOne(cascade = CascadeType.ALL,targetEntity=Account.class)
    private Account account;
    
    @OneToOne(cascade = CascadeType.ALL,targetEntity=Product.class)
    private Product product;
    
    
    @Column(name="ruleWinner")
    private Integer ruleWinner; 
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ORDERLINE_QUALIFIER", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "ruleQualifierId") })	
	private List<RuleQualifier> ruleQualifier = new ArrayList<RuleQualifier>();
    
    public OrderLine() {
    }
    
    public Item getItem() {
        return item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void increaseDiscount(double increase) {
        if (discount == null) {
            discount = new Discount(0.0);
        }
        discount.setPercentage(discount.getPercentage() + increase);
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
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

	public List<RuleQualifier> getRuleQualifier() {
		return ruleQualifier;
	}

	public void setRuleQualifier(List<RuleQualifier> ruleQualifier) {
		this.ruleQualifier = ruleQualifier;
	}

	public Integer getRuleWinner() {
		return ruleWinner;
	}

	public void setRuleWinner(Integer ruleWinner) {
		this.ruleWinner = ruleWinner;
	}

	public Integer getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
	}

	
    
    

}
