package edu.tinzel.o2o.entity;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private Integer personId;
	private String personName;
	
	//=============一对一=============
	private IdCard idCard;
	
	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	//=============一对一=============

	// Constructors
	/** default constructor */
	public Person() {
	}

	
	public Person(Integer personId) {
		super();
		this.personId = personId;
	}

	/** full constructor */
	public Person(String personName) {
		this.personName = personName;
	}

	// Property accessors

	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}