package com.abahstudio.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val LIST_VIEW = "LIST_VIEW"
    val GRID_VIEW = "GRID_VIEW"

    var currentVisibleView : String = LIST_VIEW


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView()

        fab.setOnClickListener { view ->
            if (currentVisibleView == LIST_VIEW){
                fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.ic_list
                    )
                )
                gridView()
            } else {
                fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.ic_grid
                    )
                )
                listView()
            }
        }
    }

    private fun listView() {
        currentVisibleView = LIST_VIEW

        rvItemsList.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ItemAdapter(this, getItemsList())

        rvItemsList.adapter = itemAdapter
    }

    private fun gridView(){
        currentVisibleView = GRID_VIEW

        rvItemsList.layoutManager = GridLayoutManager(this, 2)
        val itemAdapter = ItemAdapter(this, getItemsList())

        rvItemsList.adapter = itemAdapter
    }

    private fun getItemsList(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Item One")
        list.add("Item Two")
        list.add("Item Three")
        list.add("Item Four")
        list.add("Item Five")
        list.add("Item Six")
        list.add("Item Seven")
        list.add("Item Eight")
        list.add("Item Nine")
        list.add("Item Ten")
        list.add("Item Eleven")
        list.add("Item Twelve")
        list.add("Item Thirteen")
        list.add("Item Chocolate")
        list.add("Item Popcorn")

        return list

    }

}
