package com.bindstone.graphbank.service.data.impl;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.service.CountryService;
import com.bindstone.graphbank.service.CurrencyService;
import com.bindstone.graphbank.service.data.CountryCurrencyImportService;
import com.bindstone.graphbank.utils.xml.parser.CountryCurrencyParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class CountryCurrencyServiceImpl implements CountryCurrencyImportService {

    @Autowired
    CountryCurrencyParser countryCurrencyParser;

    @Autowired
    CountryService countryService;

    @Autowired
    CurrencyService currencyService;

    @Override
    public void load() {
        Map<Country, Currency> map = countryCurrencyParser.parse();
        for (Map.Entry<Country, Currency> entity : map.entrySet()) {
            countryService.save(entity.getKey());
            currencyService.save(entity.getValue());
        }
        /**
         for (Country country : countries) {
         Country existCountry = countryService.findByName(country.getName());
         if (Objects.isNull(existCountry)) {
         Currency existCurrency = currencyService.findByIso(country.getCurrency().getIso());
         if (Objects.nonNull(existCurrency)) {
         country.setCurrency(existCurrency);
         } else {
         currencyService.save(country.getCurrency());
         }
         country.getCurrency().addCountry(country);
         countryService.save(country);
         }
         }
         **/
    }

}
