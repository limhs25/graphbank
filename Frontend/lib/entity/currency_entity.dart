library dartbank.entity.country;

import 'package:Graphbank_Frontend/generators/json_serializable.dart';

part 'currency_entity.g.dart';

@JsonSerializable()
class Currency extends Object
    with _$CurrencySerializerMixin {
  int nodeId;
  String id;
  String name;
  DateTime created;
  DateTime modified;

  Currency() {}

  factory Currency.fromJson(json) => _$CurrencyFromJson(json);
}
