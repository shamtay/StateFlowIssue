package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<UserViewModel>()
        for (i in 0..100) {
            list.add(
                UserViewModel("SomeName$i")
            )
        }
        with(binding) {
            lifecycleOwner = this@MainActivity
            recyclerView.adapter = RecyclerAdapter(list, this@MainActivity)
        }
    }
}




