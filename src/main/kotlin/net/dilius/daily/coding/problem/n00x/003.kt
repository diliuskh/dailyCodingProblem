package net.dilius.daily.coding.problem.n00x

import net.dilius.daily.coding.problem.Problem
import java.util.StringTokenizer

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

data class Node(val value: String, val left: Node? = null, val right: Node? = null)

class BinaryTreeSerializer : Problem<Node, String> {
    override fun solve(input: Node): String {
        return serialize(input)
    }

    private fun serialize(node: Node?): String {
        return if (node == null)  "{}"
        else "{\"${node.value}\",${serialize(node.left)},${serialize(node.right)}}"
    }
}

class BinaryTreeDeserializer : Problem<String, Node> {
    override fun solve(input: String): Node {
        return deserialize(input)!!
    }

    private fun deserialize(input: String): Node? {
        if (input.isEmpty()) throw IllegalArgumentException("Input is empty")
        if (input[0] != '{') throw IllegalArgumentException("Invalid token at 0")
        if (input == "{}") return null
        if (input.length < 3) throw IllegalArgumentException("Invalid token at 3")
        val substring = input.substring(2)
        val valEnding = substring.indexOfFirst { it == '"' }
        val value = substring.substring(0, valEnding)
        val (left, right) = getSubNodes(input)
        return Node(value, deserialize(left), deserialize(right))
    }

    private fun getSubNodes(input: String): Pair<String, String> {
        val indexOfLeftNodeBeginning = input.indexOfNth(2) { c -> c == '{' }
        if (indexOfLeftNodeBeginning == -1) throw IllegalArgumentException("Invalid input")
        val indexOfLeftNodeEnding = input.findBalancingBracketEnd(indexOfLeftNodeBeginning)
        if (indexOfLeftNodeEnding == -1) throw IllegalArgumentException("Invalid input")
        val indexOfRightNodeBeginning = indexOfLeftNodeEnding+2
        if (input[indexOfRightNodeBeginning] != '{') throw IllegalArgumentException("Invalid input")
        val indexOfRightNodeEnding = input.findBalancingBracketEnd(indexOfRightNodeBeginning)
        if (indexOfRightNodeEnding == -1) throw IllegalArgumentException("Invalid input")
        return input.substring(indexOfLeftNodeBeginning, indexOfLeftNodeEnding+1) to
                input.substring(indexOfRightNodeBeginning, indexOfRightNodeEnding+1)
    }

}

inline fun CharSequence.indexOfNth(n:Int, predicate: (Char) -> Boolean): Int {
    var found = 0
    for (index in indices) {
        if (predicate(this[index])) {
            found++
            if (found == n)
                return index
        }
    }
    return -1
}

inline fun CharSequence.findBalancingBracketEnd(beginningBracketIndex:Int): Int {
    var found = 0
    for (index in beginningBracketIndex..length) {
        if (this[index] == '{') found++
        if (this[index] == '}') {
            found--
            if (found == 0) {
                return index
            }
        }
    }
    return -1
}

