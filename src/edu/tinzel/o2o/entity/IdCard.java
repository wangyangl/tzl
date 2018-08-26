package edu.tinzel.o2o.entity;

/**
 * IdCard entity. @author MyEclipse Persistence Tools
 */

public class IdCard implements java.io.Serializable {

	// Fields

	private Integer cardId;
	private Integer personId;
	private String cardNo;
	
	
	
	//=============一对一=============
	private Person person;
	

	// Constructors

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	//=============一对一=============
	
	
	
	
	
	
	/** default constructor */
	public IdCard() {
	}

	/** full constructor */
	public IdCard(Integer personId, String cardNo) {
		this.personId = personId;
		this.cardNo = cardNo;
	}

	// Property accessors

	public Integer getCardId() {
		return this.cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}