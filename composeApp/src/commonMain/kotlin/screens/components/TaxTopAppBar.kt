package screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaxTopAppBar(
    title: String,
    subtitle: String? = null,
    onBack: (() -> Unit)? = null,
    showActions: Boolean = true
) {
    TopAppBar(
        title = {
            Column {
                Text(
                    title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.SemiBold
                    )
                )
                subtitle?.let {
                    Text(
                        it,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color(0xFF000000)
                        )
                    )
                }
            }
        },
        navigationIcon = {
            onBack?.let {
                IconButton(onClick = it) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "ย้อนกลับ")
                }
            }
        },
        actions = {
            if (showActions) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Notifications, contentDescription = "แจ้งเตือน")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Person, contentDescription = "โปรไฟล์")
                }
            }
        }
    )
}



