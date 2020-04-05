package ru.jetspirit

import kotlinext.js.requireAll
import react.dom.render
import kotlin.browser.*
import kotlinext.js.*

fun main() {
    requireAll(require.context("src", true, js("/\\.css$/")))

    render(document.getElementById("root")) {
        mainPage()
    }
}