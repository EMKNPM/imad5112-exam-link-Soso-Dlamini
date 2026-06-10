package com.example.campsitecommander

data class Campsiteitems(

    //store category to of the items (e.g. Shelter, Food, Safety)
    val category: String,

    //Store the item that under those category(e.g. Tent, Marshmallows, Flashlights)
    val itemName: String,

    //Store the quantity of how much they would like to purchase
    val quantity: Int = 0,

    //Store the comments based on the item purchase
    val comments: String =""
)
