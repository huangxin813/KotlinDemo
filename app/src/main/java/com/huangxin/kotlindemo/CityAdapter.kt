package com.huangxin.kotlindemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import kotlinx.android.synthetic.main.city_item.view.*


class CityAdapter(private val context: Context, private var cities: List<String>): BaseAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder?
        var view: View?

        if (convertView == null || convertView.tag !is ViewHolder) {
            holder = ViewHolder()
            view = mInflater.inflate(R.layout.city_item, null);
            holder.city = view.city_name
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        holder.city?.text = cities.get(position)

        return view as View
    }

    override fun getItem(position: Int): Any {
        return cities.get(position)
    }

    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    override fun getCount(): Int {
        return cities.count()
    }


    private class ViewHolder {
        var city: TextView? = null
    }


}