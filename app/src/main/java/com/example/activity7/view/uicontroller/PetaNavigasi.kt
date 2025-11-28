package com.example.activity7.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.activity7.view.HalamanEntry
import com.example.activity7.view.HomeScreen
import com.example.activity7.view.route.DestinasiHome
import com.example.activity7.view.route.DestinasiEntry

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
             modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HalamanHome(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
            )
        }

        composable(DestinasiEntry.route) {
            HalamanEntry(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}
