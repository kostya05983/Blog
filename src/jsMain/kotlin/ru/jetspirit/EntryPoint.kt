package ru.jetspirit

import react.dom.render
import kotlin.browser.*

fun main() {
    if (document.body != null) {
        console.log("Document body is not null")
        start()
    } else {
        console.log("Document body is null sss")
        document.addEventListener("DOMContentLoaded", { start() })
    }
}

fun start() {
    console.log("Getting ready to start app")
    if (document.getElementById("root") != null) {
        console.log("Application has root")
        val root = document.getElementById("root")
        render(root) {
            mainPage()
        }
    } else {
        console.log("Document does not has root, please edit index.html")
    }
}

