package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
//import org.example.learnningkmp.getBgMenuPainter
import org.example.learnningkmp.getIconPainter
import screens.components.TaxTopAppBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import java.net.URLEncoder
@Composable
fun MenuScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TaxTopAppBar(
                title = "ยกเว้น ลดหย่อน คืนภาษี",
                subtitle = "สำหรับสินค้าที่ส่งออก",
                showActions = true
            )
        },
        containerColor = Color.Transparent,
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(menuItems) { itemText ->
                        val encoded = URLEncoder.encode(itemText, "UTF-8")
                        MenuItem(text = itemText) {
                            navController.navigate("detail/$encoded")
                        }
                    }
                }
            }
        }
    )
}
private val menuItems = listOf(
    "แบบคำขอ ภส. 05-01",
    "แบบรายงานขอยกเว้นเงินนบำรุงกองทุน",
    "แบบคำขอ ภส. 05-01 (ก)",
    "แบบคำขอ ภส. 05-01/1 (ก)",
)


@Composable
fun MenuItem(
    text: String,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF0064D3), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = getIconPainter(),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF333333)
                ),
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Next",
                tint = Color(0xFF333333)
            )
        }
    }
}
