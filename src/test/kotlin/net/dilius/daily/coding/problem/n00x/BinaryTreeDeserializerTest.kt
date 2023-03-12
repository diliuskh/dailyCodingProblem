package net.dilius.daily.coding.problem.n00x

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BinaryTreeDeserializerTest {

    @Test
    fun solve() {
        val input = Node(
            "1",
            Node("0"),
            Node("2", Node("3", Node("31", Node("32"), Node("33"))), Node("4"))
        )
        val treeString = BinaryTreeSerializer().solve(
            input
        )
        val node = BinaryTreeDeserializer().solve(treeString)
        assertEquals(input, node)
    }
}