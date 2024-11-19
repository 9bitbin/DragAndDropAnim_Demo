// Original Code 1

//@file:OptIn(ExperimentalFoundationApi::class)
//
//package edu.farmingdale.draganddropanim_demo
//
//import android.content.ClipData
//import android.content.ClipDescription
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.scaleIn
//import androidx.compose.animation.scaleOut
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.draganddrop.dragAndDropSource
//import androidx.compose.foundation.draganddrop.dragAndDropTarget
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draganddrop.DragAndDropEvent
//import androidx.compose.ui.draganddrop.DragAndDropTarget
//import androidx.compose.ui.draganddrop.DragAndDropTransferData
//import androidx.compose.ui.draganddrop.mimeTypes
//import androidx.compose.foundation.Canvas
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.material3.Icon
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.OffsetEffect
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//
//
//
//@Composable
//fun DragAndDropBoxes(modifier: Modifier = Modifier) {
//    Column(modifier = Modifier.fillMaxSize()) {
//
//        Row(
//            modifier = modifier
//                .fillMaxWidth().weight(0.2f)
//        ) {
//            val boxCount = 4
//            var dragBoxIndex by remember {
//                mutableIntStateOf(0)
//            }
//
//            repeat(boxCount) { index ->
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .fillMaxHeight()
//                        .padding(10.dp)
//                        .border(1.dp, Color.Black)
//                        .dragAndDropTarget(
//                            shouldStartDragAndDrop = { event ->
//                                event
//                                    .mimeTypes()
//                                    .contains(ClipDescription.MIMETYPE_TEXT_PLAIN)
//                            },
//                            target = remember {
//                                object : DragAndDropTarget {
//                                    override fun onDrop(event: DragAndDropEvent): Boolean {
//
//                                        dragBoxIndex = index
//                                        return true
//                                    }
//                                }
//                            }
//                        ),
//                    contentAlignment = Alignment.Center
//                ) {
//                    this@Row.AnimatedVisibility(
//                        visible = index == dragBoxIndex,
//                        enter = scaleIn() + fadeIn(),
//                        exit = scaleOut() + fadeOut()
//                    ) {
//                        //ToDo 4: replace the "right" with a Icon ArrowForward
//                        Icon(imageVector = Icons.Default.ArrowForward,
//                            contentDescription = "",
//
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .dragAndDropSource {
//                                    detectTapGestures(
//                                        onLongPress = { offset ->
//                                            startTransfer(
//                                                transferData = DragAndDropTransferData(
//                                                    clipData = ClipData.newPlainText(
//                                                        "text",
//                                                        ""
//                                                    )
//                                                )
//                                            )
//                                        }
//                                    )
//                                }
//                        )
//                    }
//                }
//            }
//        }
//
//
//        Canvas(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(0.8f)
//                .background(Color.Red)
//
//        ) {
//            //  drawRect(Color.Blue, topleft = Offset( 100f, 300f), size = Size(100f, 100f))
//            //ToDo 3: make the circle into a rectangel (square)
//            drawRect(Color.Blue, topLeft = Offset(100f, 300f), size = Size(100f,100f))
//        }
//    }
//}


//
//Modified code 2
//
//@file:OptIn(ExperimentalFoundationApi::class)
//
//package edu.farmingdale.draganddropanim_demo
//
//import android.content.ClipData
//import android.content.ClipDescription
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.fadeIn
//import androidx.compose.animation.fadeOut
//import androidx.compose.animation.scaleIn
//import androidx.compose.animation.scaleOut
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.draganddrop.dragAndDropSource
//import androidx.compose.foundation.draganddrop.dragAndDropTarget
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Slider
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.graphics.drawscope.rotate
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.material3.Icon
//import androidx.compose.ui.draganddrop.DragAndDropEvent
//import androidx.compose.ui.draganddrop.DragAndDropTarget
//import androidx.compose.ui.draganddrop.DragAndDropTransferData
//import androidx.compose.ui.draganddrop.mimeTypes
//
//@Composable
//fun DragAndDropBoxes(modifier: Modifier = Modifier) {
//    var rotationAngle by remember { mutableStateOf(0f) } // State to hold the rotation angle
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Row(
//            modifier = modifier
//                .fillMaxWidth()
//                .weight(0.2f)
//        ) {
//            val boxCount = 4
//            var dragBoxIndex by remember {
//                mutableStateOf(0)
//            }
//
//            repeat(boxCount) { index ->
//                Box(
//                    modifier = Modifier
//                        .weight(1f)
//                        .fillMaxHeight()
//                        .padding(10.dp)
//                        .border(1.dp, Color.Black)
//                        .dragAndDropTarget(
//                            shouldStartDragAndDrop = { event ->
//                                event
//                                    .mimeTypes()
//                                    .contains(ClipDescription.MIMETYPE_TEXT_PLAIN)
//                            },
//                            target = remember {
//                                object : DragAndDropTarget {
//                                    override fun onDrop(event: DragAndDropEvent): Boolean {
//                                        dragBoxIndex = index
//                                        return true
//                                    }
//                                }
//                            }
//                        ),
//                    contentAlignment = Alignment.Center
//                ) {
//                    this@Row.AnimatedVisibility(
//                        visible = index == dragBoxIndex,
//                        enter = scaleIn() + fadeIn(),
//                        exit = scaleOut() + fadeOut()
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.ArrowForward,
//                            contentDescription = "",
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .dragAndDropSource {
//                                    detectTapGestures(
//                                        onLongPress = { offset ->
//                                            startTransfer(
//                                                transferData = DragAndDropTransferData(
//                                                    clipData = ClipData.newPlainText(
//                                                        "text",
//                                                        ""
//                                                    )
//                                                )
//                                            )
//                                        }
//                                    )
//                                }
//                        )
//                    }
//                }
//            }
//        }
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(0.8f)
//                .background(Color.Red)
//        ) {
//            // Canvas for the rectangle
//            Canvas(modifier = Modifier.fillMaxSize()) {
//                rotate(degrees = rotationAngle) {
//                    drawRect(
//                        color = Color.Blue,
//                        topLeft = Offset(
//                            size.width / 2 - 50f, // Center the rectangle horizontally
//                            size.height / 2 - 50f // Center the rectangle vertically
//                        ),
//                        size = Size(100f, 100f) // Rectangle size
//                    )
//                }
//            }
//
//            // Slider to control the rotation angle
//            Column(
//                modifier = Modifier.align(Alignment.BottomCenter),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Rotation: ${rotationAngle.toInt()}°",
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//                Slider(
//                    value = rotationAngle,
//                    onValueChange = { rotationAngle = it },
//                    valueRange = 0f..360f,
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth(0.8f)
//                )
//            }
//        }
//    }
//}
//

//modified 3

@file:OptIn(ExperimentalFoundationApi::class)

package edu.farmingdale.draganddropanim_demo

import android.content.ClipData
import android.content.ClipDescription
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.draganddrop.mimeTypes
import androidx.compose.animation.core.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material3.Icon

@Composable
fun DragAndDropBoxes(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(0.2f)
        ) {
            val boxCount = 4
            var dragBoxIndex by remember { mutableStateOf(0) }

            repeat(boxCount) { index ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(10.dp)
                        .border(1.dp, Color.Black)
                        .dragAndDropTarget(
                            shouldStartDragAndDrop = { event ->
                                event
                                    .mimeTypes()
                                    .contains(ClipDescription.MIMETYPE_TEXT_PLAIN)
                            },
                            target = remember {
                                object : DragAndDropTarget {
                                    override fun onDrop(event: DragAndDropEvent): Boolean {
                                        dragBoxIndex = index
                                        return true
                                    }
                                }
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    this@Row.AnimatedVisibility(
                        visible = index == dragBoxIndex,
                        enter = scaleIn() + fadeIn(),
                        exit = scaleOut() + fadeOut()
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize()
                                .dragAndDropSource {
                                    detectTapGestures(
                                        onLongPress = { offset ->
                                            startTransfer(
                                                transferData = DragAndDropTransferData(
                                                    clipData = ClipData.newPlainText(
                                                        "text",
                                                        ""
                                                    )
                                                )
                                            )
                                        }
                                    )
                                }
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .background(Color.Red)
        ) {
            // Canvas for the rectangle with automatic rotation
            Canvas(modifier = Modifier.fillMaxSize()) {
                rotate(degrees = rotationAngle) {
                    drawRect(
                        color = Color.Blue,
                        topLeft = Offset(
                            size.width / 2 - 50f, // Center the rectangle horizontally
                            size.height / 2 - 50f // Center the rectangle vertically
                        ),
                        size = Size(100f, 100f) // Rectangle size
                    )
                }
            }
        }
    }
}
