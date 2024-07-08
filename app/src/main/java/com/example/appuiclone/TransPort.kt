package com.example.appuiclone

object TransPort {
    val list = mutableListOf<String>()
    fun add (s: String) {
        list.add(s)
    }
    fun remove (s:String) {
        list.remove(s)
    }
}