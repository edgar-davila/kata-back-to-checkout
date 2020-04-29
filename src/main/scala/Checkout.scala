import scala.collection.mutable

class Checkout(val weekDay: String = WeekDay.everyDay) {
  val discountFactory = new DiscountFactory()
  var cart = new mutable.HashMap[Fruit, Int]()

  def add(item: Fruit) = {
    val quantity = cart.getOrElse(item, 0)
    cart.put(item, quantity+1)
  }

  def calcTotal(): Int = {
    var sum = 0
    cart.foreach((x) => sum += x._1.totalPrice(x._2))
    sum -= discountFactory.calculateDiscount(cart.toMap, weekDay)
    sum
  }
}