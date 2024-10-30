package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun coba(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var simpannama by remember { mutableStateOf("") }
    var simpanemail by remember { mutableStateOf("") }
    var simpannohp by remember { mutableStateOf("") }
    var simpanalamat by remember { mutableStateOf("") }

    var jenisk by remember { mutableStateOf("") }
    var simpanjenisk by remember { mutableStateOf("") }
    val simpanJK = listOf("laki - laki", "perempuan")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama Anda!") }
        )

        Row {
            simpanJK.forEach { selectedjk ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    RadioButton(
                        selected = jenisk == selectedjk,
                        onClick = { jenisk = selectedjk }
                    )
                    Text(text = selectedjk)
                }
            }
        }


        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Anda!") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nohp,
            onValueChange = { nohp = it },
            label = { Text("No HP Anda!") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat Anda!") }
        )

        Button(onClick = {
            simpannama = nama
            simpanemail = email
            simpannohp = nohp
            simpanalamat = alamat
                         }, modifier = modifier.padding(10.dp)){

        }
        }
        Card(modifier = modifier.fillMaxWidth().padding(16.dp)){
            Column {
                DetailMahasiswa(
                    judul = "nama",
                    isinya = simpannama
                )
                DetailMahasiswa(
                    judul = "email",
                    isinya = simpanemail
                )
                DetailMahasiswa(
                    judul = "no hp",
                    isinya = simpannohp

                )
                DetailMahasiswa(
                    judul = "alamat",
                    isinya =  simpanalamat
                )
            }
        }
    }


@Composable
fun DetailMahasiswa(
    judul:String,
    isinya:String
){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya,  modifier = Modifier.weight(2f))
    }


}

