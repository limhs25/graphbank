// Copyright (c) 2016, bindstone.com. All rights reserved. Use of this source code

// is governed by a BSD-style license that can be found in the LICENSE file.

import 'package:angular2/core.dart';
import 'package:angular2/router.dart';
import 'package:angular2_components/angular2_components.dart';

import '../country/country.dart';
import '../country/country_list.dart';

@Component(
    selector: 'bank-app',
    styleUrls: const ['app.css'],
    templateUrl: 'app.html',
    directives: const [materialDirectives, ROUTER_DIRECTIVES],
    providers: const [materialProviders, ROUTER_PROVIDERS])
@RouteConfig(const [
  const Route(
      path: '/country',
      name: 'Country',
      component: CountryView,
      useAsDefault: true),
  const Route(path: '/countries', name: 'Countries', component: CountryListView)
])
class AppComponent {
  String title = 'Graph-Bank';
}
