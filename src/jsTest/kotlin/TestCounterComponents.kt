import org.jetbrains.compose.web.testutils.ComposeWebExperimentalTestsApi
import org.jetbrains.compose.web.testutils.runTest
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.w3c.dom.HTMLButtonElement
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ComposeWebExperimentalTestsApi::class)
class TestCounterComponents {

    @Test
    fun testButton() = runTest {
        var counter by mutableStateOf(1)
        composition {
            CounterButton(text = "$counter") {
                counter++
            }
        }

        assertEquals("<button>1</button>", root.innerHTML)

        (root.firstChild!! as HTMLButtonElement).click()
        waitForRecompositionComplete()
        assertEquals("<button>2</button>", root.innerHTML)

        counter = 10
        waitForRecompositionComplete()
        assertEquals("<button>10</button>", root.innerHTML)
    }
}
