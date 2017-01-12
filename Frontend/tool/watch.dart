library dartbank.tool.watch;

import 'package:build/build.dart';

import 'phases.dart';

main() {
  watch(phases, deleteFilesByDefault: true);
}