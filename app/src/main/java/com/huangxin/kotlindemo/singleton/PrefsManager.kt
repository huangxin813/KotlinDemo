package com.huangxin.kotlindemo.singleton

import android.content.Context
import android.content.SharedPreferences

/**
 * singleton constructor with params
 */
class PrefsManager private constructor(val context: Context){

    private fun getPrefs(): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String) {
        getPrefs().edit().putString(key, value).apply()
    }

    fun getString(key: String, def: String): String {
        return getPrefs().getString(key, def)
    }

    fun remove(key: String) {
        getPrefs().edit().remove(key).apply()
    }


    companion object {
        private var sInstance: PrefsManager? = null

        fun getInstance(context: Context): PrefsManager? {
            if(sInstance == null) {
                sInstance = PrefsManager(context.applicationContext)
            }

            return sInstance
        }
    }
}