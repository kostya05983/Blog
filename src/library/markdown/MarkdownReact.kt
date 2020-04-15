@file:JsModule("markdown-react-js")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("default")
external val MDReactComponent: RClass<MDReactComponentProps>

external interface MDReactComponentProps : RProps {
    var text: String
}