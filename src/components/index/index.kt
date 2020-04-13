package components.index

import kotlinext.js.requireAll
import react.dom.render
import kotlin.browser.*
import kotlinext.js.*
import components.mainPage.mainPage

fun main(args: Array<String>) {
    requireAll(require.context("src", true, js("/\\.css$/")))

    render(document.getElementById("root")) {
        mainPage()
    }
}