package com.example.recyclerviewnasaapi

import android.app.Activity
import android.content.Context
import java.text.SimpleDateFormat
import java.util.*
import android.net.Uri.Builder


class ImageRequester(listeningActivity: Activity) {
    interface ImageRequesterResponse {
        fun receivedNewPhoto(newPhoto: Photo)
    }

    private val calendar: Calendar = Calendar.getInstance()
    private val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
    private val responseListener:ImageRequesterResponse
    private val context: Context
    private val client:OkHttpClient
    var isLoadingData:Boolean = false
    private set
    init {
        responseListener = listeningActivity as ImageRequesterResponse
        context = listeningActivity.applicationContext
        client = OkHttpClient()

    }
    fun getPhoto(){
        val date = dateFormat.format(calendar.time)
        val urlRequest = Builder().scheme(URL_SCHEME)
            .authority(URL_AUTHORITY)
            .appendPath(URL_PATH_1)
            .appendPath(URL_PATH_2)
            .appendQueryParameter(URL_QUERY_PARAM_DATE_KEY, date)
            .appendQueryParameter(URL_QUERY_PARAM_API_KEY,"")
            .build().toString()

        val request = Request.Builder().url(urlRequest).build()
    }
}