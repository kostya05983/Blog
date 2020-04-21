package components.header

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import components.headerpart.HeaderPart
import react.router.dom.routeLink
import kotlin.browser.window

/**
 * @author Konstantin Volivach
 */
class Header : RComponent<RProps, RState>() {
    private val dictionaryMap = mapOf(
        HeaderKeys.ABOUT_ME to mapOf(
            "ru-RU" to "Обо мне",
            "ru" to "Обо мне",
            "en-US" to "About me",
            "en" to "About me"
        ),
        HeaderKeys.ARTICLES to mapOf(
            "ru-RU" to "Статьи",
            "ru" to "Статьи",
            "en-US" to "Articles",
            "en" to "Articles"
        ),
        HeaderKeys.CONTACTS to mapOf(
            "ru-RU" to "Контакты",
            "ru" to "Контакты",
            "en-US" to "Contacts",
            "en" to "Contacts"
        )
    )

    override fun RBuilder.render() {
        div("header") {
            routeLink("/Blog/about", className = "header") {
                child(HeaderPart::class) {
                    attrs.text = getHeader(HeaderKeys.ABOUT_ME)
                }
            }
            routeLink("/Blog/articles", className = "header") {
                child(HeaderPart::class) {
                    attrs.text = getHeader(HeaderKeys.ARTICLES)

                }
            }
            routeLink("/Blog/contacts", className = "header") {
                child(HeaderPart::class) {
                    attrs.text = getHeader(HeaderKeys.CONTACTS)
                }
            }
        }
    }

    private fun getHeader(headerKey: HeaderKeys): String {
        val language = window.navigator.language
        return dictionaryMap[headerKey]?.get(language)
            ?: throw IllegalArgumentException("Something went wrong while get string representation of header")
    }
}

enum class HeaderKeys {
    CONTACTS,
    ABOUT_ME,
    ARTICLES
}