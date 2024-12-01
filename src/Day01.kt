import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val leftLocationIds = input.toSortedLeftList()
        val rightLocationIds = input.toSortedRightList()
        return leftLocationIds.zip(rightLocationIds).sumOf { (a, b) -> abs(a - b) }
    }

    fun part2(input: List<String>): Int {
        val leftLocationIds = input.toSortedLeftList()
        val rightLocationIds = input.toSortedRightList()
        return leftLocationIds.sumOf { a -> rightLocationIds.count { it == a } * a }
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

fun List<String>.toSortedLeftList() = map { it.substringBefore(" ").toInt() }.sorted()
fun List<String>.toSortedRightList() = map { it.substringAfterLast(" ").toInt() }.sorted()