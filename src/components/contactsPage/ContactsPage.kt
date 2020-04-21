package components.contactsPage

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.p
import kotlin.browser.window

class ContactsPage : RComponent<RProps, RState>() {
    private val contactsMap = mapOf(
        "ru-RU" to "Вы можете связаться со мной по почте kostya05983@mail.ru",
        "ru" to "Вы можете связаться со мной по почте kostya05983@mail.ru",
        "en-US" to "You can contact me by email kostya05983@mail.ru",
        "en" to "You can contact me by email kostya05983@mail.ru"
    )

    override fun RBuilder.render() {
        div("contacts_page") {
            div("contacts_text") {
                p {
                    val text =
                        contactsMap[window.navigator.language] ?: "You can contact me by email kostya05983@mail.ru"
                    +text
                }
            }
        }
    }
}

fun RBuilder.contactsPage() = child(ContactsPage::class) {}