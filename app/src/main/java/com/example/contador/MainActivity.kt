package com.example.contador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contador.ui.theme.ContadorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Estado compõe o componente
 * O Evento altera o estado
 * O estado refaz o componente
 */



@Composable
fun Greeting(modifier: Modifier = Modifier) {
    // Criou um estado = dados para ser utilizado
    var count: Int by remember {
        mutableStateOf<Int>(0)
    };

    // Adicionando componentes de tela
    // Column
    //   '-> Text
    //   '-> Button
    //         '-> Text
    Column (
        // Alterando os modificadores = Alteram o layout
        // parametro = valor
        modifier = Modifier.fillMaxSize().padding(16.dp).background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
       ){
        // Quando alterar o estado de count vai re-compor o Text
        Text(text = count.toString(),
            modifier = Modifier.padding(0.dp).align(Alignment.CenterHorizontally),
            color = Color.Blue,
            fontFamily = FontFamily.SansSerif,
            fontSize = 60.sp
        )
        Button(
            // onClick é um evento que altera o estado (dado)
            onClick = { count++ }
        ) {
            Text(text="Contar", fontSize = 30.sp)
        }

        Button(
            // onClick é um evento que altera o estado (dado)
            onClick = { count = 0}
        ) {
            Text(text="Limpar", fontSize = 30.sp)
        }
    }

}