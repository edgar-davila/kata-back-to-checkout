trait Fruit {
    def getPriceWithBulkDiscount(value: Int): Int
}

class Pear(val price: Int = 20) extends Fruit() {
  override def getPriceWithBulkDiscount(value: Int): Int = {
    (value * price) - (value / 3) * 10
  }
}

class Manzana(val price: Int = 10) extends Fruit() {
  override def getPriceWithBulkDiscount(value: Int): Int = {
    (value * price) - (value / 2) * 2
  }
}


