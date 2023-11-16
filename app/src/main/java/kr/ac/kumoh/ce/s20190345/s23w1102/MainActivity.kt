package kr.ac.kumoh.ce.s20190345.s23w1102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20190345.s23w1102.ui.theme.S23W1102Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyApp {
               Column(
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(8.dp),
                   verticalArrangement = Arrangement.Center,
               ) {
                   Counter()
                   Counter()
               }

           }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    S23W1102Theme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}


@Composable
fun Clicker(){
    val (txtString, setTxtString) =  remember {
        mutableStateOf("눌러줘")
    }
    Column {
        Text(txtString)
        Button(onClick = { setTxtString("눌렀구나 ㅋ")}){
            Text("누르랑께 ㅋ")
    }
    }
}

@Composable
fun Counter(){
    val (count, setCount) = rememberSaveable{
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$count",
            fontSize = 70.sp,
        )
        Row {
            Button(modifier = Modifier
                .weight(1f),
                onClick = { setCount( count + 1) }) {
                Text(text = "증가")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(modifier = Modifier.weight(1f),
                onClick = { setCount( count - 1) }) {
                Text(text = "감소")
            }
        }
    }
}


