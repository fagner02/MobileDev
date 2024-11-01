package com.example.lifecycledemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lifecycledemo.ui.theme.LifecycledemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d("App", "created")
        Toast.makeText(this, "created", Toast.LENGTH_SHORT).show()

        setContent{
            LifecycledemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Hamina",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d("App", "started")
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        Log.d("App", "resumed")
        Toast.makeText(this, "resumed", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()

        Log.d("App", "paused")
        Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()

        Log.d("App", "stopped")
        Toast.makeText(this, "stopped", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("App", "destroyed")
        Toast.makeText(this, "destroyed", Toast.LENGTH_SHORT).show()

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LifecycledemoTheme {
        Greeting("Android")
    }
}