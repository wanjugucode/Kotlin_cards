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
            Person("Ann ","0722527828","karobiaann@gmail.com","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3zS-YZPS5QakyUi9E2VdYROsWJSWJPZ3mRQ&usqp=CAU"),
            Person("Nelson","0706929496","rubuinelson@gmail.com","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEtXrSVUyZpF4UqNLCukSGpmHcj8cc_i3qng&usqp=CAU"),
            Person("Faith","0788888888","faithwakuthi@gmail.com","https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.pinimg.com%2Foriginals%2Ff9%2F91%2F3d%2Ff9913d19f5be82d48df0ce6bc2abb5a4.png&imgrefurl=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F365143482286716622%2F&tbnid=wnDuYa-jyetLWM&vet=12ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygAegUIARDAAQ..i&docid=vqVsPHCEnm89cM&w=1172&h=725&q=clipart%20flower&hl=en-GB&ved=2ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygAegUIARDAAQ"),
            Person("Muli","77220989","muli@gmail.com","https://www.google.com/imgres?imgurl=https%3A%2F%2Fc8.alamy.com%2Fcomp%2F2ANNJG7%2Fvector-bright-blue-rose-flower-rose-clipart-with-petals-and-leaf-transparent-background-close-up-2ANNJG7.jpg&imgrefurl=https%3A%2F%2Fwww.alamy.com%2Fvector-bright-blue-rose-flower-rose-clipart-with-petals-and-leaf-transparent-background-close-up-image340380327.html&tbnid=41ZibGyzP6rTIM&vet=12ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygEegUIARDIAQ..i&docid=KNvGMKJ2DxNCjM&w=1300&h=1297&q=clipart%20flower&hl=en-GB&ved=2ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygEegUIARDIAQ"),
            Person("Festus","9009889","festus@gmail.com","https://www.google.com/imgres?imgurl=https%3A%2F%2Fbanner.uclipart.com%2F20200112%2Fifr%2Frose-garden-flower-rose-family.png&imgrefurl=https%3A%2F%2Fwww.uclipart.com%2Frose-flower-rose-family-plant-clipart-914hhu%2F&tbnid=MTcyQ3JcwVSxfM&vet=12ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygIegUIARDRAQ..i&docid=QckMmO9XUkbxQM&w=600&h=903&q=clipart%20flower&hl=en-GB&ved=2ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygIegUIARDRAQ"),
            Person("Samwel","072600000","habi@gmail.com","https://www.google.com/imgres?imgurl=https%3A%2F%2Fbanner.uclipart.com%2F20200505%2Flul%2Fplant-flower-rose-family.png&imgrefurl=https%3A%2F%2Fwww.uclipart.com%2Fplant-flower-rose-family-garden-roses-clipart-k87oi4%2F&tbnid=n1GbHwSYZG5luM&vet=12ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygdegUIARCHAg..i&docid=9mhM09VZfcQTJM&w=600&h=671&q=clipart%20flower&hl=en-GB&ved=2ahUKEwjuiu-4sODxAhXV44UKHWtNDkYQMygdegUIARCHAg")
        )
        rvPerson=findViewById<RecyclerView>(R.id.rvPerson)
        var contactAdapter=PersonRvAdapter(personList,baseContext)
        rvPerson.layoutManager=LinearLayoutManager(baseContext)
        rvPerson.adapter=contactAdapter
    }


}