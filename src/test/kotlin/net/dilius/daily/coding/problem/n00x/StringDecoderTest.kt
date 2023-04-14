package net.dilius.daily.coding.problem.n00x


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringDecoderTest {

    @ParameterizedTest
    @MethodSource("codeStringSource")
    fun solve(codeString: String, num: Int) {
        val decodings = StringDecoder().solve(codeString)
        kotlin.test.assertEquals(num, decodings)
    }

    companion object {
        @JvmStatic
        fun codeStringSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("01", 0),
                Arguments.of("013", 0),
                Arguments.of("602", 0),
                Arguments.of("1", 1),
                Arguments.of("12", 2),
                Arguments.of("122", 3),
                Arguments.of("1223", 5),
                Arguments.of("431231512",12),
            )
        }
    }
}


