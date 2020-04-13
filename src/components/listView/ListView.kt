package components.listView

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

/**
 * @author Konstantin Volivach
 */
class ListView : RComponent<ListViewProps, RState>() {
    override fun RBuilder.render() {
        div {
            props.items.map { it.render() }
        }
    }
}

interface ListViewProps : RProps {
    var items: List<RComponent<*, *>>
}