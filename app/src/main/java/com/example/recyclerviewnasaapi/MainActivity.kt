package com.example.recyclerviewnasaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private  lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter:RecyclerAdpter
    private var photosList:ArrayList<Photo> = ArrayList()
    private lateinit var imageRequester:ImageRequester

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)

       RecyclerView.layoutManager = linearLayoutManager
         adapter = RecyclerAdpter(photosList)
        RecyclerView.adapter = adapter
        imageRequester = ImageRequester(this)


    }

    override fun onStart() {
        super.onStart()
        if(photosList.size == 0){
            requestPhoto()

        }
    }
    private fun requestPhoto(){
        try {
            imageRequester.getPhoto()
        } catch (e:IOException){
            e.printStackTrace()
        }
    }
    fun receivedNewPhoto(newPhoto: ContactsContract.Contacts.Photo){
        runOnUiThread{
            photosList.add(newPhoto)
            adapter.notifyItemInserted(photoList.size-1)
        }
    }
}