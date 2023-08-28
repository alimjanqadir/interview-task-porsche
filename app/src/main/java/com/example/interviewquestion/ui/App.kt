package com.example.interviewquestion.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.interviewquestion.MainActivityViewModel
import com.example.interviewquestion.ui.theme.InterviewQuestionTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun App(mainActivityViewModel: MainActivityViewModel = koinViewModel()) {
    /* Collecting flows in compose is extremely easy compare to activity
     * This StateFlow is collected every time the lifecycleOwner's lifecycle reaches the
     * minActiveState Lifecycle state. The collection stops when the lifecycleOwner's
     * lifecycle falls below minActiveState, which is Lifecycle.State.STARTED,
     * look at this diagram .
     */
    val models by mainActivityViewModel.models.collectAsStateWithLifecycle()
    ModelList(models)
}

@Composable
fun ModelList(models: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .semantics { testTag = "ModelList" }) {
        items(models) {
            ListItem(it)
        }
    }
}

@Composable
fun ListItem(item: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = item)
    }
}

@Preview
@Composable
fun ModelListPreview() {
    InterviewQuestionTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            ModelList(listOf("A", "B", "C"))
        }
    }
}