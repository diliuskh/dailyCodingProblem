package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class LowestPositiveNonExistingIntTest {

    @ParameterizedTest
    @MethodSource("inputArraySource")
    fun testSolve(input: IntArray, value: Int) {
        val result = LowestPositiveNonExistingInt().solve(input)
        assertEquals(value, result)
    }

    companion object {
        @JvmStatic
        fun inputArraySource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(),1),
                Arguments.of(intArrayOf(1,2),3),
                Arguments.of(intArrayOf(1,2,3,4,5),6),
                Arguments.of(intArrayOf(2,4,5,10,13,3,7),1),
                Arguments.of(intArrayOf(2,4,5,10,13,3,7,1,6,8,9,11,12),14),
                Arguments.of(intArrayOf(2,4,5,10,13,3,7,1,6,8,),9),
                Arguments.of(intArrayOf(-2,0,59,2,4,5,10,13,3,7,1,6,8,-1),9),
            )
        }
    }
}