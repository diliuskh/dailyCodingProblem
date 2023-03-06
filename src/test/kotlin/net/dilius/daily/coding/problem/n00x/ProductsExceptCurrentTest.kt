package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertContentEquals

class ProductsExceptCurrentTest {


    @ParameterizedTest
    @MethodSource("productsSource")
    fun solve(input: IntArray, output: IntArray) {
        assertContentEquals(output, ProductsExceptCurrent().solve(input))
    }

    companion object {
        @JvmStatic
        fun productsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1,1),intArrayOf(1,1)),
                Arguments.of(intArrayOf(1,2),intArrayOf(2,1)),
                Arguments.of(intArrayOf(1,2,3,4,5),intArrayOf(120,60,40,30,24)),
                Arguments.of(intArrayOf(2,4,5,10,13,3,7),intArrayOf(54600,27300,21840,10920,8400,36400,15600)),
            )
        }
    }
}