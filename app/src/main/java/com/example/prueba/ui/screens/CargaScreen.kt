package com.example.prueba.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.prueba.viewmodel.EstadoViewModel

@Composable
fun Pantallacarga(modifier: Modifier = Modifier, viewModel: EstadoViewModel = viewModel()){
    val estado = viewModel.activo.collectAsState()
    val mostrarMensaje = viewModel.mostrar_mensaje.collectAsState()

    if (estado.value ==null){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }

    }else{
        val estadoActivo = estado.value!!
        val colorAnidado by animateColorAsState(
            targetValue = if (estadoActivo) Color(0xFF4CAf50) else Color(0xFFB0BEc5),
            animationSpec = tween(durationMillis = 500), label = ""
        )

        val textoBoton by remember(estadoActivo) {
            derivedStateOf { if (estadoActivo) "desactivar" else "activar" }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {viewModel.alternarEstados()},
                colors = ButtonDefaults.buttonColors(contentColor = colorAnidado),
                modifier = Modifier
                    .fillMaxSize()
                    .height(60.dp)
            ) {
                Text(textoBoton, style = MaterialTheme.typography.titleLarge)
            }
            Spacer(modifier = Modifier.height(24.dp))

            AnimatedVisibility(visible = mostrarMensaje.value==true) {
                Text(
                    text = "¡estado guardado exitosamente!",
                    color = Color(0xFF4CAF50),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

}