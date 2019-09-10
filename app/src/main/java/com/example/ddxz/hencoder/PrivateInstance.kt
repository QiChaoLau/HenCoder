package com.example.ddxz.hencoder

/**
 * Created by lqc on 2019/9/10.
 */
class PrivateInstance private constructor() {

    companion object {
        fun newInstance () = PrivateInstance()
    }
}