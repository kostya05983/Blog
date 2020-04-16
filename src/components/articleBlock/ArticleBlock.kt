package components.articleBlock

import MDReactComponent
import react.*
import react.dom.div
import react.router.dom.routeLink
import kotlin.browser.window

class ArticleBlock : RComponent<ArticleBlockProps, ArticleBlockState>() {
    override fun componentDidMount() {
        println("id of block ${props.id}")
        val url = "https://raw.githubusercontent.com/kostya05983/Blog/master/articles${props.id}"
        window.fetch(url).then {
            it.text()
        }.then {
            setState {
                val currentText = it.substring(0, 300)
                var i = 0
                var index = 0
                for (j in 0 until it.length) {
                    if (i == 6) break
                    if (it[j] == '\n') i++
                    index = j
                }
                headText = if (index > currentText.length) {
                    currentText
                } else {
                    currentText.substring(0, index)
                }
            }
        }
    }

    override fun RBuilder.render() {
        routeLink("/articles/${props.id}", className = "article_link") {
            div("article_block") {
                state.headText?.let {
                    div("article_block_text") {
                        MDReactComponent {
                            attrs.text = state.headText ?: ""
                        }
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

fun RBuilder.articleBlock(id: String) = child(ArticleBlock::class) {
    attrs.id = id
}