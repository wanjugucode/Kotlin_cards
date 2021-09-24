package com.example.recyclerview14.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recyclerview14.R

class ContactDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        var contact=intent.getStringExtra("ContactId")
        Toast.makeText(baseContext,contact ,Toast.LENGTH_LONG).show()
    }
}

























//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_contact_details)
//    //casting views
//    tvName=findViewById(R.id.tvName)
//    tvEmail=findViewById(R.id.tvEmail)
//    tvPhoneNumber=findViewById(R.id.tvPhoneNumber)
//    imgContact= findViewById(R.id.imgContact)
//
//
//    val nameIntent=intent.getStringExtra("jina")
//    val phoneNumberIntent=intent.getStringExtra("phoneNumber")
//    val emailIntent=intent.getStringExtra("email")
//    val imageIntent=intent.getStringExtra("imageUrl").toString()
//    Picasso.get()
//        .load(imageIntent)
//        .into(imgContact)
//
//    tvName.text=nameIntent
//    tvEmail.text=emailIntent
//    tvPhoneNumber.text=phoneNumberIntent
//
//}