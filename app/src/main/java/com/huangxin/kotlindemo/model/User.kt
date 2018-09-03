package com.huangxin.kotlindemo.model

data class User private constructor(val id: String, val name: String) {

    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        if (other is User) {
            return other.id.equals(this.id)
        }
        return false
    }

}