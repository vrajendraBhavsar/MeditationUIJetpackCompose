package com.plcoding.meditationuiyoutube.ui.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.model.FilterHome
import com.plcoding.meditationuiyoutube.model.LocationHome
import com.plcoding.meditationuiyoutube.model.TopBrandData
import com.plcoding.meditationuiyoutube.ui.theme.ZomatoBabyRed
import com.plcoding.meditationuiyoutube.ui.theme.ZomatoRed

@Composable
@Preview
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            TopSpace()
            LocationSection()
            SearchBar()
            FilterSection()
            TopBrandSection()
        }
    }
}

@Composable
fun TopSpace() {
    Spacer(
        modifier = Modifier
            .height(44.dp)
    )
}

@Composable
fun LocationSection(
    locationHome: LocationHome = LocationHome(
        landMark = "Baker Street",
        address = "2255 Kihn Ranch Suite 496, West Anaville, Oregon"
    )
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "location",
                    modifier = Modifier
                        .size(26.dp)
                        .align(CenterVertically),
                )
                Text(
                    text = locationHome.landMark,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 5.dp),
                    fontSize = 20.sp
                )
            }
            Text(
                text = locationHome.address,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.width(300.dp),
                fontSize = 12.sp
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "menu",
            modifier = Modifier
                .size(30.dp)
                .align(CenterVertically),
        )
    }
}

@Composable
fun SearchBar() {
    TopAppBar(
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(width = 0.4.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp))
            .size(height = 50.dp, width = 500.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search",
                modifier = Modifier
                    .padding(5.dp)
                    .size(20.dp)
            )
            Text(
                text = "Restaurant name or a dish...",
                fontSize = 12.sp,
                color = Color.Gray,
            )
        }
    }
}

@Composable
fun FilterSection(
    filterList: List<FilterHome> = listOf(
        FilterHome("Pure Veg"),
        FilterHome("Fast Delivery"),
        FilterHome("New Arrivals"),
        FilterHome("Rating 4.0+"),
        FilterHome("Take Away"),
    )
) {
    var selectedFilterItem by remember {
        mutableStateOf(0)
    }
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(filterList.size) {    //item -> chip
            //We will design chip here
            Box(
                contentAlignment = Center,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp)
                    .border(
                        color = if (selectedFilterItem == it) ZomatoRed else Color.Gray,
                        width = 0.5.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        selectedFilterItem = it
                        //Toast for the click
                    }
                    .background(if (selectedFilterItem == it) ZomatoBabyRed else Color.White)
                    .padding( //padding
                        top = 10.dp,
                        bottom = 10.dp
                    )
                    .height(20.dp)//around the text inside button
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = filterList[it].filterItem,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 10.dp),
                        fontSize = 14.sp
                    )
                    if (selectedFilterItem == it) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cancel),
                            contentDescription = "cancel",
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .size(12.dp)
                                .align(CenterVertically)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TopBrandSection(
    topBrandList: List<TopBrandData> = listOf(
        TopBrandData(
            brandImg = R.drawable.ic_burger,
            discountPercent = 70,
            brandName = "Burger Queen",
            approxDeliveryTime = "10-20 mins"
        ),
        TopBrandData(
            brandImg = R.drawable.ic_ramen,
            discountPercent = 40,
            brandName = "Raju Ramen",
            approxDeliveryTime = "20-30 mins"
        ),
        TopBrandData(
            brandImg = R.drawable.ic_donut,
            discountPercent = 10,
            brandName = "Do not Touch Adda",
            approxDeliveryTime = "40-45 mins"
        ),
        TopBrandData(
            brandImg = R.drawable.ic_pizza,
            discountPercent = 50,
            brandName = "Kaminoz",
            approxDeliveryTime = "10-15 mins"
        ),
        TopBrandData(
            brandImg = R.drawable.ic_burger,
            discountPercent = 30,
            brandName = "McMickey",
            approxDeliveryTime = "30-50 mins"
        ),
    )
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            //Top Brand and See all..
            Text(text = "Top Brands for you", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "See all", fontWeight = FontWeight.Bold)
                Icon(
                    painter = painterResource(id = R.drawable.arrow_circle),
                    contentDescription = "arrow circle",
                    modifier = Modifier
                        .size(12.dp)
                        .padding(start = 2.dp)
                        .size(12.dp)
                )
            }
        }
        // Top Brand Items
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(topBrandList.size) {
                TopBrandItem(topBrandData = topBrandList[it])
            }
        }
    }
}

@Composable
@Preview
fun TopBrandItem(
    topBrandData: TopBrandData = TopBrandData(
        brandImg = R.drawable.ic_burger,
        discountPercent = 70,
        brandName = "Burger Queen",
        approxDeliveryTime = "10-20 mins"
    ),
) {
    Box {
        Image(
            painter = painterResource(id = topBrandData.brandImg),
            contentDescription = topBrandData.brandName,
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .padding(start = 5.5.dp)
                .size(86.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(0.5.dp, Color.Gray, CircleShape)   // add a border (optional)

        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .background(ZomatoBabyRed)
            .padding(top = 72.dp)
    ) {
/*        Image(
            painter = painterResource(id = topBrandData.brandImg),
            contentDescription = topBrandData.brandName,
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(86.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(0.5.dp, Color.Gray, CircleShape)   // add a border (optional)
        )*/
        Row(
            modifier = Modifier
                .size(70.dp, 24.dp)
                .border(0.5.dp, Color.Gray, shape = RoundedCornerShape(5.dp))
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${topBrandData.discountPercent}% OFF",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(CenterVertically)
            )
        }
        Text(
            text = topBrandData.brandName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.align(CenterHorizontally)
        )
        Text(
            text = topBrandData.approxDeliveryTime,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.align(CenterHorizontally),
            color = Color.Gray
        )
    }
}
