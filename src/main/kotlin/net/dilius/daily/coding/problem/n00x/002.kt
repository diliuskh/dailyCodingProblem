package net.dilius.daily.coding.problem.n00x

import net.dilius.daily.coding.problem.Problem

/*
Given an array of integers, return a new array such that each element at index i of the new array
is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */

class ProductsExceptCurrent : Problem<IntArray, IntArray> {
    override fun solve(input: IntArray): IntArray {
        val product = input.reduce { acc, i -> acc * i }
        return input.map { product / it }.toIntArray()
    }
}

class ProductsExceptCurrentNoDivision : Problem<IntArray, IntArray> {
    override fun solve(input: IntArray): IntArray {
        val product = input.reduce { acc, i -> acc * i }
        return input.map { divide(product, it) }.toIntArray()
    }

    private fun divide(a: Int, b: Int): Int {
        val sign = if ((a < 0) xor (b < 0)) -1 else 1
        var i = 0
        var n = a
        while (n >= b) {
            n -= b
            i++
        }
        if (sign == -1) i = -i
        return i
    }
}

class ProductsExceptCurrentNoDivisionPrefixSuffix: Problem<IntArray, IntArray> {
    override fun solve(input: IntArray): IntArray {
        val prefixProducts = IntArray(input.size)
        val suffixProducts = IntArray(input.size)
        for (i in input.indices) {
            prefixProducts[i] = input[i] * if (i == 0) 1 else prefixProducts[i-1]
        }
        for (i in input.indices.reversed()) {
            suffixProducts[i] = input[i] * if (i == input.size - 1) 1 else suffixProducts[i+1]
        }

        return input.indices.map {
            when (it) {
                0 -> suffixProducts[it+1]
                input.size -1 -> prefixProducts[it -1]
                else -> prefixProducts[it -1] * suffixProducts[it+1]
            }
        }.toIntArray()
    }
}