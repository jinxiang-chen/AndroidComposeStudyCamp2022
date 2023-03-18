package fu.trainnin.happybirthday

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fu.trainnin.happybirthday.ui.theme.HappyBirthdayTheme


@Composable
fun TaskManagerScreen(
    image: Painter,
    text1: String,
    text2: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
//                .wrapContentHeight()
//                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        )
        Text(text = text1, fontSize = 24.sp, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        Text(
            text = text2,
            fontSize = 16.sp
        )
    }
}


@Preview(showBackground = true, widthDp = 500, heightDp = 500)
@Composable
fun TaskManagerPreview() {
    HappyBirthdayTheme {
        TaskManagerScreen(
            image = painterResource(id = R.drawable.ic_task_completed),
            text1 = "All tasks completed",
            text2 = "Nice work!",
        )
    }
}