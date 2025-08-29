package udemy.victorlamas.instafake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import udemy.victorlamas.instafake.ui.theme.InstaFakeTheme
import udemy.victorlamas.instafake.view.core.navigation.NavigationWrapper

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaFakeTheme {
                NavigationWrapper()
            }
        }
    }
}