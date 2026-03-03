package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipCalculatorScreen()
                }
            }
        }
    }
}

// Hàm format số với dấu phân cách hàng nghìn
private fun formatWithThousandSeparator(input: String): String {
    if (input.isEmpty()) return ""
    
    // Lọc chỉ giữ số
    val digitsOnly = input.filter { it.isDigit() }
    if (digitsOnly.isEmpty()) return ""
    
    // Format với dấu chấm phân cách hàng nghìn
    val number = digitsOnly.toLongOrNull() ?: return digitsOnly
    val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        groupingSeparator = '.'
    }
    val formatter = DecimalFormat("#,###", symbols)
    return formatter.format(number)
}

// Hàm lấy giá trị số từ chuỗi đã format
private fun getNumericValue(formattedValue: String): String {
    return formattedValue.filter { it.isDigit() }
}

@Composable
fun TipCalculatorScreen() {
    var billAmountDisplay by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }
    
    // Lấy giá trị số thuần để tính toán
    val billNumeric = getNumericValue(billAmountDisplay)
    val tip = calculateTip(billNumeric, tipPercent, roundUp)
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Calculate Tip",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start)
        )
        
        // Bill Amount Field - với format hàng nghìn
        EditNumberField(
            label = "Bill Amount",
            value = billAmountDisplay,
            onValueChange = { newValue ->
                // Lấy số mới nhập (bỏ dấu chấm cũ)
                val newDigits = newValue.filter { it.isDigit() }
                // Format lại với dấu phân cách
                billAmountDisplay = formatWithThousandSeparator(newDigits)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Bill"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        // Tip Percentage Field
        EditNumberField(
            label = "Tip Percentage",
            value = tipPercent,
            onValueChange = { newValue ->
                tipPercent = newValue.filter { it.isDigit() || it == '.' }
            },
            leadingIcon = {
                Text(
                    text = "%",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        // Round up switch
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Round up tip?")
            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }
        
        Text(
            text = "Tip Amount: $tip",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun EditNumberField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = leadingIcon,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFFFE0E0),
            focusedContainerColor = Color(0xFFFFD0D0),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )
}

private fun calculateTip(amount: String, tipPercent: String, roundUp: Boolean): String {
    val bill = amount.toDoubleOrNull() ?: 0.0
    val percent = tipPercent.toDoubleOrNull() ?: 0.0
    var tip = bill * percent / 100
    
    if (roundUp) {
        tip = ceil(tip)
    }
    
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipCalculatorPreview() {
    TipCalculatorTheme {
        TipCalculatorScreen()
    }
}
