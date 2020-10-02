package com.franka.people.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int number;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expirationDate;
	@NotBlank
	private String state;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	public License() {
		
	}

	public License(int number,Date expirationDate, String state, Person person) {
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
		this.person = person;
	}
	
	public String numberFormatted() {
		String num = "";
		String n = "" + this.number;
		for(int i = 0; i<6-n.length(); i++)
			num +=0;
		num += this.number;
		return num;
	}
	
	public String expDateFormatted() {
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		return f.format(this.expirationDate);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
}
