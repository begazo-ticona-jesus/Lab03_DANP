package com.example.lab03

import android.os.Bundle
import android.service.quicksettings.Tile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

class Asistente{
    var nombre: String = ""
    var apellidos: String = ""
    var fecha_inscripcion: String = ""
    var tipo_sangre: String = ""
    var telefono: String = ""
    var correo: String = ""
    var monto_pagado: String = ""
    constructor(Nombre:String,
                  Apellidos:String,
                  FechaInscripcion:String,
                  Tiposangre:String,
                  Telefono:String,
                  Correo:String,
                  MontoPagado:String){
        nombre = Nombre
        apellidos = Apellidos
        fecha_inscripcion = FechaInscripcion
        tipo_sangre = Tiposangre
        telefono = Telefono
        correo = Correo
        monto_pagado = MontoPagado
    }
}
val Asistentes: HashMap<String, Asistente> = HashMap()

@Preview(showBackground = true)
@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Menu.route) {
        composable(Screen.Menu.route) { ScreenMenu(navController) }
        composable(Screen.Registro.route) { ScreenRegistro(navController) }
        composable(Screen.Modificacion.route) { ScreenModificacion(navController) }
        composable(Screen.Visualizacion.route) { ScreenVisualizacion(navController) }
    }
}

@Composable
fun ScreenMenu(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Menu de asistentes",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = {
            navController.navigate(Screen.Registro.route)
            },
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text("Registrar asistente")
        }
        Button(onClick = {
            navController.navigate(Screen.Modificacion.route)
            },
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text("Modificar asistente")
        }
        Button(onClick = {
            navController.navigate(Screen.Visualizacion.route)
            },
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text("Visualizar asistentes")
        }
    }
}

@Composable
fun ScreenRegistro(navController: NavController) {
    TopAppBar(
        backgroundColor = Color.DarkGray,
    ) {
        IconButton(onClick = {
            navController.navigate(Screen.Menu.route)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_retroceso),
                contentDescription = "Retroceder",
                tint = Color.White
            )
        }
        Text(
            text = "Registrar asistente",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var nombre by remember { mutableStateOf(TextFieldValue("")) }
        var apellidos by remember { mutableStateOf(TextFieldValue("")) }
        var fecInscripcion by remember { mutableStateOf(TextFieldValue("")) }
        var tipoSangre by remember { mutableStateOf(TextFieldValue("")) }
        var telefono by remember { mutableStateOf(TextFieldValue("")) }
        var correo by remember { mutableStateOf(TextFieldValue("")) }
        var monto by remember { mutableStateOf(TextFieldValue("")) }


        var expanded by remember { mutableStateOf(false) }
        var selectedItem by remember { mutableStateOf("Opción 1") }
        Text(text = "Seleccionado: $selectedItem")
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                selectedItem = "Opción 1"
                expanded = false
            }) {
                Text(text = "Opción 1")
            }
            DropdownMenuItem(onClick = {
                selectedItem = "Opción 2"
                expanded = false
            }) {
                Text(text = "Opción 2")
            }
            DropdownMenuItem(onClick = {
                selectedItem = "Opción 3"
                expanded = false
            }) {
                Text(text = "Opción 3")
            }
        }

        TextField(
            modifier = Modifier.padding(3.dp),
            value = nombre,
            onValueChange = { newText ->
                nombre = newText
            },
            label = { Text(text = "Nombres") },
            placeholder = { Text(text = "Nombres") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = apellidos,
            onValueChange = { newText ->
                apellidos = newText
            },
            label = { Text(text = "Apellidos") },
            placeholder = { Text(text = "Apellidos") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = fecInscripcion,
            onValueChange = { newText ->
                fecInscripcion = newText
            },
            label = { Text(text = "Fecha de Inscripcion") },
            placeholder = { Text(text = "Fecha de Inscripcion") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = tipoSangre,
            onValueChange = { newText ->
                tipoSangre = newText
            },
            label = { Text(text = "Tipo de Sangre") },
            placeholder = { Text(text = "Tipo de Sangre") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = telefono,
            onValueChange = { newText ->
                telefono = newText
            },
            label = { Text(text = "Telefono") },
            placeholder = { Text(text = "Telefono") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = correo,
            onValueChange = { newText ->
                correo = newText
            },
            label = { Text(text = "Correo") },
            placeholder = { Text(text = "Correo") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = monto,
            onValueChange = { newText ->
                monto = newText
            },
            label = { Text(text = "Monto pagado") },
            placeholder = { Text(text = "Monto pagado") }
        )
        Button(onClick = {
            var nuevo = Asistente(
                nombre.text,
                apellidos.text,
                fecInscripcion.text,
                tipoSangre.text,
                telefono.text,
                correo.text,
                monto.text
                )
            Asistentes.put(nuevo.nombre,nuevo)
            navController.navigate(Screen.Visualizacion.route)
        }) {
            Text("Registrar")
        }
    }
}

@Composable
fun ScreenModificacion(navController: NavController) {
    TopAppBar(
        backgroundColor = Color.DarkGray,
    ) {
        IconButton(onClick = {
            navController.navigate(Screen.Menu.route)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_retroceso),
                contentDescription = "Retroceder",
                tint = Color.White
            )
        }
        Text(
            text = "Modificar asistente",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var dato by remember { mutableStateOf(TextFieldValue("")) }
        var nombre by remember { mutableStateOf(TextFieldValue("")) }
        var apellidos by remember { mutableStateOf(TextFieldValue("")) }
        var fecInscripcion by remember { mutableStateOf(TextFieldValue("")) }
        var tipoSangre by remember { mutableStateOf(TextFieldValue("")) }
        var telefono by remember { mutableStateOf(TextFieldValue("")) }
        var correo by remember { mutableStateOf(TextFieldValue("")) }
        var monto by remember { mutableStateOf(TextFieldValue("")) }

        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            TextField(
                modifier = Modifier.padding(10.dp),
                value = dato,
                onValueChange = { newText ->
                    dato = newText
                },
                label = { Text(text = "Ingrese nombre a buscar") },
                placeholder = { Text(text = "Buscar") }
            )
            Button(
                onClick = {
                    var clave = dato.text
                    val asistente = Asistentes[clave]
                    if (asistente != null) {
                        nombre = TextFieldValue(asistente.nombre)
                        apellidos = TextFieldValue(asistente.apellidos)
                        fecInscripcion = TextFieldValue(asistente.fecha_inscripcion)
                        tipoSangre = TextFieldValue(asistente.tipo_sangre)
                        telefono = TextFieldValue(asistente.telefono)
                        correo = TextFieldValue(asistente.correo)
                        monto = TextFieldValue(asistente.monto_pagado)
                    } else {
                        println("No se encontró un valor para clave2")
                    }
                }
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Buscar",
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        TextField(
            modifier = Modifier.padding(3.dp),
            value = nombre,
            onValueChange = { newText ->
                nombre = newText
            },
            label = { Text(text = "Nombres") },
            placeholder = { Text(text = "Nombres") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = apellidos,
            onValueChange = { newText ->
                apellidos = newText
            },
            label = { Text(text = "Apellidos") },
            placeholder = { Text(text = "Apellidos") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = fecInscripcion,
            onValueChange = { newText ->
                fecInscripcion = newText
            },
            label = { Text(text = "Fecha de Inscripcion") },
            placeholder = { Text(text = "Fecha de Inscripcion") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = tipoSangre,
            onValueChange = { newText ->
                tipoSangre = newText
            },
            label = { Text(text = "Tipo de Sangre") },
            placeholder = { Text(text = "Tipo de Sangre") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = telefono,
            onValueChange = { newText ->
                telefono = newText
            },
            label = { Text(text = "Telefono") },
            placeholder = { Text(text = "Telefono") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = correo,
            onValueChange = { newText ->
                correo = newText
            },
            label = { Text(text = "Correo") },
            placeholder = { Text(text = "Correo") }
        )
        TextField(
            modifier = Modifier.padding(3.dp),
            value = monto,
            onValueChange = { newText ->
                monto = newText
            },
            label = { Text(text = "Monto pagado") },
            placeholder = { Text(text = "Monto pagado") }
        )
        Button(onClick = {
            navController.navigate(Screen.Visualizacion.route)
        }) {
            Text("Guardar cambios")
        }
    }
}

@Composable
fun ScreenVisualizacion(navController: NavController) {
    TopAppBar(
        backgroundColor = Color.DarkGray,
    ) {
        IconButton(onClick = {
            navController.navigate(Screen.Menu.route)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_retroceso),
                contentDescription = "Retroceder",
                tint = Color.White
            )
        }
        Text(
            text = "Lista de asistentes",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        for ((clave, Asist) in Asistentes) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.navigate(Screen.Menu.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_person_24),
                        contentDescription = "Asistente",
                        tint = Color.DarkGray
                    )
                }
                Text(
                    text = Asist.nombre+"\n"+Asist.apellidos,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = Asist.telefono,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Menu : Screen("menu")
    object Registro : Screen("registro")
    object Modificacion : Screen("modificacion")
    object Visualizacion : Screen("visualizacion")
}