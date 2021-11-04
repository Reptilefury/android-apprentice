package com.example.recyclerviewnasaapi

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(layoutRes:Int, attachRoot:Boolean = false):View{
   return  LayoutInflater.from(context).inflate(layoutRes, this, attachRoot)
}
