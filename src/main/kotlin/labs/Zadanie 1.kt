enum class Vremya(val value: Int) {
    min(60),
    hour(60 * 60),
    day(60 * 60 * 24)
}
fun main() {
    println("Сколько времени назад?: ")
    val x = readLine()!!.toInt()
    agoToText(x)
}
fun agoToText(time: Int) {
    when (time) {
        in 0..Vremya.min.value ->
        println("Был(а) только что")
        in (Vremya.min.value + 1)..(Vremya.hour.value) -> {
        val tempTime = time / Vremya.min.value
        println("Был(а) в сети ${texttime(time / 60)} назад")
        }
        in (Vremya.hour.value + 1)..(Vremya.day.value) -> {
        val tempTime = time / Vremya.hour.value
        println("Был(а) в сети ${texttime1(time / (60 * 60))} назад")
        }
        in (Vremya.day.value + 1)..(Vremya.day.value * 2) ->
        println("Был(а) в сети вчера")
        in (Vremya.day.value * 2 + 1)..(Vremya.day.value * 3) ->
        println("Был(а) в сети позавчера")
        in (Vremya.day.value * 3 + 1)..Int.MAX_VALUE ->
        println("Был(а) в сети давно")
    }
}

fun texttime(min: Int): String {
        return when {
            min % 10 == 1 && min != 11 -> "$min минуту"
            min % 10 in 2..4 && (min < 10 || min > 20) -> "$min минуты"
            else -> "$min минут"
        }
    }
fun texttime1(hour: Int): String {
    return when {
        hour % 10 == 1 && hour != 11 -> "$hour час"
        hour % 10 in 2..4 && (hour < 10 || hour > 20) -> "$hour часа"
        else -> "$hour часов"
    }
}


