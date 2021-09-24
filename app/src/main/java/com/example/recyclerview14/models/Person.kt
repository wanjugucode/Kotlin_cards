package com.example.recyclerview14.models

import android.net.UrlQuerySanitizer
import android.provider.ContactsContract
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Contacts")
data class Person(
    @PrimaryKey(autoGenerate = true)@NonNull var contactId:Int,
     var name:String,
     var phoneNumber:String,
     var emailAddress:String,
     var imageUrl:String
                  )
