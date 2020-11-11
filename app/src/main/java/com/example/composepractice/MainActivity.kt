package com.example.composepractice

import android.os.Bundle
import android.view.ViewDebug
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ScopeUpdateScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.composepractice.ui.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Greeting(name = "Android")
            }
        }
    }
}

private val DarkColors = darkColors(
        primary = purple200,
        primaryVariant = purple700,
        secondary = teal200
)

private val LightColors = lightColors(
        primary = purple500,
        primaryVariant = purple700,
        secondary = teal200
)
@Composable
fun MyAppTheme(content: @Composable () -> Unit){
    val colors = if (darkTheme){
        DarkColors
    }else{
        LightColors
    }

    MaterialTheme(colors = colors) {
        content()
    }
}

@Composable
fun Greeting(name: String){
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp), style = MaterialTheme.typography.h1)
}
@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposePracticeTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}
@Composable
fun MyScreenContent(names:List<String> = listOf("Android","there")){
    val counterState = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            for (name in names){
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}
@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        Greeting(name = "Android")
    }
}
@Composable
fun Counter(count: Int,updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text("I've been clicked $count times")
    }
}