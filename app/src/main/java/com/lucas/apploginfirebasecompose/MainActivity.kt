package com.lucas.apploginfirebasecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lucas.apploginfirebasecompose.ui.theme.AppLoginFirebaseComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppLoginFirebaseComposeTheme {
                AppNavigation() // 🔥 Chamando a navegação aqui
            }
        }
    }
}
