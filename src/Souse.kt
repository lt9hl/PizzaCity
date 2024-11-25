interface Souse {
    fun ChooseSouce():Int{
        println("Выберите соус:\n1. Мед\n2. Горчичный\n0. Без соуса")
        while (true) {
            when (readln()) {
                "1" -> return 0
                "2" -> return 1
                "0" -> return 2
                else -> {
                    print("Ошибка. Повторите ввод")
                }
            }
        }
    }
}