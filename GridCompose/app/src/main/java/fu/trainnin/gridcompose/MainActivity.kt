@file:OptIn(ExperimentalFoundationApi::class)

package fu.trainnin.gridcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fu.trainnin.gridcompose.data.DataSource
import fu.trainnin.gridcompose.data.Topic
import fu.trainnin.gridcompose.ui.theme.GridComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    TopicScreen()
                }
            }
        }
    }
}

@Composable
fun TopicScreen() {
    val dataSource = DataSource.topics
    TopicList(dataSource)
}

@Composable
fun TopicList(dataSource: List<Topic>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(dataSource) { topic ->
            Topic(title = topic.title, count = topic.likeCount, drawable = topic.drawable)
        }
    }
}

@Composable
fun Topic(
    @StringRes title: Int, count: Int, @DrawableRes drawable: Int
) {
    Row {
        Image(
            modifier = Modifier.size(68.dp),
            painter = painterResource(drawable),
            contentDescription = stringResource(id = title)
        )
        Column(
        
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                text = stringResource(id = title),
                style = MaterialTheme.typography.body2
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.padding(start = 16.dp),
                    painter = painterResource(id = R.drawable.ic_grain),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
                    text = count.toString(),
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridComposeTheme {
        TopicScreen()
    }
}