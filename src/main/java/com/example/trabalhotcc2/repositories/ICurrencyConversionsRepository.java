package com.example.trabalhotcc2.repositories;

import com.example.trabalhotcc2.model.CurrencyConversions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICurrencyConversionsRepository extends JpaRepository<CurrencyConversions, Long> {
	Optional<CurrencyConversions> findCurrencyConversionsByFromCurrencyEqualsAndToCurrencyEquals(String fromCurrency,
																								 String toCurrency);
}
