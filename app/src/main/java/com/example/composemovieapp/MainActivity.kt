package com.example.composemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composemovieapp.ui.theme.ComposeMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMovieAppTheme {
                MaterialTheme(
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background

                    ) {
                        NavigationView()
                    }
                }

            }
        }
    }
}


@Composable
fun NavigationView(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController = navController)
        }
        composable("settings"){
            SettingScreen(onHome = {
                navController.popBackStack()
            }, onProfile = {
                navController.navigate("profile")
            })
        }
        composable("profile"){
            ProfileScreen {
                navController.popBackStack("home",false)
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Home Screen")
        Button(onClick = {
            navController.navigate("settings")
        }) {
            Text(text = "Go to Settings")
        }
    }
}

@Composable
fun SettingScreen(onHome: () -> Unit,onProfile: () -> Unit) {
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Settings Screen")
        Button(onClick = onHome) {
            Text(text = "Go to Home")
        }
        Button(onClick = onProfile,
            shape = ButtonDefaults.elevatedShape) {
            Text(text = "Go to Profile")
        }
    }
}

@Composable
fun ProfileScreen(onHome: () -> Unit) {
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Profile Screen")
        Button(onClick = onHome) {
            Text(text = "Go to Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeMovieAppTheme {

    }
}