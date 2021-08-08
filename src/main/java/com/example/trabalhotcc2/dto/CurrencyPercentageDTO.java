package com.example.trabalhotcc2.dto;

import com.example.trabalhotcc2.model.CurrencyConversions;
import lombok.Data;

@Data
public class CurrencyPercentageDTO {
	private String from;
	private String to;
	private float value;

	public CurrencyPercentageDTO(CurrencyConversions currencyConversions){
		this.from = currencyConversions.getFromCurrency();
		this.to = currencyConversions.getToCurrency();
		this.value = currencyConversions.getExchangeValue();
	}
}
