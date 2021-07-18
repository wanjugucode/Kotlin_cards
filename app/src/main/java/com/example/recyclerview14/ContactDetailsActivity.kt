package com.example.recyclerview14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var  tvName:TextView
    lateinit var tvEmail:TextView
    lateinit var tvPhoneNumber:TextView
    lateinit var imgContact: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        tvName=findViewById(R.id.tvName) //finding view
        tvEmail=findViewById(R.id.tvEmail)
        tvPhoneNumber=findViewById(R.id.tvPhoneNumber)
        imgContact= findViewById(R.id.imgContact)

        val nameIntent=intent.getStringExtra("jina")
        val phoneNumberIntent=intent.getStringExtra("phoneNumber")
        val emailIntent=intent.getStringExtra("email")
        val imageIntent=intent.getStringExtra("imageUrl").toString()
        Picasso.get()
            .load(imageIntent)
            .into(imgContact)

        tvName.text=nameIntent
        tvEmail.text=emailIntent
        tvPhoneNumber.text=phoneNumberIntent



    }
}