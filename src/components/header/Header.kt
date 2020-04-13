package ru.jetspirit.components.header

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import components.headerpart.HeaderPart

/**
 * @author Konstantin Volivach
 */
class Header : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("header") {
            child(HeaderPart::class) {
                attrs.text = "About me"
            }
            child(HeaderPart::class) {
                attrs.text = "Articles"
            }
            child(HeaderPart::class) {
                attrs.text = "Contacts"
            }
        }
    }
}