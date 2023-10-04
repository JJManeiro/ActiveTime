package com.example.tiempoactiva

import android.os.Bundle
import android.os.SystemClock
import android.text.format.DateUtils.formatElapsedTime
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiempoactiva.ui.theme.TiempoActivaTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    var appStartTime: Long = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appStartTime = System.currentTimeMillis()
        setContent {
            TiempoActivaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Brave,new world.")
                    NumGen()
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("Estado","estoy arrancando");
    }
    override fun onResume() {
        super.onResume()
        Log.d("Estado","estoy onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d("Estado","estoy en Pausa");
        val ElapsedTime = SystemClock.elapsedRealtime() - appStartTime
        Log.d("Tiempo", "pasaron "+ElapsedTime/1000+" s")
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text (
        text = "Hello $name!",
        modifier = modifier
    )
    }
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TiempoActivaTheme {
        Greeting("Brave new world")
        NumGen()
    }
}
@Composable
fun NumGen(){
    var n = remember  {mutableStateOf(0);}
    Text(text = "numeros: "+n.value,
        modifier = Modifier.padding(50.dp)
    )
    Button(
        onClick ={n.value=(0..10).random()},
        modifier = Modifier.padding(100.dp)
    ) {
        Text(text = "Click me!")
    }
}