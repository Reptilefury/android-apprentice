package com.example.recyclerviewnasaapi

import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdpter(private val photos: ArrayList<ContactsContract.Contacts.Photo>): RecyclerView.Adapter<RecyclerAdpter.PhotoHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdpter.PhotoHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerAdpter.PhotoHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = photos.size
   class  PhotoHolder(v:View):RecyclerView.ViewHolder(v), View.OnClickListener{

         private val view:View = v
         private  val photo: ContactsContract.Contacts.Photo? = null

       init {
           v.setOnClickListener(this)
       }

       override fun onClick(v: View?) {
           Log.d("RecyclerView","Click!")
       }
       companion object{
           private  val PHOTO_KEY = "PHOTO"
       }

   }
}