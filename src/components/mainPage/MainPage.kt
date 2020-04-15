package components.mainPage

import MDReactComponent
import react.*
import react.dom.div
import ru.jetspirit.components.header.Header
import kotlin.browser.window

class MainPage : RComponent<RProps, MainPageState>() {

    override fun componentDidMount() {
        window.fetch("https://raw.githubusercontent.com/kostya05983/Blog/master/articles/kotlin/2019/spring-test-data-generator.md")
            .then {
                it.text()
            }.then {
                setState {
                    text = it
                }
                console.log("End with loading of text")
            }
    }

    override fun RBuilder.render() {
        div {
            child(Header::class) {
            }
            state.text?.let {
                MDReactComponent {
                    attrs.text = it
                }
            }
        }
    }
}

interface MainPageState : RState {
    var text: String?
}

fun RBuilder.mainPage() = child(MainPage::class) {}
