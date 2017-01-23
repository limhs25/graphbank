import 'package:Graphbank_Frontend/entity/country_entity.dart';
import 'package:angular2/core.dart';
import 'package:angular2_components/angular2_components.dart';

import 'country_service.dart';

@Component(
    selector: 'country',
    styleUrls: const ['country.css'],
    providers: const [materialProviders, CountryService],
    directives: const [materialDirectives],
    templateUrl: 'country.html')
class CountryView {
  CountryService service;


  String countryName;

  CountryView(CountryService countryService) {
    service = countryService;
  }

  addCountry() {
    print("Add countries...");
    Country country = new Country();
    country.name = countryName;
    service.save(country);
  }

}
