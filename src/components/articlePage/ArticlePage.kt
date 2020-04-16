package components.articlePage

import MDReactComponent
import components.mainPage.MainPage
import react.*
import react.dom.div
import kotlin.browser.window

class ArticlePage : RComponent<ArticlePageProps, ArticlePageState>() {
    override fun componentDidMount() {
        val url = "https://raw.githubusercontent.com/kostya05983/Blog/master/articles/${props.id}"
        window.fetch(url).then {
            it.text()
        }.then {
            setState {
                text = it
            }
        }
    }

    override fun RBuilder.render() {
        div("article_page") {
            state.text?.let {
                MDReactComponent {
                    attrs.text = it
                }
            }
        }
    }
}

interface ArticlePageProps : RProps {
    var id: String
}

interface ArticlePageState : RState {
    var text: String?
}

fun RBuilder.articlePage(id: String) = child(ArticlePage::class) {
    attrs.id = id
}