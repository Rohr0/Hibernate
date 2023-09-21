package org.jsp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Merchant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,email,password,gst;
	private long phone;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "merchants")
	private List<Product> products;
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", gst=" + gst
				+ ", phone=" + phone + "]";
	}

	
}
