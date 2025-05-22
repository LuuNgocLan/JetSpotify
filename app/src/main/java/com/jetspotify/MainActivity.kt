/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jetspotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jetspotify.ui.main.JetSpotifyApp
import com.jetspotify.ui.theme.JetSpotifyTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetSpotifyTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(this)
                    JetSpotifyApp(
                            windowSize = windowSize.widthSizeClass,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyAppCompactPreview() {
    JetSpotifyTheme {
        Surface {
            JetSpotifyApp(
                    windowSize = WindowWidthSizeClass.Compact,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppMediumPreview() {
    JetSpotifyTheme {
        Surface {
            JetSpotifyApp(
                    windowSize = WindowWidthSizeClass.Medium,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 840)
@Composable
fun ReplyAppExpandedPreview() {
    JetSpotifyTheme {
        Surface {
            JetSpotifyApp(
                    windowSize = WindowWidthSizeClass.Expanded,
            )
        }
    }
}
