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
@Table(name="Product")
public class Product {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="massProductGroupCode")
	private String massProductGroupCode;
	
	@Column(name="productGroupCode")
	private String productGroupCode;
	
	@Column(name="familyCode")
	private String familyCode;
	
	@Column(name="isbn")
	private Integer isbn;
	
	@Column(name="offerCode")
	private Integer offerCode;
	
	@Column(name="discountGroupCode")
	private String discountGroupCode;
	
	public String getDiscountGroupCode() {
		return discountGroupCode;
	}

	public void setDiscountGroupCode(String discountGroupCode) {
		this.discountGroupCode = discountGroupCode;
	}

	public String getMassProductGroupCode() {
		return massProductGroupCode;
	}
	
	public void setMassProductGroupCode(String massProductGroupCode) {
		this.massProductGroupCode = massProductGroupCode;
	}
	
	public String getProductGroupCode() {
		return productGroupCode;
	}
	
	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}
	
	public String getFamilyCode() {
		return familyCode;
	}
	
	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(Integer offerCode) {
		this.offerCode = offerCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
