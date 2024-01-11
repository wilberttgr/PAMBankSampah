package com.example.pambanksampah.navigasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pambanksampah.ui.theme.halaman.AddMedicationScreen
import com.example.pambanksampah.ui.theme.halaman.BankSampahApp
import com.example.pambanksampah.ui.theme.halaman.DestinasiForm
import com.example.pambanksampah.ui.theme.halaman.DestinasiHome
import com.example.pambanksampah.ui.theme.halaman.DestinasiJenis
import com.example.pambanksampah.ui.theme.halaman.DestinasiLogin
import com.example.pambanksampah.ui.theme.halaman.EmptyScreen
import com.example.pambanksampah.ui.theme.halaman.GarbageInformation

@Composable
fun SampahApp(navController: NavHostController = rememberNavController()) {
    HostNavigasi(navController = navController)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampahTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(
                    onClick = navigateUp,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(40.dp)
                        .background(
                            color = Color(0xFF4CAF50),
                            shape = CircleShape
                        )) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = ""
                    )
                }
            }
        }
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiLogin.route,
        modifier = Modifier
    )
    {
        composable(DestinasiLogin.route) {
            EmptyScreen(navController = navController,
                onNextButtonClicked = { navController.navigate(DestinasiHome.route) })
        }
        composable(DestinasiHome.route) {
            BankSampahApp(navController = navController)
        }
        composable(DestinasiForm.route) {
            AddMedicationScreen(navigateBack = { navController.navigate(DestinasiHome.route) })
        }
        composable(DestinasiJenis.route) {
            GarbageInformation(navigateBack = { navController.navigate(DestinasiHome.route) })
        }
    }
}
