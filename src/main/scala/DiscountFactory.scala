class DiscountFactory {

  val strategies: Map[String, DiscountStrategy] = Map(classOf[Apple].getName -> new AppleStrategy(), classOf[Pear].getName -> new PearStrategy())

  def calculateDiscount(cart: Map[Fruit, Int], weekDay: String): Int = {
    var sum = 0
    cart.foreach((x) => {
      sum += strategies.get(x._1.getClass.getName).map(_.discount(x._2, weekDay)).getOrElse(0)
    })
    sum
  }

}

trait DiscountStrategy {
  def discount(quantity: Int, weekDay: String): Int
}

class AppleStrategy extends DiscountStrategy {
  override def discount(quantity: Int, weekDay: String): Int = {
    weekDay match {
      case WeekDay.monday => (quantity / 3) * 10
      case WeekDay.friday => (quantity / 30) * 150 // 30 / 30 * 150 = 150 => 20 * 30 -150 = 600 - 150 = 450
      case _ => 0
    }

  }
}

class PearStrategy extends DiscountStrategy {
  override def discount(quantity: Int, weekDay: String): Int = {
    (quantity / 2) * 2
  }
}