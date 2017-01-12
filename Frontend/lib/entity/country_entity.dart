library dartbank.entity.country;

import 'package:Graphbank_Frontend/generators/json_serializable.dart';

part 'country_entity.g.dart';

@JsonSerializable()
class Country extends Object with _$CountrySerializerMixin {
  int nodeId;
  String id;
  String name;
  DateTime created;
  DateTime modified;

  Country() {}

  factory Country.fromJson(json) => _$CountryFromJson(json);
}
