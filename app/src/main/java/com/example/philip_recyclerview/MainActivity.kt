package com.example.philip_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toDoList = mutableListOf(
            ToDo("FollowReptilefury", false),
            ToDo("Check out My Repo", false),
            ToDo("Check out my linkedInProfile", false),
            ToDo("Used to do Flutter", false),
            ToDo("Working on the brain", false),
            ToDo("Moving to Switzerland soon",false),
            )
        val adapter = ToDoAdapter(toDoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

         btnToDo.setOnClickListener {
             val  title = etToDo.text.toString()
             val  toDo = ToDo(title, false)
             toDoList.add(toDo)
             //adapter.notifyDataSetChanged()
             adapter.notifyItemInserted(toDoList.size -1 )
         }
    }
}