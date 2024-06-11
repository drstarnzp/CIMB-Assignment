/** Q1 : Maximize Profit from Stock Prices **/
fun maxProfit(prices: List<Int>): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE

    prices.forEach { price ->
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }

    return maxProfit
}

/** Q2 : Compare Version Numbers **/
fun compareVersion(version1: String, version2: String): Int {
    val v1 = version1.split(".").map { it.toInt() }
    val v2 = version2.split(".").map { it.toInt() }
    val size = maxOf(v1.size, v2.size)

    for (i in 0 until size) {
        val num1 = if (i < v1.size) v1[i] else 0
        val num2 = if (i < v2.size) v2[i] else 0

        if (num1 < num2) return -1
        if (num1 > num2) return 1
    }

    return 0
}

/** Q3 : Climbing Stairs **/
fun climbStairs(n: Int): Int {
    if (n == 1) return 1

    var prev = 1
    var current = 2

    for (i in 3..n) {
        val next = prev + current
        prev = current
        current = next
    }

    return current
}

/**
 * Q4 :
 * What is the hardest question please explain -> Answer : Q1 (Maximum Profit from Stock Prices)
 *
 *  - Why it is hard
 *  Answer:
 *    1. Complexity of Decision Making : The making optimal decisions on when to buy and sell stocks to maximize profit and requires a strategy to keep track of the minimum price so far and the potential profit at each step.
 *    2. Single Pass Efficiency : The single pass through the array while maintaining the minimum price and calculating the potential maximum profit is requires a clear understanding of the problem constraints and efficient algorithm design

 *  - What kind of solution that you solve it
 *  Answer:
 *    1. Single Pass with Minimum Tracking: At each step, calculate the potential profit by subtracting the current price from the minimum price, and update the maximum profit accordingly. This ensures that the solution is efficient with a time complexity of O(n) and a space complexity of O(1).
 */

fun main() {
    //Q1 : Test Case 1
    val prices = listOf(7,1,5,3,6,4)
    val prices2 = listOf(7, 6, 4, 3, 1)

    println("Q1 : Maximize Profit Test Case 1 = ${maxProfit(prices)}")
    println("Q1 : Maximize Profit Test Case 2 = ${maxProfit(prices2)}  \n\n")

    // Q2 : Test Case 1
    val version1 = "1.01"
    val version2 = "1.001"

    println("Q2 : Compare Version Numbers Test Case 1 = ${compareVersion(version1, version2)}")

    // Q2 : Test Case 2
    val version11 = "1.0"
    val version22 = "1.0.0"

    println("Q2 : Compare Version Numbers Test Case 2 = ${compareVersion(version11, version22)}")

    // Q2 : Test Case 3
    val version111 = "0.1"
    val version222 = "1.1"

    println("Q2 : Compare Version Numbers Test Case 3 = ${compareVersion(version111, version222)} \n\n")

    // Q3 : Test Case 1
    val n1 = 2

    println("Q3 : Climbing Stairs Test Case 1 = ${climbStairs(n1)}")

    // Q3 : Test Case 2
    val n2 = 3

    println("Q3 : Climbing Stairs Test Case 2 = ${climbStairs(n2)}")
}