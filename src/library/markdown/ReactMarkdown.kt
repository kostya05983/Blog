@file:JsModule("react-markdown")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("default")
external val ReactMarkdown: RClass<ReactMarkdownProps>

external interface ReactMarkdownProps : RProps {
    var source: String
}