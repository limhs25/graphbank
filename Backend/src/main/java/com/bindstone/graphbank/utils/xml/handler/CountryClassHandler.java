package com.bindstone.graphbank.utils.xml.handler;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.domain.Currency;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class CountryClassHandler extends DefaultHandler {

    private Country country;
    private Currency currency;
    private String value;
    private Map<Country, Currency> map;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing...");
        map = new HashMap<>();
    }

    @Override
    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts)
            throws SAXException {
        switch (localName) {
            case "CcyNtry":
                country = new Country();
                currency = new Currency();
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        switch (localName) {
            case "CcyNtry":
                writeObjects();
                break;
            case "CtryNm":
                country.setName(value);
                break;
            case "CcyNm":
                currency.setName(value);
                break;
            case "Ccy":
                currency.setIso(value);
                break;
            case "CcyNbr":
                currency.setCode(value);
                break;
            case "CcyMnrUnts":
                if (StringUtils.isNumeric(value)) {
                    currency.setUnit(Integer.valueOf(value));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing.");
    }

    private void writeObjects() {
        map.put(country, currency);
    }

    public Map<Country, Currency> getMap() {
        return map;
    }
}
