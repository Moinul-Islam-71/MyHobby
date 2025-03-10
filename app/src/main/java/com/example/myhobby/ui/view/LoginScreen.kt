package com.example.myhobby.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myhobby.R

@Composable
fun LoginScreen(navController: NavController, paddingValues: PaddingValues) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var emailError by rememberSaveable { mutableStateOf("") }
    var passwordError by rememberSaveable { mutableStateOf("") }

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.login_animation))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.size(250.dp)
            )

            Text("Login", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            TextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = emailError.ifEmpty { "Email" }, color = if (emailError.isNotEmpty()) Red else Unspecified) },
                leadingIcon = {
                    Icon(
                        Icons.Rounded.AccountCircle, contentDescription = ""
                    )
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedLabelColor = Gray
                )
            )
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            TextField(
                value = password,
                onValueChange = {password = it},
                label = { Text(passwordError.ifEmpty { "Password" }, color = if (passwordError.isNotEmpty()) Red else Unspecified) },
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Lock, contentDescription = ""
                    )
                },

                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                trailingIcon = {
                    val image = if (passwordVisible) painterResource(id = R.drawable.visibility_off)
                    else painterResource(id = R.drawable.visibility_on)

                    Icon(
                        painter = image,
                        contentDescription = "",
                        modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                    )
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedLabelColor = Gray
                )
            )
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        item {
            Button(
                onClick = {
                    emailError = if (email.isEmpty()) "Email is required" else ""
                    passwordError = if (password.isEmpty()) "Password is required" else ""
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 90.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Login")
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text(
                text = "Forgot Password?",
                color = Color(0xFF2196F3),
                modifier = Modifier.padding(horizontal = 20.dp)
                    .clickable {
                        //forgot password logic here
                    }
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Row {
                Text(text = "Don't have an account?")

                Text(
                    text = "Sign Up",
                    color = Color(0xFF2196F3),
                    modifier = Modifier.padding(horizontal = 10.dp)
                        .clickable {
                            navController.navigate("register")
                        }
                )
            }
        }

        item { Spacer(modifier = Modifier.height(30.dp)) }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = Color.LightGray
                )
                Text(
                    text = "Or",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = Gray,
                    fontSize = 14.sp
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = Color.LightGray
                )
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item { SocialLoginButton(R.drawable.ic_google, "Continue with Google") {} }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        item { SocialLoginButton(R.drawable.ic_apple, "Continue with Apple") {} }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        item { SocialLoginButton(R.drawable.ic_microsoft, "Continue with Microsoft") {} }
    }
}

@Composable
fun SocialLoginButton(icon: Int, text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Gray.copy(alpha = 0.5f)
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text)
        }
    }
}