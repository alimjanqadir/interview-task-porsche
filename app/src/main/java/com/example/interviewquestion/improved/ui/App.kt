package com.example.interviewquestion.improved.ui

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.interviewquestion.improved.MainActivityViewModel
import com.example.interviewquestion.improved.ui.theme.InterviewQuestionTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun App(mainActivityViewModel: MainActivityViewModel = koinViewModel()) {
    val models by mainActivityViewModel.models.collectAsStateWithLifecycle()
    ModelList(models)
}

@Composable
fun ModelList(models: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(models) {
            ListItem(it)
        }
    }
}

@Composable
fun ListItem(item: String, modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(), horizontalArrangement =
        Arrangement.Center
    ) {
        Text(text = item)
    }
}

@Preview
@Composable
fun ModelListPreview() {
    InterviewQuestionTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ModelList(listOf("A", "B", "C"))
        }
    }
}