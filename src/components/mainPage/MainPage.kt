package components.mainPage

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import ru.jetspirit.components.header.Header

class MainPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            child(Header::class) {
            }
        }
    }
}
fun RBuilder.mainPage() = child(MainPage::class) {}
