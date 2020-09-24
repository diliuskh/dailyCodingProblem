package net.dilius.daily.coding.problem

/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from
 * the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * 3, 7, 10, 15
 * Bonus: Can you do this in one pass?
 */

fun isAnyTwoAddUpToK(numbers: List<Int>, k: Int): Boolean {
    val sorted = numbers.sorted()
    var i = 0
    var j = numbers.lastIndex
    while (i < j) {
        when {
            sorted[i] + sorted[j] < k -> {
                i++
            }
            sorted[i] + sorted[j] > k  -> {
                j--
            }
            sorted[i] + sorted[j] == k -> {
                return true
            }
        }
    }
    return false
}

fun test1() {
    val nums = listOf(1,3,15,17,33,105,4,2,9,0,25,12,-1,5,6)
    val sums = genSums(nums)
    for(sum in sums) {
        assert(isAnyTwoAddUpToK(nums, sum))
    }
}

fun genSums(numbers: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for(i in numbers.indices)
        for(j in (i..numbers.lastIndex))
            result.add(numbers[i] + numbers[j])
    return result
}

fun main() {
    test1()
}
