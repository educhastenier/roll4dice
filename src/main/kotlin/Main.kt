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

fun makePossiblePairs(diceDraws: Array<DiceDraw>): MutableSet<PossiblePair> {
    val pairs = hashSetOf<PossiblePair>()
    val totalSum = diceDraws.sumBy { i -> i.value }
    for (i in 0..2) {
        val first = diceDraws[0].value + diceDraws[i + 1].value // associate the first one with each of other 3
        pairs.add(PossiblePair(first, totalSum - first)) // so the other possible pair is the sum of the other 2
    }
    return pairs
}

fun rollDice(): DiceDraw = DiceDraw(getRandom())

fun getRandom(): Int = Random.Default.nextInt(1, 7)

data class DiceDraw(val value: Int)
data class PossiblePair(val n1: Int, val n2: Int) {

    override fun toString(): String {
        return "$n1 AND $n2"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is PossiblePair)
            n1 == other.n1 && n2 == other.n2 || n1 == other.n2 && n2 == other.n1
        else super.equals(other)
    }

    override fun hashCode() = n1 + n2
}
