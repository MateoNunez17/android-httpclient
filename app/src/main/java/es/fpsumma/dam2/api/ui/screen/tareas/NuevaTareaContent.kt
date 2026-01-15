package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun NuevaTareaContent(
    onBack: () -> Unit,
    onSave: (titulo: String, descripcion: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val (titulo, setTitulo) = remember { mutableStateOf("") }
    val (descripcion, setDescripcion) = remember { mutableStateOf("") }


}