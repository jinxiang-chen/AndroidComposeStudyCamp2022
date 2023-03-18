package fu.trainnin.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fu.trainnin.superheroes.model.Hero
import fu.trainnin.superheroes.model.HeroesRepository
import fu.trainnin.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperheroesApp() {
    val heroes by remember {
        mutableStateOf(HeroesRepository.heroes)
    }
    Scaffold(
        topBar = {
            SuperheroesAppTopBar()
        }
    ) {
        HeroItems(heroes = heroes)
    }
}

@Composable
fun HeroItems(heroes: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(heroes) {
            HeroItem(hero = it)
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
            .sizeIn(minHeight = 72.dp),
        elevation = 2.dp
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(end = 16.dp).weight(1f)
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(Modifier.width(16.dp))
            Image(
                modifier = Modifier.size(72.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = hero.imageRes),
                alignment = Alignment.TopCenter,
                contentDescription = stringResource(id = hero.descriptionRes),
            )
        }
    }
}

@Composable
fun SuperheroesAppTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperheroesTheme {
        SuperheroesApp()
    }
}


@Preview
@Composable
fun DarkThemePreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroesApp()
    }
}
