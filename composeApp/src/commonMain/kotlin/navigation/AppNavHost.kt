package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.LoginScreen
import screens.MenuScreen
import screens.ListMenuScreen
import java.net.URLDecoder

@Composable
fun AppNavHost() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController)
        }
        composable("menu") {
            MenuScreen(navController)
        }
        composable("detail/{title}") { backStackEntry ->
            val rawTitle = backStackEntry.arguments?.getString("title") ?: ""
            val title = URLDecoder.decode(rawTitle, "UTF-8")
            ListMenuScreen(navController, title)
        }
    }
}
