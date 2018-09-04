package com.huangxin.kotlindemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?) {
                val intent: Intent = Intent(this@MainActivity, CityListActivity::class.java)
                startActivity(intent)
            }
        })
    }

}
