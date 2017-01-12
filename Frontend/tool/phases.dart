library dartbank.tool.phases;

import 'package:Graphbank_Frontend/generators/json_serializable_generator.dart' as json;
import 'package:Graphbank_Frontend/generators/rest_crud_generator.dart' as rest;
import 'package:build/build.dart';
import 'package:source_gen/generators/json_literal_generator.dart' as literal;
import 'package:source_gen/source_gen.dart';


final PhaseGroup phases = new PhaseGroup.singleAction(
    new GeneratorBuilder(const [
      const json.JsonSerializableGenerator(),
      const rest.RestCrudGenerator(),
      const literal.JsonLiteralGenerator(),
    ]),
    new InputSet(
        'Graphbank_Frontend', const ['lib/**/*.dart', 'web/**/*.dart']));