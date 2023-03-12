package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BinaryTreeSerializerTest {

    @Test
    fun solve() {
        val binaryTreeSerializer = BinaryTreeSerializer()
        val solve = binaryTreeSerializer.solve(Node("1", Node("0")))
        assertEquals("{\"1\",{\"0\",{},{}},{}}", solve)
    }
}