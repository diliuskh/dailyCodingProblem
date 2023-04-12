package net.dilius.daily.coding.problem.n00x

import net.dilius.daily.coding.problem.Problem

/*
This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

[32, 5, 10, 2, 1]

You can modify the input array in-place.
 */
class LowestPositiveNonExistingInt : Problem<IntArray, Int> {
    override fun solve(input: IntArray): Int {
        if (input.isEmpty()) return 1
        for ((i, value) in input.withIndex()) {
            var v: Int
            while (i + 1 != input[i] && 0 < input[i] && input[i] <= input.size) {
                v = input[i]
                val t1 = input[v - 1]
                val t2 = input[i]
                input[i] = t1
                input[v-1] = t2
                if (input[i] == input[v-1])
                    break
            }
        }
        for ((i, value) in input.withIndex()) {
            if (i+1 != value)
                return i+1
        }
        return input.size + 1
    }
}