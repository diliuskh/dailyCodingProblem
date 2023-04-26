package net.dilius.daily.coding.problem.n00x

import net.dilius.daily.coding.problem.Problem

data class UnivalTree(val left: UnivalTree?, val right: UnivalTree?, val value: Int)
class UnivalTreeCounter : Problem<UnivalTree, Int> {
    override fun solve(input: UnivalTree): Int {
        return solve0(input)
    }

    fun solve0(input: UnivalTree?): Int {
        if (input == null) {
            return 0
        }
        if (input.left == null && input.right == null) {
            return 1
        }
        return ((if (isUnival(input)) 1 else 0)
                + solve0(input.left) + solve0(input.right))

    }

    private fun isUnival(input: UnivalTree): Boolean {
        return isLeaf(input) || isUnival0(input, input.value)
    }

    private fun isUnival0(root: UnivalTree?, value: Int): Boolean {
        if (root == null) return true
        if (root.value == value) {
            return isUnival0(root.left, value) && isUnival0(root.right, value)
        }
        return false
    }

    private fun isLeaf(input: UnivalTree): Boolean {
        return input.left == null && input.right == null
    }
}

class LinearUnivalTreeCounter: Problem<UnivalTree, Int> {
    override fun solve(input: UnivalTree): Int {
        return solve0(input).second
    }

    fun solve0(root: UnivalTree?): Pair<Boolean, Int> {
        if (root == null) {
            return true to 0
        }
        val (isLeftUnival, leftUnivalCount) = solve0(root.left)
        val (isRightUnival, rightUnivalCount) = solve0(root.right)
        val totalUnivalCount = leftUnivalCount + rightUnivalCount

        if (isLeftUnival && isRightUnival) {
            if (root.left != null && root.value != root.left.value) {
                return false to totalUnivalCount
            }
            if (root.right != null && root.value != root.right.value) {
                return false to totalUnivalCount
            }
            return true to 1 + totalUnivalCount
        }
        return false to totalUnivalCount
    }
}