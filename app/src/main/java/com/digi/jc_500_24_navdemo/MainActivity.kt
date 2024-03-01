package com.digi.jc_500_24_navdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.digi.jc_500_24_navdemo.screens.HomeScreen
import com.digi.jc_500_24_navdemo.screens.ProfileScreen
import com.digi.jc_500_24_navdemo.screens.SplashScreen
import com.digi.jc_500_24_navdemo.ui.theme.JC_500_24_NavDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_500_24_NavDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        composable(route = "splash") {
                            SplashScreen { navController.navigate("home") }
                        }
                        composable(route = "home") {
                            HomeScreen(
                                onBackPressed = { navController.popBackStack() },
                                onNext = { navController.navigate("profile") }
                            )
                        }
                        composable(route = "profile") {
                            ProfileScreen { navController.popBackStack() }
                        }
                    }
                }
            }
        }
    }
}
