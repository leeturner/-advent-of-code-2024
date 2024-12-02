import kotlin.math.abs

fun main() {
  fun part1(input: List<String>): Int {
    return input.map { line -> line.splitToLongs() }
      .count { report -> (report.isAllIncreasing() || report.isAllDecreasing()) && report.levelsDifferWithinSafeRange() }
  }

  fun part2(input: List<String>): Int {
    return input.map { line -> line.splitToLongs() }
      .count { report ->
        ((report.isAllIncreasing() || report.isAllDecreasing()) && report.levelsDifferWithinSafeRange()) ||
            report.indices.any { i ->
              val reportWithOmittedLevel = report.take(i) + report.drop(i + 1)
              (reportWithOmittedLevel.isAllIncreasing() || reportWithOmittedLevel.isAllDecreasing()) 
                  && reportWithOmittedLevel.levelsDifferWithinSafeRange()
            }
      }
  }

  val testInput = readInput("Day02_test")
  check(part1(testInput) == 2)
  check(part2(testInput) == 4)

  val input = readInput("Day02")
  part1(input).println()
  part2(input).println()
}

fun List<Long>.isAllIncreasing() = this == this.sorted()
fun List<Long>.isAllDecreasing() = this == this.sorted().reversed()
fun List<Long>.levelsDifferWithinSafeRange() = windowed(2).all { (first, second) -> abs(first - second) in 1..3 }