package fu.trainnin.happybirthday

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fu.trainnin.happybirthday.ui.theme.HappyBirthdayTheme

@Composable
fun ComposeQuadrantScreen(
    title1: String,
    content1: String,
    title2: String,
    content2: String,
    title3: String,
    content3: String,
    title4: String,
    content4: String
) {
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(title = title1, content = content1, background = Color.Green, modifier = Modifier.weight(1f))
            Quadrant(title = title2, content = content2, background = Color.Yellow, modifier = Modifier.weight(1f))
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(title = title3, content = content3, background = Color.Cyan, modifier = Modifier.weight(1f))
            Quadrant(title = title4, content = content4, background = Color.LightGray, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun Quadrant(title: String, content: String, background: Color, modifier: Modifier = Modifier) {
    Surface(
        color = background,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 16.dp)
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
    }
}


@Preview(showBackground = true, heightDp = 600, widthDp = 400)
@Composable
fun ComposeQuadrantPreview() {
    HappyBirthdayTheme {
        ComposeQuadrantScreen(
            title1 = "Text composable",
            content1 = "Displays text and follows Material Design guidelines.",
            title2 = "Image composable",
            content2 = "Creates a composable that lays out and draws a given Painter class object.",
            title3 = "Row composable",
            content3 = "A layout composable that places its children in a horizontal sequence.",
            title4 = "Column composable",
            content4 = "A layout composable that places its children in a vertical sequence."
        )
    }
}