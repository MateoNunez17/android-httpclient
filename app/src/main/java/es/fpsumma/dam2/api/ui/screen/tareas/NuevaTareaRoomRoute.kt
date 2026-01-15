package es.fpsumma.dam2.api.ui.screen.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaTareaRoomRoute(
    navController: NavController,
    vm: TareasViewModel
) {
    NuevaTareaContent(
        onBack = { navController.popBackStack() },
        onSave = { titulo, descripcion ->
            vm.addTarea(titulo, descripcion)
            navController.navigate(Routes.TAREA_LISTADO) {
                popUpTo(Routes.TAREA_LISTADO) { inclusive = true }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaTareaContent(
    onBack: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nueva Tarea") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Button(
                onClick = {
                    if (titulo.isNotBlank()) {
                        onSave(titulo, descripcion)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = titulo.isNotBlank()
            ) {
                Text("Añadir nota")
            }
        }
    }
}