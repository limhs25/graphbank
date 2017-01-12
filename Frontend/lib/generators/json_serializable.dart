library dartbank.generator.json_serial.annotation;

class JsonSerializable {
  final bool createFactory;
  final bool createToJson;

  const JsonSerializable({bool createFactory: true, bool createToJson: true})
      : this.createFactory = createFactory,
        this.createToJson = createToJson;
}

class JsonKey {
  final String jsonName;

  const JsonKey(this.jsonName);
}