package com.example.prueba //PruebaTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prueba.navigation.AppNavegation
import com.example.prueba.navigation.AppRoute
import com.example.prueba.navigation.NavigationEvent
import com.example.prueba.ui.screens.HomeScreen
import com.example.prueba.ui.screens.ProfileScreen
import com.example.prueba.ui.screens.RegistroScreen
import com.example.prueba.ui.theme.PruebaTheme

import com.example.prueba.viewmodel.MainViewModel
import com.example.prueba.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTheme {
                AppNavegation()
            }
        }
    }
}