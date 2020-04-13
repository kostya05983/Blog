package components.mainPage

import ReactMarkdown
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import ru.jetspirit.components.header.Header
import kotlin.browser.window


class MainPage : RComponent<RProps, RState>() {
    private lateinit var test: String

//    override fun componentDidMount() {
//        super.componentDidMount()
//        val path = kotlinext.js.require("articles/kotlin/2019/jackson-serialization.md")
//        val test = window.fetch(path).then {
//            it.text()
//        }.then {
//            test = it
//        }
//    }

    override fun RBuilder.render() {
        div {
            child(Header::class) {
            }
//            ReactMarkdown {
//                attrs.source =
//                    "This block of Markdown contains "
//            }
        }
    }
}

fun RBuilder.mainPage() = child(MainPage::class) {}
