package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.UserItemBinding

class UserViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userViewModel: UserViewModel) {
        binding.viewModel = userViewModel
        binding.executePendingBindings()
    }
}