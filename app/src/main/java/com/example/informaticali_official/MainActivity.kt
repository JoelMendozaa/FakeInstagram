package com.example.informaticali_official

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.informaticali_official.ui.theme.InformaticaLI_OfficialTheme
import com.example.informaticali_official.ui.theme.LightBlue
import com.example.informaticali_official.ui.theme.LightGray

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InformaticaLI_OfficialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }


    @Composable
    fun OnBoardingScreen(onContinueClicked: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo")
            Text("Incia sesión", color = MaterialTheme.colorScheme.secondary)
            OutLineTextFieldEmail()
            OutLineTextFieldPassword()
            Text("He olvidado mi contraseña", color = MaterialTheme.colorScheme.secondary)
            Button(onClick = { onContinueClicked() }) {
                Text("Login")
            }
        }
    }

    @Composable
    fun MyApp() {
        var shouldShowOnboarding = rememberSaveable { mutableStateOf(true) }

        if (shouldShowOnboarding.value) {
            OnBoardingScreen(onContinueClicked = { shouldShowOnboarding.value = false })
        } else {
            Greeting()
        }
    }

    @Composable
    fun OutLineTextFieldEmail() {
        var email = remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.padding(vertical = 10.dp),
            value = email.value,
            label = { Text(text = "Introduce tu correo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onValueChange = {
                email.value = it
            }
        )
    }

    @Composable
    fun OutLineTextFieldPassword() {
        var password = rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Introduce tu contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }

    @Composable
    private fun Greeting() {
        DrawCircle()
    }


    @Composable
    private fun DrawCircle() {
        val grosor = 2.dp
        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            Row(modifier = Modifier.padding(20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.amd),
                    contentDescription = "imagen AMD",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(BorderStroke(grosor, Color.Cyan), CircleShape)
                )

                Image(
                    painter = painterResource(id = R.drawable.intel),
                    contentDescription = "imagen Intel",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(BorderStroke(grosor, Color.Cyan), CircleShape)
                )

                Image(
                    painter = painterResource(id = R.drawable.nvidia),
                    contentDescription = "imagen Nvidia",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(BorderStroke(grosor, Color.Cyan), CircleShape)
                )
            }
            Column (modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)) {
                Image(
                    painter = painterResource(id = R.drawable.setup),
                    contentDescription = "imagen Setup",
                    modifier = Modifier
                        .padding(top = 50.dp, start = 75.dp, end = 25.dp)
                        .size(250.dp)
                        .fillMaxWidth()
                        .border(BorderStroke(2.dp, Color.LightGray))
                )
                Row (modifier = Modifier
                    .fillMaxWidth(15f)
                    .padding(start = 75.dp, top = 5.dp, bottom = 10.dp)) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Like", modifier = Modifier.wrapContentSize(
                        Alignment.Center))
                    Icon(Icons.Default.Send, contentDescription = "Coment", modifier = Modifier.wrapContentSize(
                        Alignment.Center))
                    Icon(Icons.Default.Share, contentDescription = "Share", modifier = Modifier.wrapContentSize(
                        Alignment.Center))
                }
                Rectangulo()

            }
            Column (modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)) {
                Image(
                    painter = painterResource(id = R.drawable.teclado),
                    contentDescription = "imagen Teclado",
                    modifier = Modifier
                        .padding(top = 50.dp, start = 75.dp, end = 25.dp)
                        .size(250.dp)
                        .fillMaxWidth()
                        .border(BorderStroke(2.dp, Color.LightGray))
                )
                Row (modifier = Modifier
                    .fillMaxWidth(15f)
                    .padding(start = 75.dp, top = 5.dp, bottom = 10.dp)) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Like", modifier = Modifier.wrapContentSize(
                        Alignment.Center))
                    Icon(Icons.Default.Send, contentDescription = "Coment", modifier = Modifier.wrapContentSize(
                        Alignment.Center))
                    Icon(Icons.Default.Share, contentDescription = "Share", modifier = Modifier.wrapContentSize(
                        Alignment.Center))
                }
                Rectangulo2()            }
        }
    }
    @Composable
    private fun Rectangulo() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Text("Informaticali: ",
                modifier = Modifier
                    .padding(10.dp)
                    .padding(bottom = 0.dp)
                    .requiredWidth(150.dp)
                    .height(50.dp)
                    .background(Color.Transparent),
                fontWeight = FontWeight.Bold
            )
            Row (modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()){
                Text ("¡Un fabuloso PC gamer con monitor y perifericos! " +
                        "Contiene un i5-13600KF, 16GB RAM DDR5 a 5200Mhz, 1TB SSD NVMe y una RTX 4060")
            }
        }
    }

    @Composable
    private fun Rectangulo2() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Text("Informaticali: ",
                modifier = Modifier
                    .padding(10.dp)
                    .padding(bottom = 0.dp)
                    .requiredWidth(150.dp)
                    .height(50.dp)
                    .background(Color.Transparent),
                fontWeight = FontWeight.Bold
            )
            Row (modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()){
                Text ("¡Ha llegado el nuevo teclado mécanico de Red Dragon! " +
                        "Red Dragon Fizz, con switches red, blue y brown")
            }
        }
    }
}
