package com.example.interviewquestion

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.interviewquestion.ui.App
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class AppTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun app_loaded_success() = runTest {
        composeTestRule.setContent {
            App()
        }

        composeTestRule
            .onRoot()
            .printToLog("App")

        composeTestRule
            .onNodeWithTag("ModelList")
            .assertIsDisplayed()
            .assert(hasAnyChild(hasText("A")))
            .assert(hasAnyChild(hasText("B")))
            .assert(hasAnyChild(hasText("C")))
    }
}