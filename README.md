# Day 2 - Scala Collections Practice

## Objective

The objective of this assignment is to practice Scala collection operations using simple sales, customer, and order examples.

## Topics Covered

### 1. Map, Filter, FlatMap and Reduce

- `map` is used to transform sales data.
- `filter` is used to select products with price greater than 5000.
- `flatMap` is used to flatten product and category information.
- `reduce` is used to calculate total sales.

### 2. Vector

A `Vector` is used to store customer records and access them using indexes.

### 3. Map

`Map` is used to store product quantities and prices and calculate the total value of each product.

### 4. For-Comprehension

A `for`-comprehension is used to combine customer records with their orders by matching customer IDs.

### 5. Daily Sales Summary

Scala collections are used to group orders by day and calculate daily and grand total sales without using Spark.

## Sample Output

```text
===== 1. MAP, FILTER, FLATMAP AND REDUCE =====
Sales after 18% tax:
(Laptop,88500.0)
(Mouse,1770.0)
(Keyboard,3540.0)
(Laptop,88500.0)
(Monitor,23600.0)

Products with price > 5000:
(Laptop,75000)
(Laptop,75000)
(Monitor,20000)

FlatMap result:
(Laptop,Electronics)
(Laptop,Computer)
(Chair,Furniture)
(Chair,Office)
(Mouse,Electronics)
(Mouse,Accessories)

Total Sales: 174500

===== 2. VECTOR - INDEXED CUSTOMER RECORDS =====
Customer Vector: Vector(C001 - Harshita, C002 - Rahul, C003 - Priya, C004 - Arun)
Customer at index 0: C001 - Harshita
Customer at index 2: C003 - Priya

Why Vector is useful:
- Vector provides fast indexed access.
- It is immutable.
- It is useful when records need to be accessed using an index.

===== 3. MAP - PRODUCT QUANTITIES AND PRICES =====
Product Quantities: Map(Laptop -> 5, Mouse -> 20, Keyboard -> 10, Monitor -> 8)
Product Prices: Map(Laptop -> 75000, Mouse -> 1500, Keyboard -> 3000, Monitor -> 20000)

Laptop Quantity: 5
Laptop Price: 75000

Total value for each product:
(Laptop,375000)
(Mouse,30000)
(Keyboard,30000)
(Monitor,160000)

===== 4. FOR-COMPREHENSION - CUSTOMERS AND ORDERS =====
Customer Orders:
Customer ID: C001, Name: Harshita, Product: Laptop, Amount: 75000
Customer ID: C001, Name: Harshita, Product: Mouse, Amount: 1500
Customer ID: C002, Name: Rahul, Product: Keyboard, Amount: 3000
Customer ID: C002, Name: Rahul, Product: Laptop, Amount: 75000
Customer ID: C003, Name: Priya, Product: Monitor, Amount: 20000

===== 5. DAILY SALES SUMMARY WITHOUT SPARK =====
Daily Sales Summary:
Monday -> Total Sales: 76500
Tuesday -> Total Sales: 23000
Wednesday -> Total Sales: 76500

Grand Total Sales: 176000

===== DAY 2 SCALA COLLECTIONS PRACTICE COMPLETED =====
