package com.sedogapps.rentandroam.presentation.features.onboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import com.sedogapps.rentandroam.R
import com.google.accompanist.pager.PagerState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.sedogapps.rentandroam.presentation.utils.ScreenDimensions


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    onNavigateToLogin:() -> Unit
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()


    val items = listOf(
        OnboardingItem(
            imageLight = R.drawable.onboard1_light,
            imageDark = R.drawable.onboard1_dark,
            title = buildAnnotatedString {
                withStyle(style = SpanStyle()) {
                    append(
                        stringResource(R.string.onboard_title1_part1)
                    )
                }
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append(
                        stringResource(R.string.onboard_title1_part2)
                    )
                }
                withStyle(style = SpanStyle()) {
                    append(
                        stringResource(R.string.onboard_title1_part3)
                    )
                }
            },
            description = stringResource(R.string.onboard_description1)
        ),
        OnboardingItem(
            imageLight = R.drawable.onboard2_light,
            imageDark = R.drawable.onboard2_dark,
            title = buildAnnotatedString {
                withStyle(style = SpanStyle()) {
                    append(
                        stringResource(R.string.onboard_title2_part1)
                    )
                }
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    stringResource(R.string.onboard_title2_part2)
                }
            },
            description = stringResource(R.string.onboard_description2)
        ),
        OnboardingItem(
            imageLight = R.drawable.onboard3_light,
            imageDark = R.drawable.onboard3_dark,
            title = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append(
                        stringResource(R.string.onboard_title3_part1)
                    )

                }
                withStyle(style = SpanStyle()) {
                    append(
                        stringResource(R.string.onboard_title3_part2)
                    )

                }
            },
            description = stringResource(R.string.onboard_description3)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.onboard_column_padding))
    ) {
        if (pagerState.currentPage < items.size - 1) {
            TextButton(
                onClick = {
                    onNavigateToLogin()
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(stringResource(R.string.onboard_skip_all), color = Color.Blue)
            }
        }


        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            itemSpacing = dimensionResource(id = R.dimen.onboard_horizontalpager_padding)
        ) { page ->
            OnboardingPage(item = items[page], pagerState = pagerState, page = page)
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(dimensionResource(id = R.dimen.onboard_horizontalpager_padding)),
            activeColor = Color.Blue,
            inactiveColor = Color.Gray
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.onboard_row_padding_top), bottom = dimensionResource(R.dimen.onboard_row_padding_bottom)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (pagerState.currentPage > 0) {
                TextButton(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }) {
                    Text(
                        stringResource(R.string.onboard_back), color = Color.Blue)
                }
            }


            Button(
                onClick = {
                    if (pagerState.currentPage < items.size - 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        onNavigateToLogin()

                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(
                    text = if (pagerState.currentPage >= items.size - 1) stringResource(R.string.onboard_finish) else stringResource(R.string.onboard_forward),
                    color = Color.White
                )
            }


        }
    }
}

@OptIn(
    ExperimentalPagerApi::class
)
@Composable
fun OnboardingPage(item: OnboardingItem, pagerState: PagerState, page: Int) {
    val offset = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    val screenWidth = ScreenDimensions.screenWidth.current
    val screenHeight = ScreenDimensions.screenHeight.current

    LaunchedEffect(key1 = pagerState.currentPage) {
        if (pagerState.currentPage == page) {
            offset.animateTo(
                targetValue = 0f,
                animationSpec = androidx.compose.animation.core.tween(
                    durationMillis = 500,
                    easing = androidx.compose.animation.core.LinearOutSlowInEasing
                )
            )
        } else {
            offset.animateTo(
                targetValue = if (pagerState.currentPage > page) -1f else 1f,
                animationSpec = androidx.compose.animation.core.tween(
                    durationMillis = 500,
                    easing = androidx.compose.animation.core.LinearOutSlowInEasing
                )
            )
        }
    }

    val density = LocalDensity.current
    val pageOffset = (
            (pagerState.currentPage - page) + offset.value
            ) * density.density

    Column(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                translationX = pageOffset
                transformOrigin = TransformOrigin(0f, 0f)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(
                id = if (isSystemInDarkTheme()) item.imageDark else item.imageLight
            ),            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.5f)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(
            dimensionResource(R.dimen.onboard_spacer_height)
        ))
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = (screenWidth.value * 0.05f).sp
        )
        Spacer(modifier = Modifier.height(
            dimensionResource(R.dimen.onboard_spacer_height)
        ))
        Text(
            text = item.description,
            textAlign = TextAlign.Center,
            fontSize = (screenWidth.value * 0.035f).sp
        )
    }
}

