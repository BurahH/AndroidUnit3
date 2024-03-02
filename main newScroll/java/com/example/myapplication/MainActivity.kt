package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.DataSource
import com.example.myapplication.model.Topic
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicApp() {
    TopicList(
        topicList = DataSource.topics,
    )
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.width(150.dp).height(68.dp)) {
        Row(modifier = modifier.width(150.dp).height(68.dp)) {
            Image(
                painter = painterResource(topic.architecture1),
                contentDescription = stringResource(topic.architecture),
                modifier = Modifier
                    .size(68.dp),
                alignment = Alignment.BottomStart

            )
            Column () {
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = LocalContext.current.getString(topic.architecture),
                    modifier = Modifier,
                    textAlign = TextAlign.End,
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    Image(
                        painter = painterResource(R.drawable._11),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                    )
                    Text(
                        text = topic.i1.toString(),
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    var index = 0
    LazyColumn(modifier = modifier) {
        items(topicList.size / 2) { index ->
            Row() {
                TopicCard(
                    topic = topicList[index*2],
                    modifier = Modifier.padding(8.dp)
                )
                if(topicList.size+1 != index*2)
                TopicCard(
                    topic = topicList[index*2+1],
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}