package com.woo.bo.data.entity;

import lombok.Data;

import javax.persistence.*;

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
}
