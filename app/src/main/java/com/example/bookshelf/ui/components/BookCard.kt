package com.example.bookshelf.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.data.model.ImageLinks
import com.example.bookshelf.data.model.VolumeInfo
import com.example.bookshelf.data.model.VolumeItem

@Composable
fun BookCard(
    book: VolumeItem,
    modifier: Modifier = Modifier
) {
    // android context object, a bridge to android system
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(8.dp)
    ) {
        val imageUrl = book.volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://")


        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = book.volumeInfo.title,
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.error_placeholder),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(0.7f)
        )
        Text(
            text = book.volumeInfo.title,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            modifier = modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
fun BookCardPreview() {
    val sample = VolumeItem(
        id = "1",
        volumeInfo = VolumeInfo(
            title = "Heading",
            imageLinks = ImageLinks(
                thumbnail = "https://books.google.com/books/content?id=zyTCAlFPjgYC&printsec=frontcover&img=1&zoom=1"
            )
        )
    )
    BookCard(book = sample)
}