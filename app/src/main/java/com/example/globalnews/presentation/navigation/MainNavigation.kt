package com.example.globalnews.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.globalnews.presentation.screen.LoginScreen
import com.example.globalnews.presentation.screen.MainScreen
import com.example.globalnews.presentation.screen.RegisterScreen
import kotlinx.serialization.Serializable


sealed class Screen {

    @Serializable
    data object Login: Screen()

    @Serializable
    data object Register: Screen()

    @Serializable
    data object Main: Screen()
}


@Composable
fun MainNav(
    modifier: Modifier,
    navHostController: NavHostController
) {
    NavHost(
        modifier = Modifier,
        navController = navHostController,
        startDestination = Screen.Login,
    ){
        composable<Screen.Login> {
            LoginScreen { navigateTo ->
                navHostController.navigate(navigateTo)
            }
        }
        composable<Screen.Login> {
            RegisterScreen { navigateTo ->
                navHostController.navigate(navigateTo)
            }
        }
        composable<Screen.Login> {
            MainScreen { navigateTo ->
                navHostController.navigate(navigateTo)
            }
        }
    }
}
