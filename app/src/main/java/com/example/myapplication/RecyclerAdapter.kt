package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.UserItemBinding

class RecyclerAdapter(private val viewModels: List<UserViewModel>, private val lifecycleOwner: LifecycleOwner): RecyclerView.Adapter<UserViewHolder>() {

    private var allAmount = 0L
    private var count = 0
    private var maxTime = 0L

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            logTime("onCreateViewHolder::") {
                val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false )
                binding.lifecycleOwner = lifecycleOwner
                binding
            }
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        logTime("onBindViewHolder::") {
            holder.bind(viewModels[position])
        }
    }

    override fun getItemCount(): Int {
        return viewModels.size
    }

    private fun <T> logTime(tag: String, block: () -> T): T {
        val time = System.currentTimeMillis()
        val result = block()
        val timeSpent = System.currentTimeMillis() - time
        allAmount += timeSpent
        count++
        maxTime = if (maxTime < timeSpent) {
            timeSpent
        } else {
            maxTime
        }
        if (timeSpent > 4) {
            Log.d(
                tag,
                "$ time spent to bind = $timeSpent mls avg = ${allAmount / count} max = $maxTime "
            )
        }
        return result
    }
}



