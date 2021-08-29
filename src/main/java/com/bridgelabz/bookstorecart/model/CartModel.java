package com.bridgelabz.bookstorecart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BookCart")
@Data
public class CartModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartid;
	private int userId;
	private int bookId;
	private long quantity;
	
}
