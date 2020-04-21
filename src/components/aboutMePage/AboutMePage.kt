package components.aboutMePage

import MDReactComponent
import react.*
import react.dom.div
import kotlin.browser.window

class AboutMePage : RComponent<RProps, AboutMeState>() {
    private val languagesMap = mapOf(
        "ru-RU" to "ru",
        "ru" to "ru",
        "en-US" to "en",
        "en" to "en"
    )

    override fun componentDidMount() {
        val url =
            "https://raw.githubusercontent.com/kostya05983/Blog/master/articles/${languagesMap[window.navigator.language] ?: "en"}/AboutMe.md"
        window.fetch(url).then {
            it.text()
        }.then {
            setState {

            }
        }
    }

    override fun RBuilder.render() {
        div("about_me_page") {
            state.article?.let {
                div("about_me_text_block") {
                    MDReactComponent {
                        attrs.text = it.trimIndent()
                    }
                }
            }
        }
    }
}

fun RBuilder.aboutMePage() = child(AboutMePage::class) {}

interface AboutMeState : RState {
    var article: String?
}