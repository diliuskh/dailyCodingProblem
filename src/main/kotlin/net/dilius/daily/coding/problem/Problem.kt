package net.dilius.daily.coding.problem

interface Problem<I, R> {
    fun solve(input: I): R
}
