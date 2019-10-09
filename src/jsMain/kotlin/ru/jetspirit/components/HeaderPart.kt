package ru.jetspirit.components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.styledDiv

/**
 * @author Konstantin Volivach
 */
class HeaderPart : RComponent<HeaderPartProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            +props.text
        }
    }
}

interface HeaderPartProps : RProps {
    var text: String
}