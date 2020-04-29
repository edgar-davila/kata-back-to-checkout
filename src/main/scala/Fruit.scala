trait Fruit {
    def getPriceWithBulkDiscount(value: Int): Int
}

class Pear(val price: Int = 10) extends Fruit() {
  override def getPriceWithBulkDiscount(quantity: Int): Int = {
    (quantity * price) - (quantity / 2) * 2 // 2 * 10 = 20 - 2 = 18
  }
}

class Apple(val price: Int = 20) extends Fruit() {
  override def getPriceWithBulkDiscount(quantity: Int): Int = {
    (quantity * price) - (quantity / 3) * 10 // 3 * 20 = 60 - 10
  }
}

class Banana(val price: Int = 15) extends Fruit() {
  override def getPriceWithBulkDiscount(quantity: Int): Int = {
    quantity * price
  }
}


