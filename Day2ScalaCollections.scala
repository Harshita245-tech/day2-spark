object Day2ScalaCollections extends App {

  // ==========================================================
  // 1. SALES LIST - MAP, FILTER, FLATMAP AND REDUCE
  // ==========================================================

  println("\n===== 1. MAP, FILTER, FLATMAP AND REDUCE =====")

  val sales = List(
    ("Laptop", 75000),
    ("Mouse", 1500),
    ("Keyboard", 3000),
    ("Laptop", 75000),
    ("Monitor", 20000)
  )

  // map - calculate sales values
  val salesWithTax = sales.map {
    case (product, price) =>
      (product, price + price * 0.18)
  }

  println("Sales after 18% tax:")
  salesWithTax.foreach(println)

  // filter - select products above 5000
  val highValueSales = sales.filter {
    case (_, price) => price > 5000
  }

  println("\nProducts with price > 5000:")
  highValueSales.foreach(println)

  // flatMap - split product categories
  val productCategories = List(
    ("Laptop", List("Electronics", "Computer")),
    ("Chair", List("Furniture", "Office")),
    ("Mouse", List("Electronics", "Accessories"))
  )

  val flattenedCategories = productCategories.flatMap {
    case (product, categories) =>
      categories.map(category => (product, category))
  }

  println("\nFlatMap result:")
  flattenedCategories.foreach(println)

  // reduce - calculate total sales
  val totalSales = sales.map {
    case (_, price) => price
  }.reduce(_ + _)

  println(s"\nTotal Sales: $totalSales")


  // ==========================================================
  // 2. VECTOR - INDEXED CUSTOMER RECORDS
  // ==========================================================

  println("\n===== 2. VECTOR - INDEXED CUSTOMER RECORDS =====")

  val customers = Vector(
    "C001 - Harshita",
    "C002 - Rahul",
    "C003 - Priya",
    "C004 - Arun"
  )

  println(s"Customer Vector: $customers")

  println(s"Customer at index 0: ${customers(0)}")
  println(s"Customer at index 2: ${customers(2)}")

  println("\nWhy Vector is useful:")
  println("- Vector provides fast indexed access.")
  println("- It is immutable.")
  println("- It is useful when records need to be accessed using an index.")


  // ==========================================================
  // 3. MAP - PRODUCT QUANTITIES AND PRICES
  // ==========================================================

  println("\n===== 3. MAP - PRODUCT QUANTITIES AND PRICES =====")

  val productQuantities = Map(
    "Laptop" -> 5,
    "Mouse" -> 20,
    "Keyboard" -> 10,
    "Monitor" -> 8
  )

  val productPrices = Map(
    "Laptop" -> 75000,
    "Mouse" -> 1500,
    "Keyboard" -> 3000,
    "Monitor" -> 20000
  )

  println(s"Product Quantities: $productQuantities")
  println(s"Product Prices: $productPrices")

  val laptopQuantity = productQuantities("Laptop")
  val laptopPrice = productPrices("Laptop")

  println(s"\nLaptop Quantity: $laptopQuantity")
  println(s"Laptop Price: $laptopPrice")

  val productTotals = productQuantities.map {
    case (product, quantity) =>
      val price = productPrices(product)
      val total = quantity * price
      (product, total)
  }

  println("\nTotal value for each product:")
  productTotals.foreach(println)


  // ==========================================================
  // 4. FOR-COMPREHENSION - CUSTOMERS AND ORDERS
  // ==========================================================

  println("\n===== 4. FOR-COMPREHENSION - CUSTOMERS AND ORDERS =====")

  val customerRecords = List(
    ("C001", "Harshita"),
    ("C002", "Rahul"),
    ("C003", "Priya")
  )

  val orders = List(
    ("C001", "Laptop", 75000),
    ("C001", "Mouse", 1500),
    ("C002", "Keyboard", 3000),
    ("C003", "Monitor", 20000),
    ("C002", "Laptop", 75000)
  )

  val customerOrders = for {
    customer <- customerRecords
    order <- orders
    if customer._1 == order._1
  } yield (
    customer._1,
    customer._2,
    order._2,
    order._3
  )

  println("Customer Orders:")

  customerOrders.foreach {
    case (id, name, product, amount) =>
      println(
        s"Customer ID: $id, Name: $name, Product: $product, Amount: $amount"
      )
  }


  // ==========================================================
  // 5. DAILY SALES SUMMARY - WITHOUT SPARK
  // ==========================================================

  println("\n===== 5. DAILY SALES SUMMARY WITHOUT SPARK =====")

  val dailyOrders = List(
    ("Monday", "Laptop", 75000),
    ("Monday", "Mouse", 1500),
    ("Tuesday", "Keyboard", 3000),
    ("Tuesday", "Monitor", 20000),
    ("Wednesday", "Laptop", 75000),
    ("Wednesday", "Mouse", 1500)
  )

  val dailySales = dailyOrders
    .groupBy {
      case (day, _, _) => day
    }
    .map {
      case (day, orders) =>
        val total = orders.map {
          case (_, _, amount) => amount
        }.reduce(_ + _)

        (day, total)
    }

  println("Daily Sales Summary:")

  dailySales.toList.sortBy(_._1).foreach {
    case (day, total) =>
      println(s"$day -> Total Sales: $total")
  }

  val grandTotal = dailyOrders.map {
    case (_, _, amount) => amount
  }.reduce(_ + _)

  println(s"\nGrand Total Sales: $grandTotal")


  // ==========================================================
  // END
  // ==========================================================

  println("\n===== DAY 2 SCALA COLLECTIONS PRACTICE COMPLETED =====")
}
