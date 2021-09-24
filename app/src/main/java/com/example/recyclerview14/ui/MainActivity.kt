package com.example.recyclerview14.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview14.PersonRvAdapter
import com.example.recyclerview14.databinding.ActivityMainBinding
import com.example.recyclerview14.models.Person
import view.ContactViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val contactsViewModel:ContactViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactsViewModel.getAllContacts()
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.contactsLiveData.observe(this,{contacts->
            peopleInformation (contacts)
        })
        binding.fabAddContact.setOnClickListener{
            startActivity(Intent(this,AddContactActivity::class.java))
        }
    }
    fun peopleInformation(personList:List<Person>) {
        binding.rvPerson.layoutManager = LinearLayoutManager(baseContext)
        val contactAdapter = PersonRvAdapter(personList, baseContext, object :ContactClickLister {

            override fun onClickDeletContact(contact: Person) {
                contactsViewModel.deleteContact(contact)

            }
        })
        binding.rvPerson.adapter=contactAdapter
    }

    interface  ContactClickLister {
      fun  onClickDeletContact(contact: Person){

      }
    }
}