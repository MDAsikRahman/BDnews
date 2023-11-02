package com.ar.bdnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ar.bdnews.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class sign_in_activity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        firebaseAuth=FirebaseAuth.getInstance()
        setContentView(binding.root)

        binding.Register.setOnClickListener {
            val intent= Intent(this,sign_up_activity::class.java)
            startActivity(intent)
        }
        binding.login.setOnClickListener {
            val userName=binding.userName.text.toString()
            val email=binding.Email.text.toString()
            val passWord=binding.password.text.toString()

            if (email.isNotEmpty() && passWord.isNotEmpty()){

                firebaseAuth.signInWithEmailAndPassword(email ,passWord).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent= Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "passWord is not matching", Toast.LENGTH_SHORT).show()
            }
        }
    }
}