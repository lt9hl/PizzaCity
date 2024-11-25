interface Drink{
    fun getDrink():Boolean{
        println("Вы будете кофе?\n1. Да\n2. Нет")
        if (readln() == "1") {
            println("С вас 200 рублей")
            return true
        }
        return false
    }
}