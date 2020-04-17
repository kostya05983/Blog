package components.aboutMePage

import MDReactComponent
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class AboutMePage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("about_me_page") {
            div("about_me_text_block") {
                MDReactComponent {
                    attrs.text = """
                        ## Привет
                        Меня зовут Константин Воливач и вы на моем блоге, он представляет собой не вверх дизайнерского искусства,
                        но я на нем буду писать статьи о spring, kotlin и платформе jvm в целом, посмотрим куда меня занесет.
                        
                        ## Немного фактов обо мне:
                        * Разрабатываю 2 год на jvm
                        
                        * Большинство этого опыта это kotlin опыт
                        
                        * Делаю тестовые для стажеров
                        
                        * Коммичу в spring иногда и стараюсь развивать opensource, все это вы можете увидеть на моем [github](https://github.com/kostya05983)
                    """.trimIndent()
                }
            }
        }
    }
}

fun RBuilder.aboutMePage() = child(AboutMePage::class) {

}