package components.articlePage

import MDReactComponent
import components.mainPage.MainPage
import react.*
import react.dom.div
import kotlin.browser.window

class ArticlePage : RComponent<ArticlePageProps, ArticlePageState>() {
    override fun componentDidMount() {
        window.fetch(props.url).then {
            it.text()
        }.then {
            setState {
                text = it
            }
        }
    }

    override fun RBuilder.render() {
        div {
            state.text?.let {
                MDReactComponent {
                    attrs.text = it
                }
            }
        }
    }
}

interface ArticlePageProps : RProps {
    var url: String
}

interface ArticlePageState : RState {
    var text: String?
}

fun RBuilder.articlePage(url: String) = child(MainPage::class, props = object : ArticlePageProps {
    override var url: String
        get() = url
        set(value) {}
}) {}