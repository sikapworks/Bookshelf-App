package com.example.bookshelf.ui.state

import com.example.bookshelf.data.model.VolumeItem

sealed interface BookUiState {
    data object Loading: BookUiState
    data class Success(val books: List<VolumeItem>): BookUiState
    data class Error(val message: String): BookUiState
}