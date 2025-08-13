package udemy.victorlamas.instafake.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import udemy.victorlamas.instafake.view.auth.register.RegisterScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
         composable<Login> {
//             LoginScreen()
             RegisterScreen()
         }
    }
}