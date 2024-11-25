import kotlin.system.exitProcess

abstract class Pizza(pizzaCost: List<Int>) {
    abstract var town: String
    abstract var address: String
    abstract var pizzaPrice: MutableMap<String, Int>
    abstract var pizzaCount: Array<Int>
    open fun salePizza(pizza: String): Int {
        return 1
    }

    open var sum = 0
    open var countCheque = 0
    open var countcoffee = 0
    open fun showStats() {
        println(
            "Продано пицц\n" +
                    "Сырная - ${pizzaCount[0]}\n" +
                    "Пепперони - ${pizzaCount[1]}\n" +
                    "Мясная - ${pizzaCount[2]}\n" +
                    "C ветчиной и сыром - ${pizzaCount[3]}\n" +
                    "Карбонара - ${pizzaCount[4]}\n"
        )
        sum = pizzaCount[0] * pizzaPrice.get("Сырная")!! + pizzaCount[1] * pizzaPrice.get("Пепперони")!! +
                pizzaCount[2] * pizzaPrice.get("Мясная")!! + pizzaCount[3] * pizzaPrice.get("Ветчина и сыр")!! +
                pizzaCount[4] * pizzaPrice.get("Карбонара")!!

    }
}

class PizzaSPB(pizzaCost: List<Int>) : Pizza(pizzaCost), Drink {
    override var town = "Санкт-Петербург"
    override var address = "Невский пр. д35 стр.4"
    override var pizzaPrice = mutableMapOf(
        "Сырная" to pizzaCost[0],
        "Пепперони" to pizzaCost[1],
        "Мясная" to pizzaCost[2],
        "Ветчина и сыр" to pizzaCost[3],
        "Карбонара" to pizzaCost[4]
    )
    override var pizzaCount = arrayOf(0, 0, 0, 0, 0)
    override fun getDrink(): Boolean {
        if (super.getDrink()) {
            boolOfCoffee = true
            countcoffee++
        } else boolOfCoffee = false
        return false
    }

    protected var boolOfCoffee = false
    protected var currPizzaCoffeeArr = arrayOf(0, 0, 0, 0, 0)
    override fun showStats() {
        super.showStats()
        if (countcoffee != 0) {
            println("Кофе продано: $countcoffee\nВыручка: ${200 * countcoffee}")
            println("Кофе берут ${((countcoffee.toDouble() / (pizzaCount.sum())) * 100).toInt()} % людей\n")
            println(
                "Чаще всего кофе берут к пицце ${
                    pizzaPrice.entries.elementAt(
                        currPizzaCoffeeArr.indexOf(
                            currPizzaCoffeeArr.max()
                        )
                    ).key
                }: продано ${currPizzaCoffeeArr.max()}, это ${
                    ((currPizzaCoffeeArr.max().toDouble() / currPizzaCoffeeArr.sum()) * 100).toInt()
                } %"
            )
            println("Всего заработано денег: ${sum + countcoffee * 200} рублей")
        }
    }

    override fun salePizza(num: String): Int {
        when (num) {
            "1" -> {
                println("Спасибо за покупку сырной пиццы в Санкт-Петербурге")
                pizzaCount[0]++
                if (boolOfCoffee) currPizzaCoffeeArr[0]++
            }

            "2" -> {
                println("Спасибо за покупку пиццы пепперони в Санкт-Петербурге")
                pizzaCount[1]++
                if (boolOfCoffee) currPizzaCoffeeArr[1]++
            }

            "3" -> {
                println("Спасибо за покупку мясной пиццы в Санкт-Петербурге")
                pizzaCount[2]++
                if (boolOfCoffee) currPizzaCoffeeArr[2]++
            }

            "4" -> {
                println("Спасибо за покупку пиццы с ветчиной и сыром в Санкт-Петербурге")
                pizzaCount[3]++
                if (boolOfCoffee) currPizzaCoffeeArr[3]++
            }

            "5" -> {
                println("Спасибо за покупку пиццы карбонара в Санкт-Петербурге")
                pizzaCount[4]++
                if (boolOfCoffee) currPizzaCoffeeArr[4]++
            }

            "0" -> {
                showStats()
                return 0
            }

            else -> {
                println("Ошибка")
                return 0
            }
        }
        return 1
    }
}

class PizzaMoscow(pizzaCost: List<Int>) : Pizza(pizzaCost), CheckPhoto {
    override var town = "Москва"
    override var address: String = "ул. Ленина д.129 к.2 стр.4"
    override var pizzaPrice = mutableMapOf(
        "Сырная" to pizzaCost[0],
        "Пепперони" to pizzaCost[1],
        "Мясная" to pizzaCost[2],
        "Ветчина и сыр" to pizzaCost[3],
        "Карбонара" to pizzaCost[4]
    )
    override var pizzaCount = arrayOf(0, 0, 0, 0, 0)
    override fun showCheckPhoto(): Boolean {
        if (super.showCheckPhoto())
            super.countCheque++
        return false
    }

    protected var currPizzaCoffeeArr = arrayOf(0, 0, 0, 0, 0)
    override fun showStats() {
        super.showStats()
        if (countCheque != 0) {
            println("Чеков показано: $countCheque\nОбщая сумма скидок: ${countCheque * 50}")
            println("Чек показывают ${((countCheque.toDouble() / (pizzaCount.sum())) * 100).toInt()} % людей\n")
        }
        println("\nВсего заработано денег: ${sum + 50 * countCheque} рублей\n")
    }

    override fun salePizza(num: String): Int {
        when (num) {
            "1" -> {
                println("Спасибо за покупку сырной пиццы в Москве")
                pizzaCount[0]++
                return 1
            }

            "2" -> {
                println("Спасибо за покупку пиццы пепперони в Москве")
                pizzaCount[1]++
                return 1
            }

            "3" -> {
                println("Спасибо за покупку мясной пиццы в Москве")
                pizzaCount[2]++
                return 1
            }

            "4" -> {
                println("Спасибо за покупку пиццы с ветчиной и сыром в Москве")
                pizzaCount[3]++
                return 1
            }

            "5" -> {
                println("Спасибо за покупку пиццы карбонара в Москве")
                pizzaCount[4]++
                return 1
            }

            "0" -> {
                showStats()
                return 0
            }

            else -> {
                println("Ошибка")
                return 0

            }
        }
    }
}

class PizzaLyga(pizzaCost: List<Int>) : Pizza(pizzaCost), CheckPhoto, Drink, Souse {
    override var town = "Луга"
    override var address = "ул. Старцева д. 73"
    override var pizzaPrice = mutableMapOf(
        "Сырная" to pizzaCost[0],
        "Пепперони" to pizzaCost[1],
        "Мясная" to pizzaCost[2],
        "Ветчина и сыр" to pizzaCost[3],
        "Карбонара" to pizzaCost[4]
    )
    var pizzaSouce = mutableMapOf("Мед" to 150, "Горчичный" to 100)

    override var countCheque = 0
    override var countcoffee = 0
    override fun showCheckPhoto(): Boolean {
        if (super.showCheckPhoto())
            super.countCheque++
        return true
    }

    override var pizzaCount = arrayOf(0, 0, 0, 0, 0)
    override fun getDrink(): Boolean {
        if (super.getDrink()) {
            boolOfCoffee = true
            countcoffee++
        } else boolOfCoffee = false
        return false
    }

    var pizzaSouceCount = mutableListOf(0, 0, 0)
    override fun ChooseSouce(): Int {
        pizzaSouceCount[super.ChooseSouce()]++
        return 0
    }

    protected var boolOfCoffee = false
    protected var currPizzaCoffeeArr = arrayOf(0, 0, 0, 0, 0)
    override fun showStats() {
        super.showStats()
        println("Кофе продано: $countcoffee\nВыручка: ${200 * countcoffee}")
        println("Кофе берут ${((countcoffee.toDouble() / (pizzaCount.sum())) * 100).toInt()} % людей\n")
        println(
            if (currPizzaCoffeeArr.max() > 0)
                "Чаще всего кофе берут к пицце ${
                    pizzaPrice.entries.elementAt(currPizzaCoffeeArr.indexOf(currPizzaCoffeeArr.max())).key
                }: продано ${currPizzaCoffeeArr.max()}, это ${
                    ((currPizzaCoffeeArr.max().toDouble() / currPizzaCoffeeArr.sum()) * 100).toInt()
                } %" else ""
        )
        if (countCheque != 0) {
            println("Чеков показано: $countCheque\nОбщая сумма скидок: ${countCheque * 50}")
            println("Чек показывают ${((countCheque.toDouble() / (pizzaCount.sum())) * 100).toInt()} % людей\n")
        }
        println(
            "\nВыручка с соусов:\nМед - ${pizzaSouceCount[0] * pizzaSouce.get("Мед")!!} рублей\n" +
                    "Горчичный - ${pizzaSouce.get("Горчичный")!! * pizzaSouceCount[1]} рублей\n"
        )
        println(
            "Всего заработано денег: ${
                sum + countcoffee * 200 - 50 * countCheque + pizzaSouce.get("Мед")!! *
                        pizzaSouceCount[0] + pizzaSouce.get("Горчичный")!! * pizzaSouceCount[1]
            } рублей\n"
        )
    }

    override fun salePizza(num: String): Int {
        when (num) {
            "1" -> {
                println("Спасибо за покупку сырной пиццы в Луге")
                pizzaCount[0]++
                if (boolOfCoffee) currPizzaCoffeeArr[0]++
            }

            "2" -> {
                println("Спасибо за покупку пиццы пепперони в Луге")
                pizzaCount[1]++
                if (boolOfCoffee) currPizzaCoffeeArr[1]++
            }

            "3" -> {
                println("Спасибо за покупку мясной пиццы в Луге")
                pizzaCount[2]++
                if (boolOfCoffee) currPizzaCoffeeArr[2]++
            }

            "4" -> {
                println("Спасибо за покупку пиццы с ветчиной и сыром в Луге")
                pizzaCount[3]++
                if (boolOfCoffee) currPizzaCoffeeArr[3]++
            }

            "5" -> {
                println("Спасибо за покупку пиццы карбонара в Луге")
                pizzaCount[4]++
                if (boolOfCoffee) currPizzaCoffeeArr[4]++
            }

            "0" -> {
                showStats()
                return 0
            }

            else -> {
                println("Ошибка")
                return 0
            }
        }
        return 1
    }
}