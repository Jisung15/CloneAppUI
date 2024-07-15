package com.example.appuiclone

object TransportList {
    val list = mutableListOf<Item>()

    fun addItem (item: Item) {
        list.add(0, item)
    }
}