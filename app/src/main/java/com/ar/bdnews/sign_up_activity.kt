package com.ar.bdnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ar.bdnews.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class sign_up_activity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth= FirebaseAuth.getInstance()

        binding.loginHere.setOnClickListener {

            val intent= Intent(this, sign_in_activity::class.java)
            startActivity(intent)
        }
        binding.register.setOnClickListener{
            val firstName=binding.firstName.text.toString()
            val confirmPassword=binding.confirmPassword.text.toString()
            val email=binding.Email.text.toString()
            val passWord=binding.password.text.toString()

            if (email.isNotEmpty() && passWord.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (passWord == confirmPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email ,passWord).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent= Intent(this, sign_in_activity::class.java)
                            startActivity(intent)

                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "passWord is not matching", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(this, "Empty fields are not allowed !!" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}