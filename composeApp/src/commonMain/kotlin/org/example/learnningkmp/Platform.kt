package org.example.learnningkmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun getBgMainPainter(): Painter
@Composable
expect fun getBgLoginPainter(): Painter
@Composable
expect fun getIconPainter(): Painter
@Composable
expect fun getIconLoginPainter(): Painter

