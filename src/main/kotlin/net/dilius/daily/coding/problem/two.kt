package net.dilius.daily.coding.problem

/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Uber.
 *
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */


fun productsExceptCurrent(numbers: List<Int>): List<Int> {
    val product = numbers.reduce(Int::times)
    return numbers.map { product / it }
}


fun test() {
    val nums = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
    val products = productsExceptCurrent(nums)
    for((i, product) in products.withIndex()) {
        assert(product % nums[i] != 0)
    }
}

fun main() {
    test()
}

