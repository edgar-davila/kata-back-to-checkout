import scala.collection.mutable.Stack

object Checkout {
  var items = new Stack[Fruit]()

  def add(fruit: Fruit) = {
    items.push(fruit)
  }

  def calcTotal(): Int = {
    var sum = 0
    while (!items.isEmpty){
      sum += items.pop().price
    }
    return sum
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