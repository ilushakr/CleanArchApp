package com.example.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.feature.main.theme.CleanArchAppTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val textId by viewModel.state.collectAsState()

            CleanArchAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Button(onClick = {
                            viewModel.getSomeData()
                        }) {
                            Text(text = textId.id)
                        }
                    }
                }
            }
        }
    }
}