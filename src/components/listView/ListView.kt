package components.listView

import components.articleBlock.articleBlock
import react.*
import react.dom.div

/**
 * @author Konstantin Volivach
 */
class ListView : RComponent<ListViewProps, RState>() {
    override fun RBuilder.render() {
        div("list_view") {
            props.items.map {
                articleBlock(it)
            }
        }
    }
}

interface ListViewProps : RProps {
    var items: Array<String>
}

fun RBuilder.listView(items: Array<String>) = child(ListView::class) {
    attrs.items = items
}