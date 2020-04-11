package ru.jetspirit.components.header

import kotlinx.css.Display
import kotlinx.css.JustifyContent
import kotlinx.css.display
import kotlinx.css.justifyContent
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import ru.jetspirit.components.headerpart.HeaderPart
import styled.css
import styled.styledDiv

/**
 * @author Konstantin Volivach
 */
class Header : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                display = Display.flex
                justifyContent = JustifyContent.spaceBetween
            }
            child(HeaderPart::class) {
                attrs.text = "Статьи"
            }
            child(HeaderPart::class) {
                attrs.text = "О себе"
            }
        }
    }
}