package com.example.recyclerview14.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recyclerview14.models.Person

@Database (entities = arrayOf(Person::class),version = 1)
abstract class ContactsDatabase:RoomDatabase() {
    abstract fun  getContactDao():ContactDao
    companion object{
        var database: ContactsDatabase?=null

        fun getDatabase(context: Context):ContactsDatabase{
            if (database==null){
                database=
                    Room.databaseBuilder(context,ContactsDatabase::class.java,"ContactsDb")
                    .fallbackToDestructiveMigration()
                        .build()
            }
            return  database as ContactsDatabase
        }

    }
}










//Context -what is happening in your current location
//  abstract- it help achieve abstraction by creating contract for subclass to use parent functionality without implemtation and  prevent overiding
//room =ORM in kotlin
//Companion Object is accessible to all instances== happens/
// global context is accesible in repo , viewmodel and activities-in the entire lifecylce of your application
// as changes db to nullable- type casting
//scheme(migration)
//we use suspend when using the same thread - data cannot be accesed in the main thread instead live data is retured asynchoronous
