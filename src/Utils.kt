import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

// Split a string on a given delimiter and convert to longs
fun String.splitToLongs(delimiter: String = " ") = split(delimiter).map { it.toLong() }

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
