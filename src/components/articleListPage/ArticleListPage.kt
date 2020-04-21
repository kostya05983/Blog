package components.articleListPage

import components.listView.listView
import react.*
import react.dom.div
import kotlin.browser.window

class ArticleListPage : RComponent<RProps, RState>() {
    private val languagesMap = mapOf(
        "ru-RU" to "ru",
        "ru" to "ru",
        "en-US" to "en",
        "en" to "en"
    )

    override fun RBuilder.render() {
        val language = window.navigator.language
        console.log("Find language $language ${window.navigator.languages}")
        div {
            listView(
                items = arrayOf(
                    "&/kotlin/2019/jmh-in-kotlin.md",
                    "&/kotlin/2019/spring-test-data-generator.md",
                    "&/kotlin/2020/spring-data-indexes.28.03.2020.md",
                    "&/kotlin/2020/usefulness_of_deprecated.05.04.2020.md"
                ).map { it.replace("&", languagesMap[language] ?: "en") }.toTypedArray()
            )
        }
    }
}

fun RBuilder.articleListPage() = child(ArticleListPage::class) {}