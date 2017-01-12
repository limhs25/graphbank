// Copyright (c) 2016, qs. All rights reserved. Use of this source code

// is governed by a BSD-style license that can be found in the LICENSE file.

import 'package:angular2/core.dart';
import 'package:angular2/platform/browser.dart';
import 'package:http/browser_client.dart';

import 'app/app.dart';

@Injectable()
BrowserClient newBrowserClient() => new BrowserClient();

void main() {
  bootstrap(AppComponent,
      [const Provider(BrowserClient, useFactory: newBrowserClient)]);
}
