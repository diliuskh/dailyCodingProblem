package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class AddsUpToNumTest {

    @ParameterizedTest
    @MethodSource("addsUpSource")
    fun solve(input: Input, addsUp: Boolean) {

        val addsUpToNum = AddsUpToNum()

        assertEquals(addsUp, addsUpToNum.solve(input))
    }

    companion object {
        @JvmStatic
        fun addsUpSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Input(listOf(0,0),0), true),
                Arguments.of(Input(listOf(0,1),1), true),
                Arguments.of(Input(listOf(1,0),1), true),
                Arguments.of(Input(listOf(1,1),2), true),
                Arguments.of(Input(listOf(1,2),3), true),
                Arguments.of(Input(listOf(1,2,3,4,5,6,7,8,9,10),17), true),
                Arguments.of(Input(listOf(40,23,31,1,15,9,11,3,0,5),23), true),
                Arguments.of(Input(listOf(10, 15, 3, 7),17), true),
                Arguments.of(Input(listOf(0, 0),1), false),
                Arguments.of(Input(listOf(0, 1),2), false),
                Arguments.of(Input(listOf(1, 0),2), false),
                Arguments.of(Input(listOf(1, 1),0), false),
                Arguments.of(Input(listOf(40,23,31,1,15,9,11,3,0,5),0), false),
                Arguments.of(Input(listOf(40,23,31,1,15,9,11,3,0,5),13), false),
            )
        }
    }
}