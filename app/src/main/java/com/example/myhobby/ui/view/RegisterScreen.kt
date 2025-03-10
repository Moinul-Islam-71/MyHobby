package com.example.myhobby.ui.view

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myhobby.R

@Composable
fun RegisterScreen(navController: NavController, paddingValues: PaddingValues) {

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var confirmPasswordVisible by rememberSaveable { mutableStateOf(false) }

    var nameError by rememberSaveable { mutableStateOf("") }
    var emailError by rememberSaveable { mutableStateOf("") }
    var passwordError by rememberSaveable { mutableStateOf("") }
    var confirmPasswordError by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Text(
                text = "Create Account",
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, top = 15.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.ExtraBold
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Please enter your details",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Light
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            TextField(
                value = name,
                onValueChange = {name = it},
                label = { Text(text = nameError.ifEmpty { "Name" }, color = if (nameError.isNotEmpty()) Red else Unspecified) },
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Person, contentDescription = ""
                    )
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedLabelColor = Gray
                )
            )
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 20.dp),
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedLabelColor = Gray
                )
            )
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        item {
            TextField(
                value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = { Text(confirmPasswordError.ifEmpty { "Confirm Password" }, color = if (confirmPasswordError.isNotEmpty()) Red else Unspecified) },
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Lock, contentDescription = ""
                    )
                },

                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                trailingIcon = {
                    val image = if (confirmPasswordVisible) painterResource(id = R.drawable.visibility_off)
                    else painterResource(id = R.drawable.visibility_on)

                    Icon(
                        painter = image,
                        contentDescription = "",
                        modifier = Modifier.clickable { confirmPasswordVisible = !confirmPasswordVisible }
                    )
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 20.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Transparent,
                    unfocusedLabelColor = Gray
                )
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Button(
                onClick = {
                    nameError = if (name.isBlank()) "Name is required" else ""
                    emailError = if (email.isBlank()) "Email is required" else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) "Invalid email" else ""
                    passwordError = if (password.isBlank()) "Password is required" else ""
                    confirmPasswordError = if (confirmPassword.isBlank()) "Confirm password is required" else if (password != confirmPassword) "Passwords do not match" else ""

                    if (nameError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty() && confirmPasswordError.isEmpty()) {
                        // register logic here
                    }
                }
            ) {
                Text("Register")
            }
        }

        item { Spacer(modifier = Modifier.height(8.dp)) }

        item { TextButton(onClick = {navController.navigate("login")}) {
            Text("Already have an account? Login")
        } }
    }
}