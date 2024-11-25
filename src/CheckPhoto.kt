interface CheckPhoto {

    fun showCheckPhoto():Boolean {
        println("У вас есть фото чека?\n1. Да\n2. Нет")
        if (readln() == "1") {
            println("Вам предоставлена скидка 50 рублей")
            return true
        }
        return false
    }
}