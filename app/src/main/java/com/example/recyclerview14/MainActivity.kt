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
            Person("Anastasia","0710708505","karobianastasia@gmail.com","https://images.unsplash.com/photo-1530785602389-07594beb8b73?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
            Person("Ann ","0722527828","karobiaann@gmail.com","https://images.unsplash.com/photo-1511185307590-3c29c11275ca?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fGFmcmljYXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
            Person("Nelson","0706929496","rubuinelson@gmail.com","https://images.unsplash.com/photo-1611693196679-c1f358840cc6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGFmcmljYXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
            Person("Faith","0788888888","faithwakuthi@gmail.com","https://images.unsplash.com/photo-1519635451045-a41d4361d495?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGFmcmljYXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
            Person("Muli","77220989","muli@gmail.com","https://images.unsplash.com/photo-1473649085228-583485e6e4d7?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fGFmcmljYXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
            Person("Festus","9009889","festus@gmail.com","https://images.unsplash.com/photo-1534759846116-5799c33ce22a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjR8fGFmcmljYXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
            Person("Samwel","072600000","habi@gmail.com","https://images.unsplash.com/photo-1534759846116-5799c33ce22a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjR8fGFmcmljYXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60")
        )
        rvPerson=findViewById<RecyclerView>(R.id.rvPerson)
        var contactAdapter=PersonRvAdapter(personList,baseContext)
        rvPerson.layoutManager=LinearLayoutManager(baseContext)
        rvPerson.adapter=contactAdapter
    }
}