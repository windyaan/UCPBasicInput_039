package com.example.project

import android.provider.MediaStore.Audio.Radio
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@Preview(showBackground = true)
@Composable
fun ucp(modifier : Modifier = Modifier){
    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("")}
    var arrival by remember { mutableStateOf("")}
    var pilihTransport by remember { mutableStateOf("")}

    var originsv by remember { mutableStateOf("") }
    var departuresv by remember { mutableStateOf("")}
    var arrivalsv by remember { mutableStateOf("")}
    var pilihTransportsv by remember { mutableStateOf("")}

    val listTransport = listOf("Bus", "Ship", "Train", "Plane")
    Column (
        modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(color = Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            contentAlignment = Alignment.BottomStart
        ){
            Image(painter = painterResource(id = R.drawable.memebuzz),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
                    .clip(CircleShape)
            )
        }

        Text("Muhamad Adri",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)
        Text("Kabupaten Tangerang",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        Column (
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(Modifier .padding(16.dp))
            Text("Plan Your Adventures",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
            Text("Let's plan an exquisite adventure",
                fontSize = 25.sp,)

            Spacer(Modifier .padding(16.dp))
            TextField(
                modifier = Modifier .fillMaxWidth() .padding(5.dp),
                value = origin,
                onValueChange = {origin = it},
                label = { Text( "Origin") },
                placeholder = { Text( "Input Your Origin") },
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            ){
                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(0.8f),
                    value = departure,
                    onValueChange = {departure = it},
                    label = { Text( "Departure") },
                    placeholder = { Text( "Input Your Departure") },
                )
                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(0.8f),
                    value = arrival,
                    onValueChange = {arrival = it},
                    label = { Text( "Arrival") },
                    placeholder = { Text( "Input Your Arrival") },
                )
            }

            Text("Choose Transportation",
                fontSize = 25.sp,)
            Row {
                listTransport.forEach { item ->
                    Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                        selected = pilihTransport == item,
                        onClick = {
                            pilihTransport = item
                        }
                    )
                        Text(item)
                    }
                }
            }

            ElevatedButton(
                onClick = {
                originsv = origin
                departuresv = departure
                arrivalsv = arrival
                pilihTransportsv = pilihTransport
            }) {
                Text("Submit")
            }

            ElevatedCard(
                colors = CardDefaults.cardColors(contentColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()

            ){
                DetailSurat(judul = "Origin", isinya = originsv)
                DetailSurat(judul = "Departure", isinya = departuresv)

                Spacer(Modifier .padding(16.dp))
                DetailSurat(judul = "Arrival", isinya = arrivalsv)
                DetailSurat(judul = "Transport", isinya = pilihTransportsv)
            }
        }
    }
}

@Composable
fun DetailSurat(
    judul:String, isinya:String
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ){

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }
    }
}