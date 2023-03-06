package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class AddsUpToNumFastTest {

    @ParameterizedTest
    @MethodSource("net.dilius.daily.coding.problem.n00x.AddsUpToNumTest#addsUpSource")
    fun solve(input: Input, addsUp: Boolean) {

        val addsUpToNum = AddsUpToNumFast()

        assertEquals(addsUp, addsUpToNum.solve(input))
    }
}