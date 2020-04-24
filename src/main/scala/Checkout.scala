import scala.collection.mutable.Stack

object Checkout {
  var cart = new Stack[Fruit]()

  def add(fruit: Fruit) = {
    cart.push(fruit)
  }

  def calcTotal(): Int = {
    var sum = 0
    while (cart.nonEmpty){
      sum += cart.pop().price
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val checkout = Checkout
    val pear = new Fruit(10)
    val apple = new Fruit(20)

    checkout.add(pear)
    checkout.add(apple)
    println("Total is " + checkout.calcTotal())
  }

  class Fruit(val price: Int) {

  }

}