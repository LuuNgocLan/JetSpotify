package com.jetspotify.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane

/**
 * Adaptive List-Detail layout component using Accompanist's TwoPane.
 * This component automatically adapts to different screen sizes:
 * - A single pane with navigation for compact window sizes (phones)
 * - Two panes side by side for medium and expanded window sizes (tablets, desktops)
 * 
 * @param windowWidthSizeClass The current window width size class
 * @param listContent The content to show in the list pane
 * @param detailContent The content to show in the detail pane
 * @param showDetailOnly When true, only the detail content is shown (for compact mode)
 * @param hasDetailContent Whether there is detail content to show
 * @param listWeight The weight of the list pane in two-pane mode (default: 0.33f)
 * @param modifier Modifier to be applied to the layout
 */
@Composable
fun AdaptiveListDetailLayout(
    windowWidthSizeClass: WindowWidthSizeClass,
    listContent: @Composable () -> Unit,
    detailContent: @Composable () -> Unit,
    showDetailOnly: Boolean = false,
    hasDetailContent: Boolean = true,
    listWeight: Float = 0.33f,
    modifier: Modifier = Modifier
) {
    // For compact mode, we'll show either list or detail
    // For other modes, we'll use TwoPane to show both simultaneously
    when (windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            // For phone-sized screens, show either list or detail
            Box(modifier = modifier.fillMaxSize()) {
                when {
                    showDetailOnly && hasDetailContent -> detailContent()
                    else -> listContent()
                }
            }
        }
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Expanded -> {
            // For larger screens, use TwoPane to show both list and detail side by side
            TwoPane(
                first = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surface)
                    ) {
                        listContent()
                    }
                },
                second = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        if (hasDetailContent) {
                            detailContent()
                        }
                    }
                },
                strategy = HorizontalTwoPaneStrategy(splitFraction = listWeight),
                displayFeatures = emptyList(), // Simplified for now, no foldable support
                modifier = modifier
            )
        }
        else -> {
            // Fallback for any other window size class
            Box(modifier = modifier.fillMaxSize()) {
                when {
                    showDetailOnly && hasDetailContent -> detailContent()
                    else -> listContent()
                }
            }
        }
    }
}
