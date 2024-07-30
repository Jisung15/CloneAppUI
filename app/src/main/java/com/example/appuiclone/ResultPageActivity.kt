package com.example.appuiclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appuiclone.databinding.ActivityResultPageBinding
import com.google.android.material.tabs.TabLayoutMediator

class ResultPageActivity : AppCompatActivity() {

    private val binding by lazy { ActivityResultPageBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tabItems = loadMenuItems()

        // 그리고 그걸 가지고 Tab Layout과 ViewPager를 연결(?)
        with(binding) {
            viewPager.adapter = ViewPagerAdapter(this@ResultPageActivity)
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabItems[position]
            }.attach()
        }
    }

    // Tab Layout의 Tab Text를 Menu 폴더에서 받아오는 부분
    @SuppressLint("RestrictedApi")
    private fun loadMenuItems() : List<String> {
        val menu = MenuBuilder(this)
        menuInflater.inflate(R.menu.menu, menu)

        val items = mutableListOf<String>()

        for (i in 0 until menu.size()) {
            val title = menu.getItem(i).title.toString()
            items.add(title)
        }

        return items
    }
}