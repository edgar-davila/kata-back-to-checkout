

class CheckoutTest extends org.scalatest.FunSuite {
  test("two item prices are summed") {
    val checkout = Checkout
    checkout.add(new Fruit(10))
    checkout.add(new Fruit(20))
    assert(checkout.calcTotal() === 30)
  }
  test("two fruits with the same type are equals") {
    val manzana1 = CajonDeFruta.get("Manzana")
    val manzana2 = CajonDeFruta.get("Manzana")
    assert(manzana1 == manzana2)
  }

  test("two fruits have different type") {
    val manzana1 = CajonDeFruta.get("Manzana")
    val manzana2 = CajonDeFruta.get("Manzana")

    val checkout = Checkout
    checkout.add(manzana1)
    checkout.add(manzana2)
    assert(checkout.calcTotal() === 18)
  }
}
