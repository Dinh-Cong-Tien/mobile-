import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BusinessCardApp() {
    // Sử dụng mã hex cho màu xanh lục của Android như hướng dẫn
    val androidGreen = Color(0xFF3DDC84)
    val backgroundCard = Color(0xFFD2E8D4) 

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundCard)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Phần 1 (Phần logic trên): Biểu tượng, Tên và Chức danh
        Column(
            modifier = Modifier
                .weight(1f) 
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Hình ảnh biểu tượng (Thay R.drawable.android_logo bằng ID thực tế của bạn)
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF073042))
            ) {
                // Ví dụ sử dụng Icon thay cho Image nếu chưa có file hình ảnh
                Icon(
                    imageVector = Icons.Default.Share, 
                    contentDescription = null,
                    tint = androidGreen,
                    modifier = Modifier.fillMaxSize().padding(8.dp)
                )
            }
            Text(
                text = "ABC",
                fontSize = 40.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = "Danh thiếp",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = androidGreen
            )
        }

        // Phần 2 (Phần logic dưới): Thông tin liên hệ
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactRow(icon = Icons.Default.Phone, text = "+84 123 456 789", tint = androidGreen)
            ContactRow(icon = Icons.Default.Share, text = "@socialmedia", tint = androidGreen)
            ContactRow(icon = Icons.Default.Email, text = "abc@gmail.com", tint = androidGreen)
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, tint: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, top = 8.dp, bottom = 8.dp), // Căn lề trái để tạo độ thoáng
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}