

class CheckoutTest extends org.scalatest.FunSuite {
  test("two item prices are summed") {
    val checkout = new Checkout()
    checkout.add(new Apple())
    checkout.add(new Pear())
    assert(checkout.calcTotal() === 30)
  }

  test("get price with bulk discount for two apple discount is 0") {
    val apple1 = new Apple()
    val discountFactory = new DiscountFactory()
    assert(discountFactory.calculateDiscount(Map(apple1 -> 2), WeekDay.everyDay) == 0)
  }

  test("get price with bulk discount for 2 pears discount is 18") {
    val pear = new Pear()
    val discountFactory = new DiscountFactory()
    assert(discountFactory.calculateDiscount(Map(pear -> 2), WeekDay.everyDay) == 2)
  }

  test("test get price with bulk discount for 3 apples discount is 50") {
    val apple1 = new Apple()

    val discountFactory = new DiscountFactory()
    assert(discountFactory.calculateDiscount(Map(apple1 -> 3), WeekDay.monday) == 10)
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

  test("test get price of cart with apples when its monday") {
    val checkout = new Checkout(WeekDay.monday)
    val apple = new Apple()
    checkout.add(apple)
    checkout.add(apple)
    checkout.add(apple)

    assert(checkout.calcTotal() == 50)
  }

  test("test get price of cart with apples when its everyday") {
    val checkout = new Checkout(WeekDay.everyDay)
    val apple = new Apple()
    checkout.add(apple)
    checkout.add(apple)
    checkout.add(apple)

    assert(checkout.calcTotal() == 60)
  }

  test("test get price of cart with apples when its friday") {
    val checkout = new Checkout(WeekDay.friday)
    val apple = new Apple()
    checkout.add(apple)
    checkout.add(apple)
    checkout.add(apple)

    assert(checkout.calcTotal() == 60)
  }

  test("test get price of cart with apples when its friday with discount") {
    val checkout = new Checkout(WeekDay.friday)
    val apple = new Apple()
    for (i <- 1 to 30) checkout.add(apple)

    assert(checkout.calcTotal() == 450)
  }

}
