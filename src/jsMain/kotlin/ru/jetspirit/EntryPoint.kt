package ru.jetspirit

import react.dom.render
import kotlin.browser.*

fun main() {
    window.onload = {
        val root = document.getElementById("root") ?: throw IllegalStateException()
        render(root) {
            mainPage()
        }
    }
}                