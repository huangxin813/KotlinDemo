package com.huangxin.kotlindemo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_city_list.*

class CityListActivity: Activity() {

    private val TAG: String = this.javaClass.simpleName

    private val cities: ArrayList<String> = arrayListOf<String>("Beijing", "Shanghai",
            "Guangzhou", "Shenzhen", "Hangzhou", "Wuhan", "Chengdu", "Suzhou", "Hongkong", "Nanjing")

    private var mAdapter: CityAdapter? = null

    init {
        Log.d(TAG, "=======activity init======");
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_list)
        Log.d(TAG, "=======activity oncreate======");

        mAdapter = CityAdapter(this, cities)
        listview.adapter = mAdapter
        listview.setOnItemClickListener(object: AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                Toast.makeText(this@CityListActivity, cities.get(pos) + " is clicked", Toast.LENGTH_SHORT).show()
            }
        })

    }
}

