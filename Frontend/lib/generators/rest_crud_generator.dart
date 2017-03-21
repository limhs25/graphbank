library dartbank.generator.json_serial.generator;

import 'dart:async';

import 'package:Graphbank_Frontend/generators/rest_crud.dart';
import 'package:analyzer/dart/element/element.dart';
import 'package:build/build.dart';
import 'package:source_gen/source_gen.dart';

class RestCrudGenerator extends GeneratorForAnnotation<RestCrud> {
  const RestCrudGenerator();

  @override
  Future<String> generateForAnnotatedElement(Element element,
      RestCrud annotation, BuildStep buildStep) async {
    var entity = annotation.entityClass;
    var classElement = element as ClassElement;
    var className = classElement.name;

    var buffer = new StringBuffer();

    buffer.writeln('abstract class _\$${className}_rest_crud {');
    buffer.writeln('//');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// * OVERRIDE THE FOLLOWING METHODES');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('BrowserClient getBrowserClient();');
    buffer.writeln('String getUrl();');
    buffer.writeln('');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// * Get ALL');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('Future<List<${className}>> getAll() async {');
    buffer.writeln('  try {');
    buffer.writeln('    print("${className}:FindAll");');
    buffer.writeln(
        '    final response = await getBrowserClient().get(getUrl());');
    buffer.writeln('    final retval = extractDataList(response);');
    buffer.writeln('    return retval;');
    buffer.writeln('  } catch (e) {');
    buffer.writeln('    throw handleError(e);');
    buffer.writeln('  }');
    buffer.writeln('}');
    buffer.writeln('');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// * Find BY ID');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('Future<${className}> findById(String id) async {');
    buffer.writeln('  try {');
    buffer.writeln('    print("${className}:FindById \$id");');
    buffer.writeln(
        '    final response = await getBrowserClient().get(getUrl() + id);');
    buffer.writeln('    final retval = extractData(response);');
    buffer.writeln('    return retval;');
    buffer.writeln('  } catch (e) {');
    buffer.writeln('    throw handleError(e);');
    buffer.writeln('  }');
    buffer.writeln('}');
    buffer.writeln('');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// * Save Object');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('Future<${entity}> save(${entity} ${entity
        .toLowerCase()}) async {');
    buffer.writeln('  try {');
    buffer.writeln(
        '    print("${className}:Save ${entity.toLowerCase()}");');
    buffer.writeln(
        '    String jsonData = JSON.encode(${entity.toLowerCase()});');
    buffer.writeln('    Map<String, String> header = new Map();');
    buffer.writeln('    final response = await getBrowserClient().put(');
    buffer.writeln('        getUrl(),');
    buffer.writeln(
        '        headers: {\'Content-type\': \'application/json\'},');
    buffer.writeln('        body: jsonData);');
    buffer.writeln('    final retval = extractData(response);');
    buffer.writeln('    return retval;');
    buffer.writeln('  } catch (e) {');
    buffer.writeln('    throw handleError(e);');
    buffer.writeln('  }');
    buffer.writeln('}');
    buffer.writeln('');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// * Delete BY ID');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('Future delete(String id) async {');
    buffer.writeln('  try {');
    buffer.writeln('    print("${className}:Delete \$id");');
    buffer.writeln(
        '    final response = await getBrowserClient().delete(getUrl() + id);');
    buffer.writeln('  } catch (e) {');
    buffer.writeln('    throw handleError(e);');
    buffer.writeln('  }');
    buffer.writeln('}');
    buffer.writeln('');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// * Extract List');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('dynamic extractDataList(Response res) {');
    buffer.writeln('  List body = JSON.decode(res.body);');
    buffer.writeln('');
    buffer.writeln('  body.forEach((value) => print(value));');
    buffer.writeln('  List<${className}> ${className.toLowerCase()}s =');
    buffer.writeln('  body.map((value) => new ${entity}.fromJson(value))');
    buffer.writeln('      .toList();');
    buffer.writeln('');
    buffer.writeln('  return ${className.toLowerCase()}s;');
    buffer.writeln('}');
    buffer.writeln('');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// * Extract Object');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('${className} extractData(Response res) {');
    buffer.writeln('  ${className} body = JSON.decode(res.body);');
    buffer.writeln('  return body;');
    buffer.writeln('}');
    buffer.writeln('');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('// EXCEPTION Handlers:');
    buffer.writeln(
        '// ***********************************************************************');
    buffer.writeln('');
    buffer.writeln('Exception handleError(dynamic e) {');
    buffer.writeln('  print("${className}:Exception \$e");');
    buffer.writeln('  return new Exception(\'${className}: \$e\');');
    buffer.writeln('} ');
    buffer.writeln('');
    buffer.writeln('}');
    return buffer.toString();
  }
}

bool _isConstType(value) {
  return value == null || value is String || value is num || value is bool;
}
