import kotlin.system.exitProcess

fun main() {
    /*Сырная, Пепперони, Мясная, Ветчина и сыр, Карбонара*/
    var pizzaSPB = PizzaSPB(listOf(750, 1000, 799, 650, 320))
    var pizzaMSC = PizzaMoscow(listOf(1200, 1600, 999, 850, 530))
    var pizzaLyga  = PizzaLyga(listOf(600, 950, 899, 800, 500))
    var currentPizzaCity: Pizza
    while (true) {
        println("Добрый день! Выберите город.\n1. Москва\n2. Санкт-Петербург\n3. Луга\n4. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMSC
            "2" -> pizzaSPB
            "3" -> pizzaLyga
            "4" -> break
            else -> {
                println("Данные введены неверно!")
                continue
            }
        }
        println("Выберите пиццу:\n1. Сырная\n2. Пепперони\n3. Мясная\n4. Ветчина и сыр\n5. Карбонара\n0. Показать статистику")
        var outp = currentPizzaCity.salePizza(readln())
        if (outp == 1) {
            selectAddService(currentPizzaCity)
        }
    }
}

fun selectAddService(currentPizzaCity: Pizza) {
    if(currentPizzaCity is Drink && currentPizzaCity is CheckPhoto && currentPizzaCity is Souse){
        currentPizzaCity.getDrink()
        currentPizzaCity.showCheckPhoto()
        currentPizzaCity.ChooseSouce()
        return
    }
    when (currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.getDrink()
    }
}