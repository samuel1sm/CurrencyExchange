package com.example.trabalhotcc2.controllers;

import com.example.trabalhotcc2.dto.CurrencyPercentageDTO;
import com.example.trabalhotcc2.model.CurrencyConversions;
import com.example.trabalhotcc2.repositories.ICurrencyConversionsRepository;
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
																	   @PathVariable String to) {
		Optional<CurrencyConversions> currencyEquals = conversionsRepository.
				findCurrencyConversionsByFromCurrencyEqualsAndToCurrencyEquals(from, to);

		if (currencyEquals.isEmpty())
			return ResponseEntity.notFound().build();

		CurrencyPercentageDTO currencyPercentageDTO = new CurrencyPercentageDTO(currencyEquals.get());
		return ResponseEntity.ok(currencyPercentageDTO);
	}

}
