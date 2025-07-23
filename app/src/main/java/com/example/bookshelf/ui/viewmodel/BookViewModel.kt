package com.example.bookshelf.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.data.model.VolumeItem
import com.example.bookshelf.data.repository.BookshelfRepository
import com.example.bookshelf.ui.state.BookUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(
    private val repository: BookshelfRepository
) : ViewModel() {

    private val _bookUiState = MutableStateFlow<BookUiState>(BookUiState.Loading)
    val bookUiState: StateFlow<BookUiState> = _bookUiState

    init {
        getBooks("android")
    }

    private fun getBooks(query: String) {
        _bookUiState.value = BookUiState.Loading

        viewModelScope.launch {
            try {
                val response = repository.getBooks(query)
                _bookUiState.value = BookUiState.Success(response.items)
            } catch (e: Exception) {
                _bookUiState.value = BookUiState.Error("Error occurred: ${e.message}")
            }
        }
    }
}
