import Checkout.Fruit

class CheckoutTest extends org.scalatest.FunSuite {
  test("two item prices are summed") {
    val checkout = Checkout
    checkout.add(new Fruit(10))
    checkout.add(new Fruit(20))
    assert(checkout.calcTotal() === 30)
  }
}
