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

import org.hibernate.annotations.Proxy;
import org.hibernate.envers.Audited;

/**
 * @author raghav.rampal
 *
 */
@Entity
@Audited
@Proxy(lazy=false)
@Table(name="Terms")
public class Terms {
	
	@Id
	@Column(name="term_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="days")
	private Integer days;
	
	@Column(name="freeFreightUpgrade")
	private Boolean freeFreightUpgrade;
	
	@Column(name="chargeFreight")
	private Boolean chargeFreight;
	
	@Column(name="returnable")
	private Boolean returnable;

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Boolean getFreeFreightUpgrade() {
		return freeFreightUpgrade;
	}

	public void setFreeFreightUpgrade(Boolean freeFreightUpgrade) {
		this.freeFreightUpgrade = freeFreightUpgrade;
	}

	public Boolean getChargeFreight() {
		return chargeFreight;
	}

	public void setChargeFreight(Boolean chargeFreight) {
		this.chargeFreight = chargeFreight;
	}

	public Boolean getReturnable() {
		return returnable;
	}

	public void setReturnable(Boolean returnable) {
		this.returnable = returnable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
