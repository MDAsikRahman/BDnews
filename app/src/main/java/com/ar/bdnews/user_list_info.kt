package com.ar.bdnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ar.bdnews.databinding.ActivityUserListInfoBinding
import com.ar.bdnews.databinding.UserInputItemBinding

class user_list_info : AppCompatActivity() {
    lateinit var binding: ActivityUserListInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserListInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var userAdapter= user_adapter(Data_Source.User_List)
        binding.userRCV.adapter= userAdapter

    }
}