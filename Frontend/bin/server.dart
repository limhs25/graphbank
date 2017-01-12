import 'dart:async';
import 'dart:io';

import 'package:http_server/http_server.dart';
import 'package:logging/logging.dart';

final String _buildPath = Platform.script.resolve('../build/web/').toFilePath();
final VirtualDirectory _clientDir = new VirtualDirectory(_buildPath);

final Logger log = new Logger('server.dart');

Future main() async {
  // Add a bit of logging...
  Logger.root
    ..level = Level.INFO
    ..onRecord.listen(print);

  HttpServer server = await HttpServer.bind(InternetAddress.ANY_IP_V4, 8080);
  server.listen(requestHandler);
  print('Server listening on http://${server.address.host}:'
      '${server.port}');
}

Future requestHandler(HttpRequest request) async {
  log.info("Request for [" + request.uri.path + "]");
  if (request.uri.path == '/') {
    // loading the client application.
    request.response.redirect(Uri.parse('index.html'));
  } else {
    var fileUri =
    new Uri.file(_buildPath).resolve(request.uri.path.substring(1));
    _clientDir.serveFile(new File(fileUri.toFilePath()), request);
  }
}
