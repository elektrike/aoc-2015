import java.math.BigInteger
import java.security.MessageDigest

fun main() {
    fun String.md5(): String =
        BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
            .toString(16).padStart(32, '0')

    fun mineAdventCoin(code: String, hash: String): Int {
        tailrec fun mine(number: Int): Int =
            if (("$hash$number").md5().startsWith(code))
                number
            else
                mine(number + 1)

        return mine(1)
    }

    fun part1(input: String): Int = mineAdventCoin(input, "00000")
    fun part2(input: String): Int = mineAdventCoin(input, "000000")
}