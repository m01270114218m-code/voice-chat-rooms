package com.voicerooms.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { FarahChatRoom() }
    }
}

@Composable
private fun FarahChatRoom() {
    val seats = remember { List(8) { it } }
    Box(Modifier.fillMaxSize().background(Color(0xFF080B16))) {
        Canvas(Modifier.fillMaxSize()) {
            drawRect(brush = Brush.verticalGradient(listOf(Color(0xFF171D43), Color(0xFF070912))))
            drawCircle(Color(0x3324B7FF), size.minDimension * .48f, center)
        }
        Column(Modifier.fillMaxSize().padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.weight(1f)) {
                    Text("ليالي فرح", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("غرفة صوتية • 8 ميكات", color = Color(0xFFB9C3E6), fontSize = 12.sp)
                }
                Surface(shape = RoundedCornerShape(18.dp), color = Color(0x3328D7FF)) {
                    Text("● مباشر", color = Color(0xFF6EE7FF), modifier = Modifier.padding(horizontal=12.dp, vertical=7.dp), fontSize=12.sp)
                }
            }

            Box(Modifier.fillMaxWidth().height(220.dp), contentAlignment=Alignment.Center) {
                Column(horizontalAlignment=Alignment.CenterHorizontally) {
                    Text("FARAH CHAT", color=Color(0xFFBCEBFF), fontSize=11.sp, letterSpacing=3.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("غرفة 3D صوتية", color=Color.White, fontSize=25.sp, fontWeight=FontWeight.Bold)
                    Spacer(Modifier.height(6.dp))
                    Text("الأصل البصري لكل ميك قابل للاستبدال", color=Color(0xFF9AA6CB), fontSize=11.sp)
                }
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(7.dp)) {
                seats.take(4).forEach { Seat(it, locked = it == 3, occupied = it == 0) }
            }
            Spacer(Modifier.height(14.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(7.dp)) {
                seats.drop(4).forEach { Seat(it, locked = it == 7, occupied = it == 5) }
            }

            Spacer(Modifier.weight(1f))
            Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(10.dp)) {
                ActionButton("🎁", "هدايا", Modifier.weight(1f))
                ActionButton("💬", "دردشة", Modifier.weight(1f))
                ActionButton("🎙", "الميك", Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun RowScope.Seat(index: Int, locked: Boolean, occupied: Boolean) {
    Column(Modifier.weight(1f), horizontalAlignment=Alignment.CenterHorizontally) {
        Box(Modifier.size(70.dp), contentAlignment=Alignment.Center) {
            Canvas(Modifier.fillMaxSize()) {
                drawCircle(Color(0x442BD9FF))
                drawCircle(Color(0xFF55DFFF), style=Stroke(3.dp.toPx()))
            }
            if (occupied) {
                Box(
                    Modifier.size(50.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF27304E))
                        .border(2.dp, Color(0xFF7BE8FF), CircleShape),
                    contentAlignment=Alignment.Center
                ) {
                    Text("م", color=Color.White, fontSize=20.sp, fontWeight=FontWeight.Bold)
                }
            } else {
                Text(if (locked) "🔒" else "＋", fontSize=24.sp)
            }
        }
        Text(
            if (locked) "مقفل" else if (occupied) "مستخدم" else "ميك ${index + 1}",
            color=Color(0xFFDDE4FF),
            fontSize=10.sp
        )
    }
}

@Composable
private fun ActionButton(icon: String, label: String, modifier: Modifier) {
    Surface(modifier=modifier, shape=RoundedCornerShape(18.dp), color=Color(0x221F2A4D)) {
        Column(horizontalAlignment=Alignment.CenterHorizontally, modifier=Modifier.padding(vertical=10.dp)) {
            Text(icon, fontSize=18.sp)
            Text(label, color=Color.White, fontSize=10.sp)
        }
    }
}
