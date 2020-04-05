package ru.jetspirit.components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.styledDiv

/**
 * @author Konstantin Volivach
 */
class ListView : RComponent<ListViewProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            props.items.map { it.render() }
        }
    }
}

interface ListViewProps : RProps {
    var items: List<RComponent<*, *>>
}