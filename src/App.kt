fun main() {
    println("Конвертер валют — актуально на 16.11.2025")
    println("Поддержка: USD — доллар, RUB — рубль, EUR — евро, GBP — британский фунт, JPY — японская иена, CNY — китайский юань, CHF — швейцарский франк, CAD — канадский доллар, AUD — австралийский доллар, INR — индийская рупия , TRY  — турецкая лира")
    println()

    val usdToRub = 93.2
    val eurToUsd = 0.94
    val gbpToUsd = 0.79
    val jpyToUsd = 148.5
    val cnyToUsd = 7.26
    val chfToUsd = 0.88
    val cadToUsd = 1.38
    val audToUsd = 1.53
    val inrToUsd = 83.5
    val tryToUsd = 33.2

    while (true) {
        print("Введите сумму (0 — выход): ")
        val amount = readLine()?.toDoubleOrNull() ?: 0.0
        if (amount == 0.0) break

        print("Из (usd/eur/rub/jpy...): ")
        val from = readLine()?.lowercase() ?: ""
        print("В (usd/eur/rub/jpy...): ")
        val to = readLine()?.lowercase() ?: ""

        // Шаг 1: переводим всё в USD
        var inUsd = 0.0
        if (from == "usd") inUsd = amount
        else if (from == "rub") inUsd = amount / usdToRub
        else if (from == "eur") inUsd = amount * eurToUsd
        else if (from == "gbp") inUsd = amount * gbpToUsd
        else if (from == "jpy") inUsd = amount / jpyToUsd
        else if (from == "cny") inUsd = amount / cnyToUsd
        else if (from == "chf") inUsd = amount * chfToUsd
        else if (from == "cad") inUsd = amount / cadToUsd
        else if (from == "aud") inUsd = amount / audToUsd
        else if (from == "inr") inUsd = amount / inrToUsd
        else if (from == "try") inUsd = amount / tryToUsd
        else {
            println("Не знаю такой валюты :( | Попробуйте: usd, eur, rub...")
            continue
        }

        var result = 0.0
        if (to == "usd") result = inUsd
        else if (to == "rub") result = inUsd * usdToRub
        else if (to == "eur") result = inUsd / eurToUsd
        else if (to == "gbp") result = inUsd / gbpToUsd
        else if (to == "jpy") result = inUsd * jpyToUsd
        else if (to == "cny") result = inUsd * cnyToUsd
        else if (to == "chf") result = inUsd / chfToUsd
        else if (to == "cad") result = inUsd * cadToUsd
        else if (to == "aud") result = inUsd * audToUsd
        else if (to == "inr") result = inUsd * inrToUsd
        else if (to == "try") result = inUsd * tryToUsd
        else {
            println("Не знаю такой валюты :( | Попробуйте: usd, eur, rub...")
            continue
        }

        val formatted = if (to in listOf("jpy", "inr", "try")) {
            "${result.toInt()}"
        } else {
            "%.2f".format(result)
        }

        println("$amount $from = $formatted $to")
        println()
    }

    println("Курсы от 16.11.2025")
}
