package components.articleListPage

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class ArticleListPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {

    }
}

fun RBuilder.articleListPage() = child(ArticleListPage::class) {}