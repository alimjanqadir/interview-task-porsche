package com.example.interviewquestion.original

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.original.ApiClient
import com.example.original.MyApplicationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    // Data layer constructs all coupled with Activity)
    var apiClient: ApiClient = get()
    var msf: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    showModelList()
                }
            }
        }

        /* Not Scope safe
        * A global CoroutineScope not bound to any job.
        * Global scope is used to launch top-level coroutines which are operating on the whole
        * application lifetime and are not cancelled prematurely.
        * */
        GlobalScope.launch {
            apiClient
                .fetchModels()
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.e("MainViewModel", "Failed to get list of car models.")
                }
                .collect {
                    msf.value = it
                }
        }
    }

    /*
    * Wrong coding Convention, and UI bounded to Activity, seperation is needed.
    * modifier paramenter is also not used.
    * */
    @Composable
    fun showModelList(modifier: Modifier = Modifier) {
        val l = msf.collectAsState().value
        LazyColumn(Modifier.fillMaxSize()) {
            items(l) {
                ListItem(it)
            }
        }
    }

    /*
    * UI bounded to Activity, seperation is needed.
    * */
    @Composable
    fun ListItem(item: String, modifier: Modifier = Modifier) {
        Row(
            modifier.fillMaxWidth(), horizontalArrangement =
            Arrangement.Center
        ) {
            Text(text = item)
        }
    }
}
