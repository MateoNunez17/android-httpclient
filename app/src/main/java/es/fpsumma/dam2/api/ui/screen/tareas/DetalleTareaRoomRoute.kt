package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import es.fpsumma.dam2.api.viewmodel.TareasViewModel
import es.fpsumma.dam2.api.model.Tarea

@Composable
fun DetalleTareaRoomRoute(
    id: Int,
    navController: NavController,
    vm: TareasViewModel
) {
    val tareaEntity by vm.getTarea(id).collectAsStateWithLifecycle(initialValue = null)

    val tarea = tareaEntity?.let { Tarea(it.id, it.titulo, it.descripcion) }

    DetalleTareaContent(
        tarea = tarea,
        onBack = { navController.popBackStack() },
        onSave = { titulo, descripcion ->
            vm.updateTarea(id, titulo, descripcion)
            navController.popBackStack()
        }
    )
}