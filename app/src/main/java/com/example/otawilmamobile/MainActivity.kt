package com.example.otawilmamobile

import android.app.PendingIntent.getActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.otawilmamobile.ui.theme.OtaWilmaMobileTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.otawilmamobile.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OtaWilmaMobileTheme {
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                val context = LocalContext.current

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    gesturesEnabled = drawerState.isOpen,
                    drawerContent = {
                        ModalDrawerSheet(modifier = Modifier.width(280.dp),
                        ) {
                            DrawerHeader()
                            HorizontalDivider(
                                modifier = Modifier.padding(6.dp)
                            )
                            DrawerBody(
                                items = listOf(
                                    MenuItem(
                                        id = "home",
                                        title = "Home",
                                        contentDescription = "Go to home screen",
                                        icon = Icons.Default.Home
                                    ),
                                    MenuItem(
                                        id = "messages",
                                        title = "Messages",
                                        contentDescription = "Go to messages screen",
                                        icon = Icons.Default.Email
                                    ),
                                    MenuItem(
                                        id = "settings",
                                        title = "Settings",
                                        contentDescription = "Go to app settings",
                                        icon = Icons.Default.Settings
                                    ),
                                    MenuItem(
                                        id = "logout",
                                        title = "Log out",
                                        contentDescription = "Log out",
                                        icon = Icons.Default.Lock
                                    )
                                ),
                                infoItem = (
                                        MenuItem(
                                            id = "info",
                                            title = "Info",
                                            contentDescription = "Information about the app",
                                            icon = Icons.Default.Info
                                        )
                                ),

                                onItemClick = {
                                    // Navigate to the desired screen and logging out
                                    Log.i("SCREEN", "Changed to ${it.title} screen.")
                                    when(it.id){
                                        "home" -> navController.navigate(HomeScreen)
                                        "messages" -> navController.navigate(MessagesScreen)
                                        "settings" -> navController.navigate(SettingsScreen)
                                        "logout" -> {
                                            Toast.makeText(context,"Log out not implemented yet :p", Toast.LENGTH_SHORT).show()
                                            navController.navigate(LogInScreen)
                                        }
                                        "info" -> navController.navigate(InfoScreen)
                                    }
                                    // After clicking on a item, close the drawer afterwards
                                    scope.launch{
                                        drawerState.close()
                                    }
                                }
                            )
                        }
                    },
                    content = {
                        Scaffold(
                            topBar = {
                                AppBar(
                                    onNavigationIconClick = {
                                        scope.launch{
                                            drawerState.open()
                                        }
                                    }
                                )
                            },
                            content = { padding ->
                                Modifier.padding(padding)
                                NavHost(
                                    navController = navController,
                                    startDestination = HomeScreen
                                ){
                                    composable<HomeScreen>{
                                        HomeScreen(padding)
                                    }

                                    composable<MessagesScreen>{
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ){
                                            Text(text = "Messages")
                                        }
                                    }

                                    composable<SettingsScreen>{
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ){
                                            Text(text = "Settings")
                                        }
                                    }

                                    composable<LogInScreen>{
                                        LogInScreen()
                                    }
                                    composable<InfoScreen>{
                                        InfoScreen()
                                    }
                                }
                            }
                        )
                    }
                )
            }
        }
    }
}

@Serializable
object HomeScreen

@Serializable
object MessagesScreen

@Serializable
object SettingsScreen

@Serializable
object LogInScreen

@Serializable
object InfoScreen