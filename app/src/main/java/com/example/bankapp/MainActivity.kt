package com.example.bankapp

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankapp.components.Header
import com.example.bankapp.components.StatisticCard
import com.example.bankapp.components.TransactionItem
import com.example.bankapp.ui.theme.AccentBlack
import com.example.bankapp.ui.theme.AccentBlue
import com.example.bankapp.ui.theme.BankAppTheme
import com.example.bankapp.ui.theme.CardBeige
import com.example.bankapp.ui.theme.CardGreen
import com.example.bankapp.ui.theme.CardPurple
import com.example.bankapp.ui.theme.TextColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BankAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(userName = "Gael", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomeScreen(userName: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Header(userName)
        Spacer(modifier = Modifier.height(16.dp))
        StatisticsSection()
        Spacer(modifier = Modifier.height(16.dp))
        RecentTransactions()
    }
}

@Composable
fun StatisticsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatisticCard(title = "Actividad\nde la Semana", amount = "", backgroundColor = CardGreen, isLarge = true)

        Spacer(modifier = Modifier.width(12.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatisticCard(title = "Ventas", amount = "$280.99", backgroundColor = CardBeige)
            StatisticCard(title = "Ganancias", amount = "$280.99", backgroundColor = CardPurple)
        }
    }
}

@Composable
fun RecentTransactions() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Transactions", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextColor)
            Text(text = "See All", fontSize = 14.sp, color = AccentBlue)
        }
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem(
            "Nike Store",
            "Ropa & Zapatos",
            "-$27.67",
            "2:23 PM",
            AccentBlack,
            Icons.Filled.ShoppingCart
        )
        TransactionItem(
            "Pepsi",
            "Restaurantes & Cafe",
            "-$34.92",
            "10:00 AM",
            AccentBlue,
            Icons.Filled.ShoppingCart
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL
)
@Composable
fun HomeScreenPreview() {
    BankAppTheme {
        HomeScreen(userName = "Gael", modifier = Modifier.padding(20.dp))
    }
}

