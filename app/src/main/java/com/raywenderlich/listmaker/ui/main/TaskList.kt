package com.raywenderlich.listmaker.ui.main

import android.content.Context
import android.preference.PreferenceManager
import androidx.core.content.contentValuesOf

class TaskList(val name: String, val taskList: ArrayList<String> = ArrayList<String>()) {

}

class ListDataManager(context: Context){
    fun  saveList(List:TaskList){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPreferences.putStringSet(list.name, list.tasks.toHashSet())
        sharedPreferences.apply()


    }

    fun readLists():ArrayList<TaskList>{
        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        val sharedPreferenceContents = sharedPreferences.all
        val taskLists = ArrayList<TaskList>()
        for(taskList in sharedPreferenceContents){
            val itemsHashSet = taskList.value as HashSet<String>
            val list = TaskList(taskList.key, ArrayList(itemsHashSet))
            taskList.add(list)
        }
        return  taskLists
    }
}