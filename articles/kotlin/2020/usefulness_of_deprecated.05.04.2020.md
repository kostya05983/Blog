### Ценность Deprecated в команде при деплое микросервисов

Недавно для себя открыл полезность использования deprecated между несколькими микросервисами, это помогает при
переключении клиентов на новые, не ломать старый подход.

Допустим у нас есть демон который на постоянке обращается к апи по методу контроллера
```kotlin
@PostMapping(
    value=["/action1"]
)
suspend fun addSomeEntity() {
...
}
```
но по каким-то причинам мы решили перемеименновать action1 в action2.

Можем один пометить @Deprecated и продублировать второй
```kotlin
@PostMapping(
    value=["/action2"]
)
suspend fun addSomeEntity2() {
...
}
``` 

Далее раскатить апи и при раскатке демонов, пока новые реплики демонов будут накатываться, старый смогут ходить по старому методу, а новые сразу начнут ходить на новый.

#### Способ проще без deprecated

В spring можно прописать несколько значений для роута

```kotlin
@PostMapping(
    value=["/action1","/action2"]
)
suspend fun addSomeEntity() {

}
```
это нас еще и избавит от дублирования кода.

#### Итого
* Deprecated можно заиспользовать для плавного обновления api в микросервисном взаимодействии