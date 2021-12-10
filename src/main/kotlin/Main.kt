import kotlin.random.Random

/**
 * @author Emmanuel Duchastenier
 */
fun main() {
    val diceDraws = Array(4) { rollDice() }
    print(diceDraws.joinToString(postfix = " => ") { it.value.toString() })
    val possiblePairs = makePossiblePairs(diceDraws)
    println(possiblePairs)
}

fun makePossiblePairs(diceDraws: Array<DiceDraw>): MutableSet<Pair<Int, Int>> {
    val pairs = hashSetOf<Pair<Int, Int>>()
    val totalSum = diceDraws.sumBy { dice -> dice.value }
    for (i in 0..2) {
        val first = diceDraws[0].value + diceDraws[i + 1].value // associate the first one with each of other 3
        pairs.add(Pair(first, totalSum - first)) // so the other possible pair is the sum of the other 2
    }
    return pairs
}

fun rollDice() = DiceDraw()

fun getRandom(): Int = Random.Default.nextInt(1, 7)

data class DiceDraw(val value: Int = getRandom())
