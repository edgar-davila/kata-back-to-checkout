import scala.collection.mutable

class Checkout(val weekDay: String = WeekDay.everyDay) {
  var cart = new mutable.HashMap[Fruit, Int]()

  def add(item: Fruit) = {
    val quantity = cart.getOrElse(item, 0)
    cart.put(item, quantity+1)
  }

  def calcTotal(): Int = {
    var sum = 0
    cart.foreach((x) => sum += x._1.getPriceWithBulkDiscount(x._2))
    sum
  }
}