package com.example.algo


class Solution {
    fun sort(files: Array<String>): Array<String> {
        require(files.isNotEmpty())

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

            /* After segmenting original size would change, because of combing the numerics as a unit
            * in that case the comparison would based the length before segmentation.
            *
            * For example:
            * file1 and file00001 going changed to same segment size and every segment matches
            * the same as well, in that case original size is going to be used for comparison,
            * in this case file1 < file00001
            * */
            if (result == 0) {
                result = a.length - b.length
            }

            result
        }.toTypedArray()
    }

    private fun segmentToDigitsAndChars(input: String): List<Int> {
        val result = mutableListOf<Int>()
        var digits = StringBuilder()
        var chars = StringBuilder()
        var previousChar: Char? = null // Previous char used for detecting sequence change
        for (i in input.indices) {
            val ch = input[i]
            if (ch.isDigit()) { // Segment digits
                digits.append(Character.digit(ch, 10))

                /* When sequence change from letters to numbers, it adds gathered letters to
                * the result list
                * **/
                if (isSequenceChangedToNumber(previousChar)) {
                    chars.forEach {
                        result.add(it.code)
                    }
                    chars = StringBuilder()
                }
                previousChar = ch
            } else {  // Segment letters
                chars.append(ch)
                /* Symmetric operation, when sequence change from numbers to letter, it combine
                 * gathered letters and adds to the result list
                 * **/
                if (isSequenceChangedToLetter(previousChar)) {
                    result.add(digits.toString().toInt())
                    digits = StringBuilder()
                }
                previousChar = ch
            }

            // Adds last remaining numbers and letters
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

    private fun isSequenceChangedToLetter(previousChar: Char?) =
        previousChar != null && previousChar.isDigit()

    private fun isSequenceChangedToNumber(previousChar: Char?) =
        previousChar != null && !(previousChar.isDigit())
}
