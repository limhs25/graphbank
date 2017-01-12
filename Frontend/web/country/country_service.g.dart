// GENERATED CODE - DO NOT MODIFY BY HAND

part of dartbank.web.service.country;

// **************************************************************************
// Generator: RestCrudGenerator
// Target: class CountryService
// **************************************************************************

abstract class _$CountryService_rest_crud {
//
// **************************************************************************
// * OVERRIDE THE FOLLOWING METHODES
// **************************************************************************

  BrowserClient getBrowserClient();
  String getUrl();

// **************************************************************************
// * Get ALL
// **************************************************************************

  Future<List<Country>> getAll() async {
    try {
      print("CountryService:FindAll");
      final response = await getBrowserClient().get(getUrl());
      final retval = extractDataList(response);
      return retval;
    } catch (e) {
      throw handleError(e);
    }
  }

// **************************************************************************
// * Find BY ID
// **************************************************************************

  Future<Country> findById(String id) async {
    try {
      print("CountryService:FindById $id");
      final response = await getBrowserClient().get(getUrl() + id);
      final retval = extractData(response);
      return retval;
    } catch (e) {
      throw handleError(e);
    }
  }

// **************************************************************************
// * Save Object
// **************************************************************************

  Future<Country> save(Country country) async {
    try {
      print("CountryService:Save $country");
      String jsonData = JSON.encode(country);
      Map<String, String> header = new Map();
      final response = await getBrowserClient().put(getUrl(),
          headers: {'Content-type': 'application/json'}, body: jsonData);
      final retval = extractData(response);
      return retval;
    } catch (e) {
      throw handleError(e);
    }
  }

// **************************************************************************
// * Delete BY ID
// **************************************************************************

  Future delete(String id) async {
    try {
      print("CountryService:Delete $id");
      final response = await getBrowserClient().delete(getUrl() + id);
    } catch (e) {
      throw handleError(e);
    }
  }

// **************************************************************************
// * Extract List
// **************************************************************************

  dynamic extractDataList(Response res) {
    List body = JSON.decode(res.body);

    body.forEach((value) => print(value));
    List<Country> countries =
    body.map((value) => new Country.fromJson(value)).toList();

    return countries;
  }

// **************************************************************************
// * Extract Object
// **************************************************************************

  Country extractData(Response res) {
    Country body = JSON.decode(res.body);
    return body;
  }

// **************************************************************************
// EXCEPTION Handlers:
// **************************************************************************

  Exception handleError(dynamic e) {
    print("CountryService:Exception $e");
    return new Exception('CountryService: $e');
  }
}
