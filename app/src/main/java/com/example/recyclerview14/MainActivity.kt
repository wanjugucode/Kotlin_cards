package com.example.recyclerview14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rvPerson:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        peopleInformation()
    }
    fun peopleInformation(){
        var personList= listOf<Person>(
            Person("Anastasia","0710708505","karobianastasia@gmail.com"),
            Person("Ann ","0722527828","karobiaann@gmail.com"),
            Person("Nelson","0706929496","rubuinelson@gmail.com"),
            Person("Faith","0788888888","faithwakuthi@gmail.com"),
            Person("Muli","77220989","muli@gmail.com"),
            Person("Festus","9009889","festus@gmail.com"),
            Person("Samwel","072600000","habi@gmail.com")
        )
        rvPerson=findViewById<RecyclerView>(R.id.rvPerson)
        var personAdapter=PersonRvAdapter(personList)
        rvPerson.layoutManager=LinearLayoutManager(baseContext)
        rvPerson.adapter=personAdapter
    }


}