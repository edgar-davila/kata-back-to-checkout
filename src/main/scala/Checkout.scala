import scala.collection.mutable

object Checkout {
  var cart = new mutable.Stack[Item]()

  def add(item: Item) = {
    cart.push(item)
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

  trait Item {
    def price : Int
  }

}