package com.example.bookshelf

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.bookshelf.data.network.BookshelfApi
import com.example.bookshelf.data.repository.BookshelfRepository
import com.example.bookshelf.ui.screens.BookScreen
import com.example.bookshelf.ui.viewmodel.BookViewModel
import com.example.compose.BookshelfTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create APi service and repository manually
        val apiService = BookshelfApi.retrofitService
        val repository = BookshelfRepository(apiService)

        // Create ViewModel manually (when not using Hilt)
        val viewModel = BookViewModel(repository)

        setContent {
            BookshelfTheme(
                darkTheme = isSystemInDarkTheme(), // this enables dark/light switch automatically
                dynamicColor = false
            ) {
                BookScreen(viewModel)
            }
        }
    }
}

