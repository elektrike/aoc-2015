fun main() {
    data class Floor(val current: Int, val instructionPos: Int) {
        fun goUp(): Floor = this.copy(current = current + 1, instructionPos = instructionPos + 1)
        fun goDown(): Floor = this.copy(current = current - 1, instructionPos = instructionPos + 1)
    }

    fun walk(instruction: Char, floor: Floor): Floor =
        when (instruction) {
            '(' -> floor.goUp()
            ')' -> floor.goDown()
            else -> floor
        }

    fun part1(input: List<String>): Int {
        tailrec fun followInstructions(instructions: CharArray, floor: Floor): Int =
            if (instructions.isEmpty())
                floor.current
            else
                followInstructions(instructions.drop(1).toCharArray(), walk(instructions.first(), floor))

        return followInstructions(input.first().toCharArray(), Floor(0, 0))
    }

    fun part2(input: List<String>): Int {
        tailrec fun goToBasement(instructions: CharArray, floor: Floor): Int =
            if (floor.current == -1)
                floor.instructionPos
            else
                goToBasement(instructions.drop(1).toCharArray(), walk(instructions.first(), floor))

        return goToBasement(input.first().toCharArray(), Floor(0, 0))
    }
}
