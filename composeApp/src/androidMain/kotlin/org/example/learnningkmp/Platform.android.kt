package org.example.learnningkmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource


@Composable
actual fun getBgLoginPainter(): Painter {
    return painterResource(id = R.drawable.bg_login)
}
@Composable
actual fun getBgMainPainter(): Painter {
    return painterResource(id = R.drawable.bg_main)
}

@Composable
actual fun getIconPainter(): Painter {
    return painterResource(id = R.drawable.icon_document)
}

@Composable
actual fun getIconLoginPainter(): Painter {
    return painterResource(id = R.drawable.icon_login)
}

