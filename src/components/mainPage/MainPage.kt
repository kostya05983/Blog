package components.mainPage

import components.articleListPage.articleListPage
import components.articlePage.articlePage
import react.*
import react.dom.div
import react.router.dom.browserRouter
import components.header.Header
import react.router.dom.route

class MainPage : RComponent<RProps, MainPageState>() {
    override fun RBuilder.render() {
        browserRouter {
            div {
                child(Header::class) {
                }
                route("/") {
                    articleListPage()
                }
                route("/articles") {
                    articleListPage()
                }
                route<ArticleIdProps>("/articles/:id") { props ->
                    articlePage(props.match.params.id)
                }
            }
        }
    }
}

interface ArticleIdProps : RProps {
    var id: String
}

interface MainPageState : RState {
    var text: String?
}

fun RBuilder.mainPage() = child(MainPage::class) {}
