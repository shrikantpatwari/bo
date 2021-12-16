package com.woo.bo.data.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="wooUser")
@Data
public class WooUser {
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userId;
	private String userName;
	private String sponserName;
	private long sponserId;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;
	private String sponserName;
	private long SponserId;
	
	

}
