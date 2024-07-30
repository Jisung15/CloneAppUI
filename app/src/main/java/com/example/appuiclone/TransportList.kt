package com.example.appuiclone

// 싱글톤(?) 데이터를 리스트에 add해주는 역할
object TransportList {
    val list = mutableListOf<Item>()

    fun addItem(item: Item) {
        list.add(0, item)
    }
}