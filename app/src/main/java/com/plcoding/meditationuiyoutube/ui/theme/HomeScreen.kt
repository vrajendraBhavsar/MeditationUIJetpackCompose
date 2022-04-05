package com.plcoding.meditationuiyoutube.ui.theme

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.data.BottomMenuContent
import com.plcoding.meditationuiyoutube.data.Feature
import com.plcoding.meditationuiyoutube.standardQuadFromTo

val TAG: String = "HomeScreen"

@Composable
fun HomeScreen(context: Context) {
    //Main container - Box
    Box(
        Modifier
            .background(color = DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingsSection()
            ChipSection(context = context, chipList = listOf(
                    "Timer",
                    "Guided",
                    "Courses",
                    "Parents",
                    "Sleep",
                    "Music",
                    "Yoga",
                    "Beginners"
                ))
            CurrentMeditation()
            FeatureSection(listOf(
                    Feature(
                        title = "Sleep Meditation", iconRes = R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping", iconRes = R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island", iconRes = R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sound", iconRes = R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                ), context = context)
        }
        //Navigation bar
        BottomMenu(
            bottomItems = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Meditate", R.drawable.ic_bubble),
                BottomMenuContent("Sleep", R.drawable.ic_moon),
                BottomMenuContent("Music", R.drawable.ic_music),
                BottomMenuContent("Profile", R.drawable.ic_profile)
            ),
            modifier = Modifier.
                    align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BottomMenu(
    bottomItems: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighLightColor: Color = ButtonBlue,    // button color
    activeTextColor: Color = Color.White,    // text color
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        bottomItems.forEachIndexed { index, bottomMenuContent ->
            BottomMenuItem(
                item = bottomMenuContent,
                isSelected = index == selectedItemIndex,
                activeHighLightColor = activeHighLightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false ,
    activeHighLightColor: Color = ButtonBlue,    // button color
    activeTextColor: Color = Color.White,    // text color
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Composable
@Preview
fun GreetingsSection(name: String = "Vraj") {
    Row(    //Contain 2 text vertically + Search icon
        horizontalArrangement = Arrangement.SpaceBetween,    //Separate two row items to top left and top right, and keep space in between
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
//            .clip(RoundedCornerShape(10.dp))
    ) {
        Column( // for 2 vertical texts
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Welcome, $name",
                style = MaterialTheme.typography.h2,
            )
            Text(
                text = "we wish you have a good day",
                style = MaterialTheme.typography.body1
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

//Lazy row to display list of chip-Strings
@Composable
fun ChipSection(context: Context, chipList: List<String> = arrayListOf("Zen", "Keen", "Breeze")) {
    var selectedChip by remember { //State to display currently selected chip
        mutableStateOf(0)   //initially 0 -> First chip is selected
    }
    LazyRow(  // Scrollable lazy row
        modifier = Modifier.fillMaxWidth()
    ) {
        items(chipList.size) {  //items -> Chips
            //we'll design chips here
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(   // This padding is given before applying "background", so it'll create extra "space/padding" which would work like "Margin"
                        start = 15.dp,
                        top = 15.dp,
                        bottom = 15.dp
                    )
                    .clickable {    //onClick()
                        // "it" -> just like Arraylist it starts from 0,1,2,3,4,..
                        selectedChip = it //"it" will give the index/int of the chip item we select, so we'll update "selectedChip" variable.
                        Toast.makeText(context, chipList[it], Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "85:: VRAJTEST selectedChip => $selectedChip")
                    }
                    .clip(RoundedCornerShape(10.dp))    //For Rounded Corners
                    .background(
                        if (selectedChip == it) ButtonBlue  // Only selected chip will have the mentioned color
                        else DarkerButtonBlue   // Color for other chips
                    )
                    .padding( //padding
                        start = 15.dp,
                        end = 15.dp,
                        top = 15.dp,
                        bottom = 15.dp
                    )    //around the text inside button
            ) {
                Text(
                    text = chipList[it],
                    color = TextWhite
                )
            }
        }
    }
}

@Composable
@Preview
fun CurrentMeditation(color: Color = LightRed) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))    //For Rounded Corners
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(
    featureList: List<Feature>,
    context: Context
) { // Params - title String, icon, color for each layer/design
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2), // How many columns do you wanna have in Grid
            contentPadding = PaddingValues(
                start = 7.5.dp,
                end = 7.5.dp,
                bottom = 100.dp
            ), // bottom = 100, to keep space for navigation
            modifier = Modifier
                .fillMaxHeight()//Height -> Match Parent
//                .fillMaxWidth()
        ) {
            items(featureList.size) {
                FeatureSingleItem(feature = featureList[it], context = context)
            }
        }
    }
}

@Composable
fun FeatureSingleItem(feature: Feature, context: Context) {   //Single item of Grid
    // 1 - First dark colored layer
    BoxWithConstraints( // BoxWithConstraints -> so using its "constraints" we can get the size of width/height
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f) // In any screen size, size of Height will stay the same -> means it'll be a Square
            .clip(RoundedCornerShape(10.dp))
            .background(
                feature.darkColor
            )
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight
        // 2 - Second medium colored layer
        //Path of the layer - 2
        val mediumColoredPoint1 = Offset(x = 0f, y = height * 0.3f)
        val mediumColoredPoint2 = Offset(x = width * 0.1f, y = height * 0.35f)
        val mediumColoredPoint3 = Offset(x = width * 0.4f, y = height * 0.05f)
        val mediumColoredPoint4 = Offset(x = width * 0.75f, y = height * 0.7f)
        val mediumColoredPoint5 = Offset(x = width * 1.4f, y = -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(    //Starts a enw path from given co-ordinates
                mediumColoredPoint1.x,
                mediumColoredPoint1.y
            )
            //to draw SMOOTH line from one point to another .. check the custom made helper function..
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            //to connect last point to the first point, so we can color that box/area
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close() // to close the path (Attach back to the starting point)
        }
        // 3 - Third light colored layer
        val lightColoredPoint1 = Offset(x = 0f, y = height * 0.3f)
        val lightColoredPoint2 = Offset(x = width * 0.1f, y = height * 0.4f)
        val lightColoredPoint3 = Offset(x = width * 0.3f, y = height * 0.35f)
        val lightColoredPoint4 = Offset(x = width * 0.65f, y = height.toFloat())
        val lightColoredPoint5 = Offset(x = width * 1.4f, y = -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightColoredPoint1.x, lightColoredPoint1.y) //starting point

            standardQuadFromTo(lightColoredPoint1, lightColoredPoint2)  // another points
            standardQuadFromTo(lightColoredPoint2, lightColoredPoint3)
            standardQuadFromTo(lightColoredPoint3, lightColoredPoint4)
            standardQuadFromTo(lightColoredPoint4, lightColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // We have defined path above, now we'll draw it
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor, blendMode = BlendMode.Modulate
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        //Title + Icon + button
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                lineHeight = 26.sp,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconRes),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp)
                    .align(
                        Alignment.BottomStart
                    )
                    .clickable {
                        if (feature.iconRes.equals(
                                ContextCompat.getDrawable(
                                    context,
                                    R.drawable.ic_headphone
                                )
                            )
                        ) {
                            Log.d(
                                TAG,
                                "feature.iconRes => ${feature.iconRes}, R.drawable.ic_headphone => ${
                                    ContextCompat.getDrawable(
                                        context,
                                        R.drawable.ic_headphone
                                    )
                                }"
                            )
                            Toast
                                .makeText(
                                    context.applicationContext,
                                    "Kindly wear headphones!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        } else {
                            Toast
                                .makeText(
                                    context.applicationContext,
                                    "Opening Video Player..",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    }
            )
            Text(text = "Start",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //Handle click
                        Toast
                            .makeText(
                                context.applicationContext,
                                "Clicked ${feature.title}!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp))
        }
    }
}