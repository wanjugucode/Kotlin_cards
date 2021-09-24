package com.example.recyclerview14.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.recyclerview14.models.Person
@Dao

interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Person)

    @Query("SELECT * FROM Contacts")
    fun getAllContacts():LiveData<List<Person>>

    @Query("SELECT * FROM Contacts WHERE contactId= :id")
    fun getContactById(id:Int):LiveData<Person>

    @Delete
    fun deleteContact(contact: Person)


}
