import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@Composable
fun FritzUI() {
    val framework by mutableStateOf("Compose Multiplatform")

    // Card
    Div(attrs = { classes("max-w-2xl", "mx-auto", "sm:px-6", "lg:px-8", "py-12") }) {
        Div(attrs = { classes("overflow-hidden", "shadow-md") }) {
            // Card Header
            Div(attrs = { classes("px-6", "py-4", "text-white", "bg-sky-700", "border-b", "border-gray-200", "font-bold", "uppercase") }) {
                Text("Which web-framework do you use?")
            }

            // Card Body
            Div(attrs = { classes("p-6", "bg-white") }) {
                Text("I'm using: $framework")
            }
        }
    }
}