import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

// This stylesheet declares rules for Counter components, and it uses AppStyleSheet as rules holder
object CounterStyleSheet : StyleSheet(AppStyleSheet) {
    val counterText by style {
        padding(15.px)
        color(Color.red)
    }
}

@Composable
fun CounterText(count: Int) {
    Span({ classes(CounterStyleSheet.counterText) }) {
        Text("$count")
    }
}

@Composable
fun CounterButton(text: String, onButtonClick: () -> Unit) {
    Button(attrs = {
        onClick { onButtonClick() }
    }) {
        Text(text)
    }
}

@Composable
fun SimpleCounter(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Div {
        CounterButton(text = "-", onDecrement)
        CounterText(count)
        CounterButton(text = "+", onIncrement)
    }
}


@Composable
fun CounterDeltaRange(currentDelta: Int, onChange: (Int) -> Unit) {
    Div({
        style {
            marginTop(15.px)
        }
    }) {
        RangeInput(value = currentDelta, min = 1, max = 10, step = 1) {
            onInput { onChange((it.value ?: 1).toInt()) }
        }
        Span({
            style { padding(5.px) }
        }) {
            Text("$currentDelta")
        }
    }
}
