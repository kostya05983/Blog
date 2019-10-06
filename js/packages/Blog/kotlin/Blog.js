(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'kotlin-react-dom', 'kotlin-styled', 'kotlin-react'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('kotlin-react-dom'), require('kotlin-styled'), require('kotlin-react'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'Blog'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Blog'.");
    }
    if (typeof this['kotlin-react-dom'] === 'undefined') {
      throw new Error("Error loading module 'Blog'. Its dependency 'kotlin-react-dom' was not found. Please, check whether 'kotlin-react-dom' is loaded prior to 'Blog'.");
    }
    if (typeof this['kotlin-styled'] === 'undefined') {
      throw new Error("Error loading module 'Blog'. Its dependency 'kotlin-styled' was not found. Please, check whether 'kotlin-styled' is loaded prior to 'Blog'.");
    }
    if (typeof this['kotlin-react'] === 'undefined') {
      throw new Error("Error loading module 'Blog'. Its dependency 'kotlin-react' was not found. Please, check whether 'kotlin-react' is loaded prior to 'Blog'.");
    }
    root.Blog = factory(typeof Blog === 'undefined' ? {} : Blog, kotlin, this['kotlin-react-dom'], this['kotlin-styled'], this['kotlin-react']);
  }
}(this, function (_, Kotlin, $module$kotlin_react_dom, $module$kotlin_styled, $module$kotlin_react) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var getKClass = Kotlin.getKClass;
  var Unit = Kotlin.kotlin.Unit;
  var IllegalStateException_init = Kotlin.kotlin.IllegalStateException_init;
  var render = $module$kotlin_react_dom.react.dom.render_2955dm$;
  var RComponent_init = $module$kotlin_react.react.RComponent_init_lqgejo$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var RComponent = $module$kotlin_react.react.RComponent;
  var html = $module$kotlin_styled.$$importsForInline$$['kotlinx-html-js'].kotlinx.html;
  var DIV_init = $module$kotlin_styled.$$importsForInline$$['kotlinx-html-js'].kotlinx.html.DIV;
  var StyledDOMBuilder_init = $module$kotlin_styled.styled.StyledDOMBuilder;
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var collectionSizeOrDefault = Kotlin.kotlin.collections.collectionSizeOrDefault_ba2ldo$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_ww73n8$;
  var NotImplementedError_init = Kotlin.kotlin.NotImplementedError;
  Header.prototype = Object.create(RComponent.prototype);
  Header.prototype.constructor = Header;
  ListView.prototype = Object.create(RComponent.prototype);
  ListView.prototype.constructor = ListView;
  MainPage.prototype = Object.create(RComponent.prototype);
  MainPage.prototype.constructor = MainPage;
  function mainPage$lambda($receiver) {
    return Unit;
  }
  function mainPage($receiver) {
    return $receiver.child_bzgiuu$(getKClass(MainPage), mainPage$lambda);
  }
  function main$lambda$lambda($receiver) {
    mainPage($receiver);
    return Unit;
  }
  function main$lambda(it) {
    var tmp$;
    tmp$ = document.getElementById('root');
    if (tmp$ == null) {
      throw IllegalStateException_init();
    }
    var root = tmp$;
    render(root, void 0, main$lambda$lambda);
    return Unit;
  }
  function main() {
    window.onload = main$lambda;
  }
  function styledDiv$lambda(it) {
    return new DIV_init(html.emptyMap, it);
  }
  function Header() {
    RComponent_init(this);
  }
  Header.prototype.render_ss14n$ = function ($receiver) {
    var $receiver_0 = new StyledDOMBuilder_init(styledDiv$lambda);
    $receiver_0.css;
    $receiver.child_2usv9w$($receiver_0.create());
  };
  Header.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Header',
    interfaces: [RComponent]
  };
  function styledDiv$lambda_0(it) {
    return new DIV_init(html.emptyMap, it);
  }
  function ListView() {
    RComponent_init(this);
  }
  ListView.prototype.render_ss14n$ = function ($receiver) {
    var $receiver_0 = new StyledDOMBuilder_init(styledDiv$lambda_0);
    var $receiver_1 = this.props.items;
    var destination = ArrayList_init(collectionSizeOrDefault($receiver_1, 10));
    var tmp$;
    tmp$ = $receiver_1.iterator();
    while (tmp$.hasNext()) {
      var item = tmp$.next();
      destination.add_11rb$(item.render());
    }
    $receiver.child_2usv9w$($receiver_0.create());
  };
  ListView.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ListView',
    interfaces: [RComponent]
  };
  function ListViewProps() {
  }
  ListViewProps.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'ListViewProps',
    interfaces: []
  };
  function MainPage() {
    RComponent_init(this);
  }
  MainPage.prototype.render_ss14n$ = function ($receiver) {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'not implemented');
  };
  MainPage.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'MainPage',
    interfaces: [RComponent]
  };
  var package$ru = _.ru || (_.ru = {});
  var package$jetspirit = package$ru.jetspirit || (package$ru.jetspirit = {});
  package$jetspirit.mainPage_ss14n$ = mainPage;
  package$jetspirit.main = main;
  $$importsForInline$$['kotlin-styled'] = $module$kotlin_styled;
  var package$components = package$jetspirit.components || (package$jetspirit.components = {});
  package$components.Header = Header;
  package$components.ListView = ListView;
  package$components.ListViewProps = ListViewProps;
  package$components.MainPage = MainPage;
  main();
  Kotlin.defineModule('Blog', _);
  return _;
}));

//# sourceMappingURL=Blog.js.map
