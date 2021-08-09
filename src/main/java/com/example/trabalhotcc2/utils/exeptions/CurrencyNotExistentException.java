package com.example.trabalhotcc2.utils.exeptions;

import lombok.Getter;
import java.util.ArrayList;

@Getter
public class CurrencyNotExistentException extends Exception {
	private final ArrayList<String> currencies;

	public CurrencyNotExistentException() {
		currencies = new ArrayList<>();
	}

	public void addCurrency(String currency){
		currencies.add(currency);
	}

	@Override
	public String toString() {

		String collect = String.join(",", currencies);

		return "Currencies does not exist " + collect;
	}
}
