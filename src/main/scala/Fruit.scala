trait Fruit {
    def price: Int
    def totalPrice(quantity: Int) = quantity * price
}

class Pear(val price: Int = 10) extends Fruit() {
}

class Apple(val price: Int = 20) extends Fruit() {
}

class Banana(val price: Int = 15) extends Fruit() {
}


