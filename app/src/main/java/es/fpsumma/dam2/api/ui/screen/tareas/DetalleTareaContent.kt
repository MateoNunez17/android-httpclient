package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleTareaContent(
    tarea: String,
    onBack: () -> Unit,
    onSave: (titulo: String, descripcion: String) -> Unit
) {

    val tareaFlow = remember(id) { vm.getTarea(id) }
    val tarea by tareaFlow.collectAsStateWithLifecycle(initialValue = null)
}

