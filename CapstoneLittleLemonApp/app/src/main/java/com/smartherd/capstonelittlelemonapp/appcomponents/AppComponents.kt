package com.smartherd.capstonelittlelemonapp.appcomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.smartherd.capstonelittlelemonapp.MenuItemRoom
import com.smartherd.capstonelittlelemonapp.R
import com.smartherd.capstonelittlelemonapp.navigation.Home
import com.smartherd.capstonelittlelemonapp.navigation.Onboarding
import com.smartherd.capstonelittlelemonapp.navigation.Profile
import com.smartherd.capstonelittlelemonapp.ui.theme.AppBlack
import com.smartherd.capstonelittlelemonapp.ui.theme.AppGray
import com.smartherd.capstonelittlelemonapp.ui.theme.AppGreen
import com.smartherd.capstonelittlelemonapp.ui.theme.AppYellow

@Composable
fun Header(navController: NavHostController){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.width(60.dp))
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",  modifier = Modifier
                .fillMaxWidth(0.65f))
        
        Box(){
            Image(painter = painterResource(id = R.drawable.persona), contentDescription = "person " +
                    "Image", contentScale = ContentScale.Crop, modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .clickable {  navController.navigate(Profile.route) {
                    popUpTo(Home.route) {
                        inclusive = true
                    }
                    launchSingleTop = true
                } })
        }
    }
}
@Composable
fun UpperPanel(search : (parameter: String)-> Unit) {
    var searchPhrase by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(367.dp)
        .background(AppGreen)) {
        Column(
            modifier = Modifier
                .background(AppGreen)
                .padding(8.dp)
        ) {
            Text(text = "Little Lemon", style = MaterialTheme.typography.titleLarge)
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

            Column() {
            Text(text = "Chicago", style = MaterialTheme.typography.bodyLarge)

            Text(
                text = "We are a family owned Mediterranean restaurant, focused on traditional " +
                        "recipes served with  a modern twist.",
                modifier = Modifier.fillMaxWidth(0.7f),
                color = AppGray,
                style = MaterialTheme.typography.bodyMedium
            )
        }
            Image(painter = painterResource(id = R.drawable.hero_image),
                contentDescription ="Hero Image", modifier = Modifier.clip(RoundedCornerShape(16.dp)
                    ) )
            }
            Spacer(modifier = Modifier.height(15.dp))
           // SearchTextFieldComponent(labelValue = stringResource(id = R.string.search) ,
                //onTextSelected = {searchPhrase.value =it
                                        //search(it)})
           OutlinedTextField(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(vertical = 10.dp),
               enabled = true,
                shape = RoundedCornerShape(10.dp),
                //readOnly = true,
                value = searchPhrase,
                onValueChange = {searchPhrase = it
                                search(it)},
                singleLine = true,
                placeholder = { Text(text = "Enter Search Phrase", color = AppBlack, fontSize = 26.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = AppYellow,
                    unfocusedPlaceholderColor = AppBlack,
                    focusedTextColor = AppBlack,
                    unfocusedTextColor = AppBlack,
                    unfocusedContainerColor = AppGray,
                    focusedBorderColor = AppGray,
                    unfocusedBorderColor = AppGray,
                    cursorColor = AppBlack
                ),
            )
        }
    }
}

@Composable
fun LowerPanel(databaseMenuItems: List<MenuItemRoom>, search: MutableState<String>) {
    val categories = databaseMenuItems.map {
        it.category.replaceFirstChar {character ->
            character.uppercase()
        }
    }.toSet()


    val selectedCategory = remember {
        mutableStateOf("")
    }


    val items = if(search.value == ""){
        databaseMenuItems

    }
    else{
        databaseMenuItems.filter {
            it.title.contains(search.value, ignoreCase = true)

        }


    }
    val filteredItems = if(selectedCategory.value == "" || selectedCategory.value == "all"){
        items
    }
    else{
        items.filter {
            it.category.contains(selectedCategory.value, ignoreCase = true)
        }
    }
    Column(modifier = Modifier.padding(top=10.dp)) {
        MenuCategories(categories) {selectedCategory.value = it
        }
        Spacer(modifier = Modifier.size(2.dp))
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (item in filteredItems){
                MenuItem(item = item)
            }
        }

    }
}

@Composable
private fun MenuCategoryButton(category: String, onSelected: (selected: String)-> Unit) {
    val isClicked = remember{ mutableStateOf(false) }

    Button(onClick = { isClicked.value = !isClicked.value
                     onSelected(category)}, colors = ButtonDefaults.buttonColors(Color.LightGray),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(text = category, style = MaterialTheme.typography.titleSmall)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(item: MenuItemRoom) {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(Color.White)){
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(10.dp)) {
                Text(text = item.title , fontSize = 18.sp, fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium)
                Text(modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth(.7f),
                    text = item.description, style = MaterialTheme.typography.bodySmall)
                Text(text = "$${item.price}", style = MaterialTheme.typography.bodyMedium)
                //Spacer(modifier = Modifier.width(5.dp))

            }
       /* AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data(item.imageUrl).crossfade(true).build(), contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.size(100.dp, 100.dp))*/


        GlideImage(model = item.imageUrl, contentDescription = "menu Image", modifier =
            Modifier.size(100.dp, 100.dp), contentScale = ContentScale.Crop, transition = CrossFade)
        }
   }
}

@Composable
fun MenuCategories(categories: Set<String>, categoryLambda : (sel: String) -> Unit) {
    val cat = remember {
        mutableStateOf("")
    }

    Card(elevation = CardDefaults.cardElevation(), modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White)) {

        Column(Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
            Text(text = "ORDER FOR DELIVERY!", style = MaterialTheme.typography.displayMedium)

            Row(modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)) {

                MenuCategoryButton(category = "All"){
                    cat.value = it.lowercase()
                    categoryLambda(it.lowercase())
                }

                for (category in categories){
                    MenuCategoryButton(category = category){
                        cat.value = it
                        categoryLambda(it)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchTextFieldComponent(labelValue: String,
                         onTextSelected: (String) -> Unit, ){

    var textValue by remember{ mutableStateOf(value = "") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
        cursorColor = AppBlack,
        unfocusedPlaceholderColor = Color.Black,
        focusedPlaceholderColor = Color.Black,
        unfocusedContainerColor = Color.White
        ),
        singleLine = true,
        maxLines = 1,
        value = textValue,
        onValueChange ={
            textValue = it
            onTextSelected(it)
        },
        leadingIcon = {Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")  },
        placeholder = { Text(text = labelValue, fontSize = 30.sp)},
    )
}

@Composable
fun TextFieldComponent(labelValue: String,
                         onTextSelected: (String) -> Unit, ){

    val textValue = remember{ mutableStateOf(value = "") }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        enabled = false,
        readOnly = true ,
        modifier = Modifier
            .fillMaxWidth(),
        value = textValue.value,
        onValueChange ={
            textValue.value = it
            onTextSelected(it)
        },
        label = {Text(text = labelValue, color = AppBlack, fontSize = 26.sp)},
        placeholder = { Text(text = labelValue, color = AppBlack)},
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = AppYellow,
            unfocusedPlaceholderColor = AppBlack,
            focusedTextColor = AppBlack,
            unfocusedTextColor = AppBlack,
            unfocusedContainerColor = AppGray,
            focusedBorderColor = AppGray,
            unfocusedBorderColor = AppGray,
            cursorColor = AppBlack
        ),
    )
}

@Composable
fun ButtonComponent(name: String, onButtonClicked: ()-> Unit){

    Button(
        onClick = {
         onButtonClicked.invoke()
        }, modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(AppYellow)
    ) {
        Text(text = name, style = MaterialTheme.typography.displaySmall)

    }
}

@Composable
fun OnBoardTextFieldComponent(labelValue: String,
                       onTextSelected: (String) -> Unit, ){

    var textValue  by remember{ mutableStateOf(value = "") }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth().height(80.dp),
        value = textValue,
        onValueChange ={
            textValue = it
            onTextSelected(it)
        },
        label = {Text(text = labelValue, color = AppBlack)},
        placeholder = { Text(text = labelValue)},
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(

            cursorColor = Color.Black,
            unfocusedContainerColor = AppGreen,
            focusedContainerColor = AppGreen,
        ),
    )
}

@Composable
fun ButtonComponent2(name: String, onButtonClicked: ()-> Unit){

    Button(
        onClick = {
            onButtonClicked.invoke()
        }, modifier = Modifier
            .fillMaxWidth()
            .height(35.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(AppYellow)
    ) {
        Text(text = name, style = MaterialTheme.typography.displaySmall)

    }
}