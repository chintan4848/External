package com.example.myapplication1

data class fruit(var fr_name:String,var fr_des:String,var fr_price:Int) {

    var id:Int=0
    constructor(id:Int,fr_name: String,fr_des: String,fr_price: Int):this(fr_name,fr_des,fr_price)
    {
        this.id=id
    }
}

