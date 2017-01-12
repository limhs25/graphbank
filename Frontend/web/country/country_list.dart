import 'package:Graphbank_Frontend/entity/country_entity.dart';
import 'package:angular2/core.dart';

import 'country_service.dart';

@Component(
    selector: 'country-list',
    styleUrls: const ['country.css'],
    providers: const [CountryService],
    templateUrl: 'country_list.html')
class CountryListView {
  CountryService service;
  List<Country> countries = [];
  String test = 'Hello';

  CountryListView(CountryService countryService) {
    service = countryService;
    getCountries();
  }

  deleteCountry(String id) {
    print("Delete countries:" + id);
    service.delete(id).whenComplete(getCountries);
  }

  getCountry(String id) {
    print("Get country...");
    service.findById(id);
  }

  getCountries() {
    print("Get countries...");
    service.getAll().then((data) => this.countries = data);
  }
}
