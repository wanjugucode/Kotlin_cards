package com.example.recyclerview14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var  tvnamed:TextView
    lateinit var tvEmail:TextView
    lateinit var tvPhoneNumber:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        var name=findViewById<TextView>(R.id.tvName) //finding view
        var email=findViewById<TextView>(R.id.tvEmail)
        var phone=findViewById<TextView>(R.id.tvPhoneNumber)
        val imageV = findViewById<ImageView>(R.id.imgContact)

        var nameIntent=intent.getStringExtra("jina")
        var phoneNumberIntent=intent.getStringExtra("phoneNumber")
        var emailIntent=intent.getStringExtra("email")
        val imageIntent=intent.getStringExtra("imageUrl").toString()
        Picasso.get()
            .load(imageIntent)
            .into(imageV)

        name.text=nameIntent
        email.text=emailIntent
        phone.text=phoneNumberIntent



    }
}