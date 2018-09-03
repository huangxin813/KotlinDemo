package com.huangxin.kotlindemo.singleton

import com.huangxin.kotlindemo.model.User

/**
 * singleton constructor with no param
 */
class UserManager private constructor(){

    private val mUsers: ArrayList<User> = ArrayList()

    fun addUser(user: User) {
        if (!mUsers.contains(user)) {
            mUsers.add(user)
        }
    }

    fun removeUser(user: User) {
        mUsers.remove(user)
    }

    fun removeUser(id: String): User? {
        if (id == null) return null

        mUsers.forEach {
            if (it != null) {
                if (id.equals(it.id)) {
                    return it
                }
            }
        }

        return null
    }

    fun clearAll() {
        mUsers.clear()
    }

    companion object {
        private var sInstance: UserManager? = null

        val instance: UserManager?
        get() {
            if (sInstance == null) {
                synchronized(UserManager::class.java) {
                    if (sInstance == null) {
                        sInstance = UserManager()
                    }
                }
            }
            return sInstance
        }
    }
}