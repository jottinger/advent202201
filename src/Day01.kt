data class Elf(val calories: List<Int>) {
    fun totalCalories(): Int {
        return calories.sum()
    }

    override fun toString(): String {
        return calories.toString()+" (total: "+totalCalories()+")"
    }
}

fun main() {
    val mode = "actual"

    fun convertToElves(input: List<String>): List<Elf> {
        val elves: MutableList<Elf> = mutableListOf()
        val calories: MutableList<Int> = mutableListOf()
        input.stream().forEach {
            if (it.trim() == "") {
                elves += Elf(calories.toList())
                calories.clear()
            } else {
                calories+=it.trim().toInt()
            }
        }
        return elves
    }

    fun part1(input: List<Elf>): Int {
        return input
            .map { it.totalCalories() }
            .maxOf { it }
    }

    fun part2(input: List<Elf>): Int {
        return input
            .map { it.totalCalories() }
            .sorted()
            .reversed()
            .subList(0,3)
            .sum()
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput(mode)
//    check(part1(testInput) == 1)

    val input = readInput(mode)
    val elves= convertToElves(input)

    println("the calories from the top elf        : "+part1(elves))
    println("the calories from the top three elves: "+part2(elves))
}
