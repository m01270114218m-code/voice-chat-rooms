package com.voicehub.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.filled.VoiceChat
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.voicehub.app.ui.theme.*

@Composable
fun VoiceStateDemoScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF7EAFB),
                        Color(0xFFEAF6FF),
                        Color(0xFFF8F8FB)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "حالات الميكروفون",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                VoiceStateCard(
                    title = "مفتوح",
                    isOpen = true,
                    color = PurplePrimary
                )

                VoiceStateCard(
                    title = "مغلق",
                    isOpen = false,
                    color = GrayText
                )
            }

            Spacer(modifier = Modifier.height(42.dp))

            Text(
                text = "حالة الميكروفون تعكس صوت المستخدم داخل الغرفة",
                style = MaterialTheme.typography.bodyLarge,
                color = GrayText
            )
        }
    }
}

@Composable
fun VoiceStateCard(
    title: String,
    isOpen: Boolean,
    color: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            color = DarkText,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(18.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(
                    if (isOpen) Brush.linearGradient(listOf(PurplePrimary, PinkAccent))
                    else Brush.linearGradient(listOf(Color(0xFFE5E7EB), Color(0xFFD1D5DB)))
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (isOpen) Icons.Default.Mic else Icons.Default.MicOff,
                contentDescription = null,
                tint = if (isOpen) White else Color(0xFF6B7280),
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = if (isOpen) "مستعد للتحدث" else "غير متاح",
            color = if (isOpen) Color(0xFF16A34A) else Color(0xFFDC2626),
            fontWeight = FontWeight.Bold
        )
    }
}
