package components.articleBlock

import react.*
import react.dom.div
import react.dom.label
import react.router.dom.routeLink
import kotlin.browser.window

class ArticleBlock : RComponent<ArticleBlockProps, ArticleBlockState>() {
    override fun componentDidMount() {
        val url = "https://raw.githubusercontent.com/kostya05983/Blog/master/articles${props.id}"
        window.fetch(url).then {
            it.text()
        }.then {
            setState {
                headText = it.substring(100)
            }
        }
    }

    override fun RBuilder.render() {
        routeLink("/articles/${props.id}") {
            div {
                state.headText?.let {
                    label {
                        attrs.form = it
                    }
                }
            }
        }
    }
}

interface ArticleBlockProps : RProps {
    var id: String
}

interface ArticleBlockState : RState {
    var headText: String?
}

fun RBuilder.articleBlock(url: String) = child(ArticleBlock::class, props = object : ArticleBlockProps {
    override var id: String
        get() = url
        set(value) {}
}) {}