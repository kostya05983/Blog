package components.headerpart

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

/**
 * @author Konstantin Volivach
 */
class HeaderPart : RComponent<HeaderPartProps, RState>() {
    override fun RBuilder.render() {
        div("header_part") {
            +props.text
        }
    }
}

interface HeaderPartProps : RProps {
    var text: String
}