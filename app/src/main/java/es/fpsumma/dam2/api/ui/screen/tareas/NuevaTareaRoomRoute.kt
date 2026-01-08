package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@Composable
fun NuevaTareaRoomRoute(
    navController: NavController,
    vm: TareasViewModel
) {
    NuevaTareaContent(

        // conectamos onBack con popBackStack.
        onBack = { navController.popBackStack() },
        //llamamos al viewModel para poder añadir una tarea.
        onSave = { titulo, descripcion -> vm.addTarea(titulo, descripcion)

            //para navegar al listado.
            navController.navigate("TAREAS_LISTADO") {
            }
        }
    )
}
