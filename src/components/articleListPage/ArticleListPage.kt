package components.articleListPage

import components.listView.listView
import react.*
import react.dom.div

class ArticleListPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            listView(
                items = arrayOf(
                    "kotlin/2019/jackson-serialization.md",
                    "kotlin/2019/jmh-in-kotlin.md",
                    "kotlin/2019/spring-test-data-generator.md",
                    "kotlin/2020/spring-data-indexes.28.03.2020.md",
                    "kotlin/2020/usefulness_of_deprecated.05.04.2020.md"
                )
            )
        }
    }
}

fun RBuilder.articleListPage() = child(ArticleListPage::class) {}