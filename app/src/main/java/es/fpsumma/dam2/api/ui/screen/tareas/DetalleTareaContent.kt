package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import es.fpsumma.dam2.api.model.Tarea

@Composable
fun DetalleTareaContent(
    tarea: Tarea?,
    onBack: () -> Unit,
    onSave: (String, String) -> Unit,
) {
    if (tarea == null) {
        Column {
            Text(text = "Cargando...")
        }
    } 
}