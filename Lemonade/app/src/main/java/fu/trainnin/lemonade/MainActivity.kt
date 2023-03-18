package fu.trainnin.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fu.trainnin.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonStep(title: Int, contentDescription: Int, contentImage: Int, onClick: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = stringResource(title), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(contentImage),
            contentDescription = stringResource(contentDescription),
            modifier = Modifier
                .wrapContentSize()
                .border(width = 2.dp, color = Color(105,205,216),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
                .clickable {
                    onClick()
                }
        )
    }
}

@Composable
fun LemonApp() {
    var step by remember { mutableStateOf(1) }
    val title = when(step) {
        1 -> {
            R.string.title1
        }
        2 -> {
            R.string.title2
        }
        3 -> {
            R.string.title3
        }
        4 -> {
            R.string.title4
        }
        else -> {
            R.string.title1
        }
    }
    val content = when(step) {
        1 -> {
            R.string.content1
        }
        2 -> {
            R.string.content2
        }
        3 -> {
            R.string.content3
        }
        4 -> {
            R.string.content4
        }
        else -> {
            R.string.content1
        }
    }
    val image = when(step) {
        1 -> {
            R.drawable.lemon_tree
        }
        2 -> {
            R.drawable.lemon_squeeze
        }
        3 -> {
            R.drawable.lemon_drink
        }
        4 -> {
            R.drawable.lemon_restart
        }
        else -> {
            R.drawable.lemon_tree
        }
    }
    var squeeze by remember { mutableStateOf((2..4).random()) }
    LemonStep(title, content, image, onClick = {
        when(step) {
            1 -> {
                step = 2
            }
            2 -> {
                if (squeeze in (2..4)) {
                    squeeze++
                } else {
                    step = 3
                }
            }
            3 -> {
                step = 4
            }
            4 -> {
                step = 1
                squeeze = (2..4).random()
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}