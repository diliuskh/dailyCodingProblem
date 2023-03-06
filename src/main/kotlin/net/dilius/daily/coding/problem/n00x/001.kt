package net.dilius.daily.coding.problem.n00x

import net.dilius.daily.coding.problem.Problem

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
 */

data class Input(val nums: List<Int>, val k: Int)

class AddsUpToNum : Problem<Input, Boolean> {
    override fun solve(input: Input): Boolean {
        val (nums, k) = input
        for (i in nums.indices) {
            if (nums[i] > k) continue
            for (j in i+1 until nums.size) {
                if (nums[j] > k) continue
                if (nums[i] + nums[j] == k) return true
            }
        }
        return false
    }
}