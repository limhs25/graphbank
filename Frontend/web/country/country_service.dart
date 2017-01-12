library dartbank.web.service.country;

import 'dart:async';
import 'dart:convert';

import 'package:Graphbank_Frontend/entity/country_entity.dart';
import 'package:Graphbank_Frontend/generators/rest_crud.dart';
import 'package:angular2/core.dart';
import 'package:http/browser_client.dart';
import 'package:http/http.dart';

part 'country_service.g.dart';

@Injectable()
@RestCrud()
class CountryService extends _$CountryService_rest_crud {
  static const countryUrl = 'http://localhost:8181/country/';
  final BrowserClient _http;

  CountryService(this._http);

  @override
  BrowserClient getBrowserClient() {
    return _http;
  }

  String getUrl() {
    return countryUrl;
  }

}
