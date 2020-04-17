package components.contactsPage

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.p

class ContactsPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("contacts_page") {
            div("contacts_text") {
                p {
                    +"Вы можете связаться со мной по почте kostya05983@mail.ru"
                }
            }
        }
    }
}

fun RBuilder.contactsPage() = child(ContactsPage::class) {}