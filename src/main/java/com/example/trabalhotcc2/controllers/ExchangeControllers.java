package com.example.trabalhotcc2.controllers;

import com.example.trabalhotcc2.dto.CurrencyPercentageDTO;
import com.example.trabalhotcc2.model.CurrencyConversions;
import com.example.trabalhotcc2.repositories.ICurrencyConversionsRepository;
import com.example.trabalhotcc2.utils.exeptions.CurrencyNotExistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/exchange")
public class ExchangeControllers {
	@Autowired
	private ICurrencyConversionsRepository conversionsRepository;

	@GetMapping("/{from}/{to}")
	public ResponseEntity<CurrencyPercentageDTO> getCurrencyPercentage(@PathVariable String from,
																	   @PathVariable String to)
																		throws CurrencyNotExistentException {

		Optional<CurrencyConversions> currencyEquals = conversionsRepository.
				findCurrencyConversionsByFromCurrencyEqualsAndToCurrencyEquals(from, to);

		if (currencyEquals.isEmpty()){
			CurrencyNotExistentException currencyNotExistentException = new CurrencyNotExistentException();
			Optional<CurrencyConversions> byFromCurrency = conversionsRepository.findFirstByFromCurrency(from);

			if(byFromCurrency.isEmpty())
				currencyNotExistentException.addCurrency(from);

			byFromCurrency = conversionsRepository.findFirstByFromCurrency(to);

			if(byFromCurrency.isEmpty())
				currencyNotExistentException.addCurrency(to);

			throw currencyNotExistentException;
		}

		CurrencyPercentageDTO currencyPercentageDTO = new CurrencyPercentageDTO(currencyEquals.get());
		return ResponseEntity.ok(currencyPercentageDTO);
	}

}
