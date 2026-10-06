package com.voicehub.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.voicehub.app.ui.theme.*

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFF8EAFB),
                        Color(0xFFEAF7FF),
                        Color(0xFFF8F8FB)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "تسجيل الدخول",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("البريد الإلكتروني") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("كلمة المرور") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = PurplePrimary)
                    ) {
                        Text("دخول")
                    }

                    TextButton(onClick = {}) {
                        Text("إنشاء حساب جديد")
                    }
                }
            }
        }
    }
}

@Composable
fun RegisterScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFF8EAFB),
                        Color(0xFFEAF7FF),
                        Color(0xFFF8F8FB)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "إنشاء حساب",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("الاسم") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("البريد الإلكتروني") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("كلمة المرور") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = PinkAccent)
                    ) {
                        Text("تسجيل")
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFF8EAFB),
                        Color(0xFFEAF7FF)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "الإعدادات",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = DarkText
            )

            Spacer(modifier = Modifier.height(20.dp))

            SettingsItem(title = "الملف الشخصي", icon = Icons.Default.Person)
            SettingsItem(title = "الأمان والخصوصية", icon = Icons.Default.Lock)
            SettingsItem(title = "الأصوات والمكالمات", icon = Icons.Default.VolumeUp)
            SettingsItem(title = "الإشعارات", icon = Icons.Default.Notifications)
            SettingsItem(title = "الدعم", icon = Icons.Default.HeadsetMic)
        }
    }
}

@Composable
fun SettingsItem(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFEDE7F6)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = PurplePrimary)
                }

                Text(title, fontWeight = FontWeight.Medium)
            }

            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = null)
        }
    }
}
