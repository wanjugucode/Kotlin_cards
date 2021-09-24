package com.example.recyclerview14.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.recyclerview14.databinding.ActivityAddContactBinding
import com.example.recyclerview14.databinding.ActivityContactDetailsBinding
import com.example.recyclerview14.models.Person
import view.ContactViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddContactBinding
    val contactViewModel:ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener{
            validateContact()
        }

    }
    fun validateContact() {
        var name = binding.etName.text.toString()
        var phoneNumber = binding.etPhoneNo.text.toString()
        var email = binding.etEmail.text.toString()
        var error = false

        if (name.isEmpty() && name.isBlank()) {
            var error = true
            binding.tilName.error = "Name is required"
        }
        if (phoneNumber.isEmpty() && name.isBlank()) {
            var error = true
            binding.tilPhoneNo.error = "Phone number is required"
        }
        if (email.isEmpty() && name.isBlank()) {
            var error = true
            binding.tilEmail.error = "Email is required"
        }

        if (!error) {
            var contact = Person(0, name, phoneNumber, email, "")
            contactViewModel.saveContact(contact)
            binding.etName.setText("")
            binding.etEmail.setText("")
            binding.etPhoneNo.setText("")


        }
    }
}