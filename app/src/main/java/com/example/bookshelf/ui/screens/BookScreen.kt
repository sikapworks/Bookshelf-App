@file:JvmName("BookScreenKt")

package com.example.bookshelf.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookshelf.ui.components.BookGrid
import com.example.bookshelf.ui.state.BookUiState
import com.example.bookshelf.ui.viewmodel.BookViewModel

@Composable
fun BookScreen(
    viewModel: BookViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.bookUiState.collectAsState()

    when (uiState) {
        is BookUiState.Loading -> {
            LoadingScreen()
        }

        is BookUiState.Error -> {
            val message = (uiState as BookUiState.Error).message
            ErrorScreen(message)
        }

        is BookUiState.Success -> {
            val books = (uiState as BookUiState.Success).books
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {
                BookGrid(books)
            }
        }
    }
}