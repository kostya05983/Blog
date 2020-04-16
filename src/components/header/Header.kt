package components.header

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import components.headerpart.HeaderPart
import react.router.dom.routeLink

/**
 * @author Konstantin Volivach
 */
class Header : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("header") {
            routeLink("/about", className = "header") {
                child(HeaderPart::class) {
                    attrs.text = "About me"
                }
            }
            routeLink("/articles", className = "header") {
                child(HeaderPart::class) {
                    attrs.text = "Articles"

                }
            }
            routeLink("/contacts", className = "header") {
                child(HeaderPart::class) {
                    attrs.text = "Contacts"
                }
            }
        }
    }
}