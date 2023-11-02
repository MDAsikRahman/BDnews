package com.ar.bdnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ar.bdnews.databinding.UserInputItemBinding

class user_adapter (var userList: MutableList<user_input>): RecyclerView.Adapter<UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding= UserInputItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var User= userList[position]
        holder.binding.name.text= User.name
        holder.binding.born.text= User.born
        holder.binding.bio.text=User.bio
        holder.binding.profile1.load(User.imgurl)
    }
}