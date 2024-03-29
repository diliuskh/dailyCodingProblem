package net.dilius.daily.coding.problem.n50x

import net.dilius.daily.coding.problem.Problem

/*
You are given an M by N matrix consisting of booleans that represents a board.
Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
Given this matrix, a start coordinate, and an end coordinate,
return the minimum number of steps required to reach the end coordinate from the start.
If there is no possible path, then return null.
You can move up, left, down, and right. You cannot move through walls.
You cannot wrap around the edges of the board.
 */
data class Input(val matrix: Array<BooleanArray>, val start: Pair<Int, Int>, val end: Pair<Int, Int>)

class PathFinding : Problem<Input, Int?> {
    override fun solve(input: Input): Int? {
        TODO("Not yet implemented")
    }
}