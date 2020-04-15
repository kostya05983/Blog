package components.articleBlock

import org.w3c.dom.url.URL
import react.*
import react.dom.div
import react.dom.label
import kotlin.browser.window

class ArticleBlock : RComponent<ArticleBlockProps, ArticleBlockState>() {
    override fun componentDidMount() {
        window.fetch(props.url).then {
            it.text()
        }.then {
            setState {
                headText = it.substring(100)
            }

        }
    }

    override fun RBuilder.render() {
        div {
            state.headText?.let {
                label {
                    attrs.form = it
                }
            }
        }
    }
}

interface ArticleBlockProps : RProps {
    var url: URL
}

interface ArticleBlockState : RState {
    var headText: String?
}

fun RBuilder.articleBlock(url: URL) = child(ArticleBlock::class, props = object : ArticleBlockProps {
    override var url: URL
        get() = url
        set(value) {}
}) {}