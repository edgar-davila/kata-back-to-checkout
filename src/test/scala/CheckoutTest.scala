

class CheckoutTest extends org.scalatest.FunSuite {
  test("two item prices are summed") {
    val checkout = new Checkout()
    checkout.add(new Manzana())
    checkout.add(new Pear())
    assert(checkout.calcTotal() === 30)
  }

  test("get price with bulk discount for two apple is 18") {
    val apple1 = new Manzana()

    assert(apple1.getPriceWithBulkDiscount(2) == 18)
  }

  test("get price with bulk discount for three pears is 50") {
    val pear = new Pear()
    assert(pear.getPriceWithBulkDiscount(3) == 50)
  }

  test("test get price with bulk discount for 3 apples is 28") {
    val apple1 = new Manzana()

    assert(apple1.getPriceWithBulkDiscount(3) == 28)
  }

  test("test get price of cart with 2 apples and 1 pear") {
    val checkout = new Checkout()
    val apple = new Manzana()
    val pear = new Pear()

    checkout.add(apple)
    checkout.add(apple)
    checkout.add(pear)

    assert(checkout.calcTotal() == 38)
  }

}
