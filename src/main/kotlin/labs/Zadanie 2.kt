val sumMonth = 0 // сумма за месяц
val sum = 80000 // сумма за раз

fun main() {
    println("Введите карту: ")
    val typeCard = readLine()
    println(commission(typeCard))
}

fun commission(typeCard: String?) = when {
    sum > 150000 && (typeCard == "Visa" || typeCard == "Мир") -> "Превышен лимит!"
    sum > 600000 && (typeCard == "Maestro" || typeCard == "MasterCard") -> "Превышен лимит!"
    sum > 40000 && sum > 15000 && typeCard == "VK Pay" -> "Превышен лимит!"
    (typeCard == "Maestro" || typeCard == "MasterCard") && sumMonth < 75000 -> "Сумма: $sum"
    (typeCard == "Maestro" || typeCard == "MasterCard") && sum > 75000 -> {
        val commissionMM = (0.6 / 100) * sum
        "Сумма: ${sum + commissionMM + 20}"
    }
    (typeCard == "Visa" || typeCard == "Мир") -> {
        val commissionVM = (0.75 / 100) * sum
        if (commissionVM < 35) {
            "Сумма: ${sum + 35}"
        } else {
            "Сумма: ${sum + commissionVM}"
        }
    }
    typeCard == "VK Pay" -> "Сумма: $sum"
    else -> "-"
}
