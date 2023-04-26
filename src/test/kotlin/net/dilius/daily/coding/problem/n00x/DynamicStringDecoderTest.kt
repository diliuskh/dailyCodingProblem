package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals


class DynamicStringDecoderTest {

    @ParameterizedTest
    @MethodSource("net.dilius.daily.coding.problem.n00x.StringDecoderTest#codeStringSource")
    fun solve(input: String, num: Int) {
        val result = DynamicStringDecoder().solve(input)
        assertEquals(num, result)
    }
}