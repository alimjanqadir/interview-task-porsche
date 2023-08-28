package com.example.algo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class FileSortTest {

    private lateinit var solution: Solution

    @BeforeEach
    fun setUp() {
        solution = Solution()
    }

    @Test
    fun sort_succeed_withFirstInput() {
        val input = arrayOf(
            "file2.gif",
            "file01.gif",
            "1file.jpg",
            "1file.gif",
            "file10.gif",
            "file1.gif",
            "file1a.gif"
        )
        val expected = arrayOf(
            "1file.gif",
            "1file.jpg",
            "file1.gif",
            "file01.gif",
            "file1a.gif",
            "file2.gif",
            "file10.gif"
        )

        val actual = solution.sort(input)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sort_succeed_withSecondInput() {
        val input = arrayOf(
            "1file.png",
            "file10.gif",
            "file2.gif",
        )
        val expected = arrayOf(
            "1file.png",
            "file2.gif",
            "file10.gif",
        )

        val actual = solution.sort(input)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sort_willFail_withEmptyInput() {
        val input = emptyArray<String>()
        assertFailsWith(IllegalArgumentException::class) {
            solution.sort(input)
        }
    }
}