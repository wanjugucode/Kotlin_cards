package view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerview14.models.Person
import kotlinx.coroutines.launch
import repository.ContactsRepository

class ContactViewModel:ViewModel() {

    var contactsRepository=ContactsRepository()
    lateinit var contactsLiveData:LiveData<List<Person>>
    lateinit var contactLiveData: LiveData<Person>
    fun saveContact(contact: Person){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
    fun getAllContacts (){
        contactsLiveData=contactsRepository.getAllContact()
    }
    fun  getContactById(contactId:Int){
        contactLiveData=contactsRepository.fetchContactById(contactId)
    }
    fun deleteContact(contact: Person){
        viewModelScope.launch {
        contactsRepository.deleteContact(contact)
    }
    }
}