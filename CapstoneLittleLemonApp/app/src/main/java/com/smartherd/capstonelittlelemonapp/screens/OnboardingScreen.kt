package com.smartherd.capstonelittlelemonapp.screens

import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smartherd.capstonelittlelemonapp.R
import com.smartherd.capstonelittlelemonapp.appcomponents.ButtonComponent
import com.smartherd.capstonelittlelemonapp.appcomponents.OnBoardTextFieldComponent
import com.smartherd.capstonelittlelemonapp.navigation.Home
import com.smartherd.capstonelittlelemonapp.navigation.Onboarding
import com.smartherd.capstonelittlelemonapp.ui.theme.AppGreen
import com.smartherd.capstonelittlelemonapp.ui.theme.AppYellow

@Composable
fun OnboardingScreen(context: Context, navHostController: NavHostController) {

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {

    val  sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    val firstName = remember {
        mutableStateOf("")
    }

    val lastName = remember {
        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }

   Column(
        Modifier
            .fillMaxSize(),
            //.padding(20.dp)
            //.verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Row(
            Modifier
                .fillMaxWidth(0.6f)
                .padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo"
            )
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(AppGreen)){
            Text(text = "Let's get to know you", style = MaterialTheme.typography.headlineMedium)
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Personal Information", textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier =
        Modifier.padding(horizontal = 10.dp)) {
        OnBoardTextFieldComponent(labelValue = stringResource(id = R.string.first_name),
            onTextSelected = {firstName.value = it})
        OnBoardTextFieldComponent(labelValue = stringResource(id = R.string.last_name),
            onTextSelected = {lastName.value = it})
        OnBoardTextFieldComponent(labelValue = stringResource(id = R.string.email),
            onTextSelected = {email.value = it})
        Spacer(modifier = Modifier.size(60.dp))
        ButtonComponent(name = stringResource(id = R.string.register),
                onButtonClicked = {
                    if (validateRegData(
                            firstName.value,
                            lastName.value,
                            email.value)){
                        sharedPreferences.edit()
                            .putString("firstName", firstName.value)
                            .putString("lastName", lastName.value)
                            .putString("email", email.value)
                            .putBoolean("userRegistered", true)
                            .apply()

                        Toast.makeText(context,
                            "Registration Successful",
                            Toast.LENGTH_SHORT)
                            .show()
                        navHostController.navigate(Home.route){
                            popUpTo(Onboarding.route){inclusive = true}
                            launchSingleTop = true
                        }
                    }
                    else{
                        Toast.makeText(context,
                            "Invalid Credentials, Please try again",
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                })



            /*   OutlinedTextField(
                   enabled = true,
                   modifier = Modifier.fillMaxWidth().height(80.dp),
                   //readOnly = true,
                   value = firstName.value,
                   onValueChange = {firstName.value = it},
                   label = { Text(text = "First Name") },
                   singleLine = true,
                   placeholder = { Text(text = "First Name", fontSize = 18.sp) },
                   colors = OutlinedTextFieldDefaults.colors(
                       disabledBorderColor = AppGreen,
                       disabledLabelColor = AppGreen,
                       cursorColor = Color.Black
                   ),
                   keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),


               )
               OutlinedTextField(
                   enabled = true,
                   //readOnly = true,
                   modifier = Modifier.fillMaxWidth(),
                   value = lastName.value,
                   onValueChange = {lastName.value = it},
                   label = { Text(text = "Last Name") },
                   singleLine = true,
                   placeholder = { Text(text = "Last Name") },
                   colors = OutlinedTextFieldDefaults.colors(
                       disabledBorderColor = AppGreen,
                       disabledLabelColor = AppGreen,
                   ),
               )

               OutlinedTextField(
                   enabled = true,
                   //readOnly = true,
                   modifier = Modifier.fillMaxWidth(),
                   value = email.value,
                   onValueChange = {email.value = it},
                   label = { Text(text = "Email") },
                   singleLine = true,
                   placeholder = { Text(text = "johndoe@gmail.com") },
                   colors = OutlinedTextFieldDefaults.colors(
                       disabledBorderColor = AppGreen,
                       disabledLabelColor = AppGreen,
                   ),

               )*/
        }


       /* Button(
            onClick = {
                if (validateRegData(
                        firstName.value,
                        lastName.value,
                        email.value)){
                    sharedPreferences.edit()
                        .putString("firstName", firstName.value)
                        .putString("lastName", lastName.value)
                        .putString("email", email.value)
                        .putBoolean("userRegistered", true)
                        .apply()

                    Toast.makeText(context,
                        "Registration Successful",
                        Toast.LENGTH_SHORT)
                        .show()


                    navHostController.navigate(Home.route){
                        popUpTo(Onboarding.route){inclusive = true}
                        launchSingleTop = true
                    }

                }
                else{
                    Toast.makeText(context,
                        "Invalid Credentials, Please try again",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 15.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(AppYellow)
        ) {
            Text(text = "Register", style = MaterialTheme.typography.displaySmall)
            }*/
        }
    }
}

private fun validateRegData(firstName:String, lastName: String, email: String): Boolean{
    var validated = false

    if(firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()){
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
            validated = true
    }

    return validated
}

