package com.example.trabalhotcc2.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CurrencyConversions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String fromCurrency;
	@NotNull
	private String toCurrency;
	@NotNull
	private float exchangeValue;


}
