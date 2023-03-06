package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

class ProductsExceptCurrentNoDivisionTest {


    @ParameterizedTest
    @MethodSource("net.dilius.daily.coding.problem.n00x.ProductsExceptCurrentTest#productsSource")
    fun solve(input: IntArray, output: IntArray) {
        assertContentEquals(output, ProductsExceptCurrentNoDivision().solve(input))
    }
}