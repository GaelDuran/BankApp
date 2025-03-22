package com.example.bankapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.ui.theme.TextColor

@Composable
fun StatisticCard(title: String, amount: String, backgroundColor: Color, isLarge: Boolean = false) {
    Column(
        modifier = Modifier
            .width(if (isLarge) 180.dp else 150.dp)
            .height(if (isLarge) 180.dp else 100.dp)
            .background(backgroundColor, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextColor)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = amount, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextColor)
    }
}
