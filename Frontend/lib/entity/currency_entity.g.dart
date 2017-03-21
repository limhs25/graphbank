// GENERATED CODE - DO NOT MODIFY BY HAND

part of dartbank.entity.country;

// **************************************************************************
// Generator: JsonSerializableGenerator
// Target: class Currency
// **************************************************************************

Currency _$CurrencyFromJson(Map json) =>
    new Currency()
      ..nodeId = json['nodeId'] as int
      ..id = json['id'] as String
      ..name = json['name'] as String
      ..created = json['created'] == null
          ? null
          : new DateTime.fromMillisecondsSinceEpoch(json['created'])
      ..modified = json['modified'] == null
          ? null
          : new DateTime.fromMillisecondsSinceEpoch(json['modified']);

abstract class _$CurrencySerializerMixin {
  int get nodeId;

  String get id;

  String get name;

  DateTime get created;

  DateTime get modified;

  Map<String, dynamic> toJson() =>
      <String, dynamic>{
        'nodeId': nodeId,
        'id': id,
        'name': name,
        'created': created?.millisecondsSinceEpoch,
        'modified': modified?.millisecondsSinceEpoch
      };
}
