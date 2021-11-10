package com.raywenderlich.listmaker

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.Global.getString
import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.DialogTitle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.raywenderlich.listmaker.ui.main.MainFragment


class MainActivity : AppCompatActivity() {
    lateinit var RecyclerView: RecyclerView
    lateinit var listsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()

        }
        listsRecyclerView = findViewById<RecyclerView>(R.id.lists_recyclerview)
        listsRecyclerView.layoutManager = LinearLayoutManager(this)
        listsRecyclerView.adapter = ListSelectionRecyclerViewAdapter()


        View.OnClickListener{
            findViewById<View>(R.id.floatingActionButton).setOnClickListener {
               showCreatedListDialog()
            }
        }
    /*  View.OnClickListener {
            findViewById<View>(R.id.floatingActionButton).setOnClickListener {
                showCreatedListDialog()
            }
        }*/
    }
    private fun showCreatedListDialog() {
        // val dialogTitle = Settings.Global.getString(R.string.name_of_list)
        val dialogTitle = getString(R.string.name_of_list)
        // val positiveButtonTitle = Settings.Global.getString(R.string.create_list)
        val positiveButtonTitle = getString(R.string.create_list)
        val builder = AlertDialog.Builder(this)
        val listTitleEditText = EditText(this)
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)
        builder.setPositiveButton(positiveButtonTitle, { dialog, i -> dialog.dismiss() })
        builder.create().show()
    }


}


