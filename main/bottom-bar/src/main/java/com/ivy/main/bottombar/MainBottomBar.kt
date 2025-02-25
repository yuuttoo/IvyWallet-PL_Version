package com.ivy.main.bottombar

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ivy.design.animation.slideInBottom
import com.ivy.design.animation.slideOutBottom
import com.ivy.design.l0_system.UI
import com.ivy.design.l1_buildingBlocks.B2
import com.ivy.design.l1_buildingBlocks.IconRes
import com.ivy.design.l1_buildingBlocks.SpacerHor
import com.ivy.design.l1_buildingBlocks.SpacerVer
import com.ivy.design.l3_ivyComponents.Feeling
import com.ivy.design.l3_ivyComponents.Visibility
import com.ivy.design.l3_ivyComponents.button.ButtonSize
import com.ivy.design.l3_ivyComponents.button.IvyButton
import com.ivy.design.util.ComponentPreview
import com.ivy.design.util.consumeClicks
import com.ivy.resources.R

enum class Tab {
    Home, Accounts
}

@Composable
fun BoxScope.MainBottomBar(
    visible: Boolean,
    selectedTab: Tab,
    modifier: Modifier = Modifier,
    onActionClick: (Tab) -> Unit,
    onHomeClick: () -> Unit,
    onAccountsClick: () -> Unit,
) {
    AnimatedVisibility(
        modifier = modifier
            .align(Alignment.BottomCenter)
            .systemBarsPadding()
            .padding(bottom = 8.dp),
        visible = visible,
        enter = slideInBottom() + fadeIn(),
        exit = slideOutBottom() + fadeOut(),
    ) {
        BottomBarRow(
            selectedTab = selectedTab,
            onActionClick = onActionClick,
            onHomeClick = onHomeClick,
            onAccountsClick = onAccountsClick
        )
    }
}

@Composable
private fun BottomBarRow(
    selectedTab: Tab,
    modifier: Modifier = Modifier,
    onActionClick: (Tab) -> Unit,
    onHomeClick: () -> Unit,
    onAccountsClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = UI.colors.medium.copy(alpha = 0.9f),
                shape = UI.shapes.rounded
            )
            .border(1.dp, UI.colors.primary, UI.shapes.rounded)
            .consumeClicks()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Tab(
            text = stringResource(R.string.home),
            selected = selectedTab == Tab.Home,
            icon = R.drawable.ic_home,
            modifier = Modifier.weight(1f),
            onClick = onHomeClick
        )
        SpacerHor(width = 4.dp)
        ActionButton {
            onActionClick(selectedTab)
        }
        SpacerHor(width = 4.dp)
        Tab(
            text = stringResource(R.string.accounts),
            selected = selectedTab == Tab.Accounts,
            icon = R.drawable.ic_accounts,
            modifier = Modifier.weight(1f),
            onClick = onAccountsClick,
        )
    }
}


@Composable
private fun Tab(
    text: String,
    selected: Boolean,
    @DrawableRes
    icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .clip(UI.shapes.rounded)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconRes(
            icon = icon,
            tint = if (selected) UI.colors.primary else UI.colorsInverted.pure,
        )
        if (selected) {
            SpacerVer(height = 8.dp)
            B2(
                text = text,
                color = UI.colors.primary
            )
        }
    }
}

@Composable
private fun ActionButton(
    onClick: () -> Unit
) {
    IvyButton(
<<<<<<< HEAD
<<<<<<< HEAD
        modifier = Modifier
            .size(52.dp)
            .semantics {
                contentDescription = "Add new transaction"
            },
=======
        modifier = Modifier.size(52.dp).testTag("Hello"),
>>>>>>> parent of 2a3f657 (Initial test setup for course)
=======
        modifier = Modifier.size(52.dp).testTag("Hello"),
>>>>>>> parent of 2a3f657 (Initial test setup for course)
//        modifier = Modifier.pointerInput(Unit) {
//            detectDragGestures(
//                onDragCancel = {
//                    dragOffset = Offset.Zero
//                },
//                onDragEnd = {
//                    dragOffset = Offset.Zero
//                },
//                onDrag = { _, dragAmount ->
//                    dragOffset += dragAmount
//
//                    val horizontalThreshold = 40
//                    val verticalThreshold = 60
//
//                    when {
//                        abs(dragOffset.x) < horizontalThreshold &&
//                                dragOffset.y < -verticalThreshold -> {
//                            // swipe up
//                            dragOffset = Offset.Zero // prevent double open of the screen
//                            onSwipeUp()
//                        }
//                        dragOffset.x < -horizontalThreshold &&
//                                dragOffset.y < -verticalThreshold -> {
//                            //swipe up left
//                            dragOffset = Offset.Zero // prevent double open of the screen
//                            onSwipeDiagonalLeft()
//                        }
//                        dragOffset.x > horizontalThreshold &&
//                                dragOffset.y < -verticalThreshold -> {
//                            // swipe up right
//                            dragOffset = Offset.Zero // prevent double open of the screen
//                            onSwipeDiagonalRight()
//                        }
//                    }
//                }
//            )
//        },
        size = ButtonSize.Small,
        visibility = Visibility.Focused,
        feeling = Feeling.Positive,
        text = null,
        icon = R.drawable.ic_round_add_24,
        onClick = onClick
    )
}


// region Previews
@Preview
@Composable
private fun Preview_Home() {
    ComponentPreview {
        MainBottomBar(
            visible = true,
            modifier = Modifier.padding(horizontal = 16.dp),
            selectedTab = Tab.Home,
            onActionClick = {},
            onHomeClick = { },
            onAccountsClick = {}
        )
    }
}

@Preview
@Composable
private fun Preview_Account() {
    ComponentPreview {
        MainBottomBar(
            visible = true,
            modifier = Modifier.padding(horizontal = 16.dp),
            selectedTab = Tab.Accounts,
            onActionClick = {},
            onHomeClick = { },
            onAccountsClick = {}
        )
    }
}
// endregion