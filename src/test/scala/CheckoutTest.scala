

class CheckoutTest extends org.scalatest.FunSuite {
  test("two item prices are summed") {
    val checkout = new Checkout()
    checkout.add(new Apple())
    checkout.add(new Pear())
    assert(checkout.calcTotal() === 30)
  }

  test("get price with bulk discount for two apple is 40") {
    val apple1 = new Apple()

    assert(apple1.getPriceWithBulkDiscount(2) == 40)
  }

  test("get price with bulk discount for three pears is 18") {
    val pear = new Pear()
    assert(pear.getPriceWithBulkDiscount(2) == 18)
  }

  test("test get price with bulk discount for 3 apples is 50") {
    val apple1 = new Apple()

    assert(apple1.getPriceWithBulkDiscount(3) == 50)
  }

  test("test get price of cart with 2 pear and 1 apple") {
    val checkout = new Checkout()
    val apple = new Apple()
    val pear = new Pear()

    checkout.add(apple)
    checkout.add(pear)
    checkout.add(pear)

    assert(checkout.calcTotal() == 38)
  }

  test("test get price of cart with 2 bananas and 1 pear") {
    val checkout = new Checkout()
    val banana = new Banana()
    val pear = new Pear()

    checkout.add(banana)
    checkout.add(banana)
    checkout.add(pear)

    assert(checkout.calcTotal() == 40)
  }

  test("test get price of cart with 2 pear when its friday") {
    val checkout = new Checkout(WeekDay.monday)
    val pear = new Pear()
    checkout.add(pear)
    checkout.add(pear)

    assert(checkout.calcTotal() == 18)
  }

}
