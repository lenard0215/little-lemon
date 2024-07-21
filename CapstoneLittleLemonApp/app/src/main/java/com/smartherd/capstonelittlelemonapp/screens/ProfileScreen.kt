package com.smartherd.capstonelittlelemonapp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smartherd.capstonelittlelemonapp.R
import com.smartherd.capstonelittlelemonapp.appcomponents.ButtonComponent
import com.smartherd.capstonelittlelemonapp.appcomponents.TextFieldComponent
import com.smartherd.capstonelittlelemonapp.navigation.Home
import com.smartherd.capstonelittlelemonapp.navigation.Onboarding
import com.smartherd.capstonelittlelemonapp.ui.theme.AppGreen
import com.smartherd.capstonelittlelemonapp.ui.theme.AppYellow



@Composable
fun ProfileScreen(context: Context, navController: NavHostController) {
    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    val firstName = remember {
        mutableStateOf(sharedPreferences.getString("firstName", ""))
    }

    val lastName = remember {
        mutableStateOf(sharedPreferences.getString("lastName", ""))
    }

    val email = remember {
        mutableStateOf(sharedPreferences.getString("email", ""))
    }

    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {
            Column(
                Modifier
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                /*verticalArrangement = Arrangement.spacedBy(20.dp)*/
            ) {
                Row(Modifier.fillMaxWidth(0.6f)) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Little Lemon Logo"
                    )
                }
                Spacer(modifier = Modifier.height(90.dp))
                Column(modifier=Modifier.padding(horizontal = 8.dp) ) {


                    Text(
                        text = "Personal Information",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                    TextFieldComponent(labelValue = firstName.value!!,
                        onTextSelected = {})
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFieldComponent(labelValue = lastName.value!!,
                        onTextSelected = {})
                    Spacer(modifier = Modifier.height(15.dp))
                    TextFieldComponent(
                        labelValue = email.value!!,
                        onTextSelected = {})
                    Spacer(modifier = Modifier.size(120.dp))
                    ButtonComponent(name = "Log Out", onButtonClicked = {
                        sharedPreferences.edit()
                            .clear()
                            .apply()

                        navController.navigate(Onboarding.route) {
                            popUpTo(Home.route) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    })


                    /*OutlinedTextField(
                enabled = true,
                //readOnly = true,
                value = firstName.value!!,.
                onValueChange = {},
                label = { Text(text = "First Name") },
                singleLine = true,
                placeholder = { Text(text = "First Name") },
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = AppGreen,
                    disabledLabelColor = AppGreen,
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                enabled = true,
                //readOnly = true,
                value = lastName.value!!,
                onValueChange = {},
                label = { Text(text = "Last Name") },
                singleLine = true,
                placeholder = { Text(text = "Last Name") },
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = AppGreen,
                    disabledLabelColor = AppGreen,
                ),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                enabled = true,
                //readOnly = true,
                value = email.value!!,
                onValueChange = {},
                label = { Text(text = "Email") },
                singleLine = true,
                placeholder = { Text(text = "johndoe@gmail.com") },
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = AppGreen,
                    disabledLabelColor = AppGreen,
                ),
                modifier = Modifier.fillMaxWidth()
            )*/

                    Spacer(modifier = Modifier.size(80.dp))

                    /* Button(
                onClick = {
                    sharedPreferences.edit().clear()
                        .apply()

                    navController.navigate(Onboarding.route) {
                        popUpTo(Home.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(AppYellow)
            ) {
                Text(text = "Log Out", style = MaterialTheme.typography.displaySmall)

                }*/
                }
            }
        }
    }
}
