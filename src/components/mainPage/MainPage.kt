package components.mainPage

import components.aboutMePage.aboutMePage
import components.articleListPage.articleListPage
import components.articlePage.articlePage
import components.contactsPage.contactsPage
import react.*
import react.dom.div
import react.router.dom.browserRouter
import components.header.Header
import react.router.dom.route
import react.router.dom.switch

class MainPage : RComponent<RProps, MainPageState>() {
    override fun RBuilder.render() {
        browserRouter {
            div {
                child(Header::class) {
                }
                switch {
                    route("/Blog/", exact = true) {
                        articleListPage()
                    }
                    route("/Blog/about", exact = true) {
                        aboutMePage()
                    }
                    route("/Blog/contacts", exact = true) {
                        contactsPage()
                    }
                    route("/Blog/articles", exact = true) {
                        articleListPage()
                    }
                    route<ArticleIdProps>("/Blog/articles/:id", exact = true) { props ->
                        println("Matched ${props.match.params.id}")
                        props.match.params.id.replace("\\", "/")
                        articlePage(props.match.params.id)
                    }
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
