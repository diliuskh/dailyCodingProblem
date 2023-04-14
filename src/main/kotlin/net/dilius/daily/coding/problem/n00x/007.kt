package net.dilius.daily.coding.problem.n00x

import net.dilius.daily.coding.problem.Problem

/*
This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

class StringDecoder : Problem<String, Int> {

    override fun solve(input: String): Int {
        return solve0(input)
    }

    fun solve0(input: String): Int {
        if (input.isEmpty()) {
            return 1
        }
        if (input.startsWith('0')) {
            return 0
        }

        val one = solve0(input.substring(1))

        val two =
            if (input.length < 2 || input.substring(0, 2).toInt() > 26) 0
            else solve0(input.substring(2))

        return one + two
    }

}