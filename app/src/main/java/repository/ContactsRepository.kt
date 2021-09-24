package repository

import androidx.lifecycle.LiveData
import com.example.recyclerview14.ContactsApp
import com.example.recyclerview14.database.ContactsDatabase
import com.example.recyclerview14.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    var database= ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveContact(contact: Person){
        withContext(Dispatchers.IO){
            database.getContactaDao().insertContact(contact)
        }
    }
    fun getAllContact():LiveData<List<Person>>{
        return database.getContactaDao().getAllContacts()
    }
    fun fetchContactById(contactId:Int):LiveData<Person>{
        return database.getContactaDao().getContactById(contactId)
    }
    suspend fun deleteContact(contact: Person){

    }


    //singleton pattern
    //gett is not accessed from a courotein
    //long runing opreation
}