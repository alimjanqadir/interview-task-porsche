package com.example.interviewquestion.algo


class Solution {
    fun sort(files: Array<String>): List<String> {
        return files.sortedWith { a, b ->
            val aSegmentedList = segmentToDigitsAndChars(a)
            val bSegmentedList = segmentToDigitsAndChars(b)
            var i = 0
            var result = 0
            while (i < aSegmentedList.size && i < bSegmentedList.size) {
                result = aSegmentedList[i] - bSegmentedList[i]
                i += 1
                if (result < 0 || result > 0) break
            }

            if (result == 0) {
                result = a.length - b.length
            }

            result
        }
    }

    private fun segmentToDigitsAndChars(input: String): List<Int> {
        val result = mutableListOf<Int>()
        var digits = StringBuilder()
        var chars = StringBuilder()
        var previousChar: Char? = null
        for (i in input.indices) {
            val ch = input[i]
            if (ch.isDigit()) {
                digits.append(Character.digit(ch, 10))

                if (previousChar != null && !(previousChar.isDigit())) {
                    chars.forEach {
                        result.add(it.code)
                    }
                    chars = StringBuilder()
                }
                previousChar = ch
            } else {
                chars.append(ch)

                if (previousChar != null && previousChar.isDigit()) {
                    result.add(digits.toString().toInt())
                    digits = StringBuilder()
                }
                previousChar = ch
            }

            if (i == input.length - 1) {
                if (digits.isNotEmpty()) {
                    result.add(digits.toString().toInt())
                }

                if (chars.isNotEmpty()) {
                    chars.forEach {
                        result.add(it.code)
                    }
                }
            }
        }
        return result
    }
}

fun main() {
    val input = arrayOf(
        "file2.gif",
        "file01.gif",
        "1file.jpg",
        "1file.gif",
        "file10.gif",
        "file1.gif",
        "file1a.gif"
    )

    val solution = Solution()
    val output = solution.sort(input)
    println(output)
}


