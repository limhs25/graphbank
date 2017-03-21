package com.bindstone.graphbank.utils.xml.parser;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.utils.xml.handler.CountryClassHandler;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryCurrencyParser {

    private static final String SOURCE = "https://www.currency-iso.org/dam/downloads/lists/list_one.xml";

    public Map<Country, Currency> parse() {
        try {
            URL url = new URL(SOURCE);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);

            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            CountryClassHandler handler = new CountryClassHandler();
            xmlReader.setContentHandler(handler);
            InputSource xml = new InputSource(url.openStream());
            xmlReader.parse(xml);
            return handler.getMap();
        } catch (Exception e) {
            System.out.println(e);
            return new HashMap<>();
        }
    }
}
