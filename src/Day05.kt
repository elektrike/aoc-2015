import java.util.regex.Pattern

fun main() {
    fun String.matches(regex: String): Boolean = Pattern.compile(regex).matcher(this).find()

    fun String.hasEnoughVowels(): Boolean = matches("(.*[aeiou]){3}")
    fun String.hasConsecutiveLetters(): Boolean = matches("(.)\\1")
    fun String.containsBadStrings(): Boolean = matches("ab|cd|pq|xy")
    fun String.hasRepeatingPair(): Boolean = matches("(..).*\\1")
    fun String.hasSameLetterWithAnotherInBetween(): Boolean = matches("(.).\\1")

    fun part1(input: List<String>): Int =
        input.count { it.hasEnoughVowels() && it.hasConsecutiveLetters() && !it.containsBadStrings() }

    fun part2(input: List<String>): Int =
        input.count { it.hasRepeatingPair() && it.hasSameLetterWithAnotherInBetween() }
}
