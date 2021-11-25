import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable


fun main() {
    var count: Int by mutableStateOf(0)
    var delta: Int by mutableStateOf(1)

    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)

        Div({ classes(AppStyleSheet.container) }) {
            SimpleCounter(
                count = count,
                onIncrement = { count += delta },
                onDecrement = { count -= delta }
            )

            CounterDeltaRange(
                currentDelta = delta,
                onChange = {
                    delta = it
                }
            )
        }
    }
}

