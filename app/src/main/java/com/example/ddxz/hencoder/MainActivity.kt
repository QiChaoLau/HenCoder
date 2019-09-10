package com.example.ddxz.hencoder

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val tag = "henCoder demo"
    }

    lateinit var view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 第一节
        view = View(this)
        logViewId(view)

        // 第二节
        val privateInstance = PrivateInstance.newInstance()

        val maxCount = 100_000

        //Array 方式
        val timeArrayStart = System.currentTimeMillis()
        val array = Array(maxCount) {it}
        var arrayCount = 0
        for (i in array) {
            arrayCount += i
        }
        val num1 = arrayCount / array.size
        val timeArrayEnd = System.currentTimeMillis()
        Log.d(tag, "Array 平均值：$num1 用时：${timeArrayEnd - timeArrayStart}ms")

        //IntArray 方式
        val timeIntArrayStart = System.currentTimeMillis()
        val intArray = IntArray(maxCount) {it}
        var intArrayCount = 0
        for (i in intArray) {
            intArrayCount += i
        }
        val num2 = intArrayCount / array.size
        val timeIntArrayEnd = System.currentTimeMillis()
        Log.d(tag, "IntArray 平均值：$num2 用时：${timeIntArrayEnd - timeIntArrayStart}ms")

        //List 方式
        val timeListStart = System.currentTimeMillis()
        val list = List(maxCount) {it}
//        val list = mutableListOf<Int>()
//        for (i in 0..maxCount) {
//            list.add(i)
//        }
        var listCount = 0
        for (item in list) {
            listCount += item
        }
        val num3 = listCount / list.size
        val timeListEnd = System.currentTimeMillis()
        Log.d("henCoder demo", "List 平均值：$num3 用时：${timeListEnd - timeListStart}ms")


        // 第三节
        CustomStudent(name = null).show()

        val list2 = listOf(21, 40, 11, 33, 78)
        val filter = list2.filter {
            it % 3 == 0
        }
        Log.d(tag, filter.toString())

        // 第四节
        fill(arrayOfNulls(1), Button(this))
        copy(arrayOf(Button(this)), arrayOfNulls(1))
    }

    fun logViewId (view : View?) = view?.id ?: 0

    fun fill(array : Array<in TextView>, btn : Button) {
        array[0] = btn
    }

    fun copy(array1: Array<out TextView>, array2: Array<in TextView>) {
        for (i in array1.indices) {
            array2[i] = array1[i]
        }
    }
}
