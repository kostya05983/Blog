package ru.jetspirit.components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.styledTextArea

class MainPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        styledTextArea {
            +"? ddddnew test? testing"
        }
    }
}