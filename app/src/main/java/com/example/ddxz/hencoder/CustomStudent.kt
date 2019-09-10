package com.example.ddxz.hencoder

import android.util.Log

class CustomStudent (val name : String? = "defaultName", val age : Int = 0) {

    var mType = 0
    var mCanWork = false

    constructor(name : String, age : Int, type : Int) : this(name, age) {
        mType = type
    }

    constructor(name : String, age : Int, type : Int, canWork : Boolean) : this(name, age) {
        mType = type
        mCanWork = canWork
    }

    fun show () {
        Log.d("henCoder demo", "name:$name age:$age type:$mType canWork:$mCanWork")
    }
}