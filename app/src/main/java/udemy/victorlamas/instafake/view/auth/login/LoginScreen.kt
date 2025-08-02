package udemy.victorlamas.instafake.view.auth.login

import android.R.attr.padding
import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import udemy.victorlamas.instafake.R

@Preview
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            Modifier
                .background(Color.White)
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = "Español (España)",
                color = Color.Gray
            )
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instafake_logo),
                contentDescription = "InstaFake logo header"
            )
            Spacer(Modifier.weight(1f))

            // Body
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                label = { Text("Usuario, correo electrónico o móvil") },
                onValueChange = { email = it },
                shape = RoundedCornerShape(30)
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                label = { Text("Contraseña") },
                onValueChange = { password = it },
                shape = RoundedCornerShape(30)
            )
            Spacer(Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {}
            ) {
                Text(
                    text = "Iniciar sesión",
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
            TextButton(onClick = {}) {
                Text(text = "¿Has olvidado la contraseña?")
            }
            Spacer(Modifier.weight(1.5f))

            // Footer
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = "Crear cuenta nueva")
            }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "Meta logo",
                tint = Color.Gray
            )
        }
    }
}