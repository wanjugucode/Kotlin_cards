package com.example.recyclerview14.ui

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import com.example.recyclerview14.R
import com.example.recyclerview14.databinding.ActivityContactDetailsBinding
import com.example.recyclerview14.models.Person
import view.ContactViewModel
import java.io.File

class ContactDetailsActivity : AppCompatActivity() {
    var contactid=0
    val contactViewModel:ContactViewModel by viewModels()
    lateinit var photoFile:File
    lateinit var binding: ActivityContactDetailsBinding
    lateinit var myContact: Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        binding= ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactid=intent.getIntExtra("ContactId",0)
      contactViewModel.getContactById(contactid)

    }

    override fun onResume() {
        super.onResume()
            contactViewModel.contactLiveData.observe(this,{contact->
                binding.tvName.text = contact.name
                binding.tvEmail.text = contact.emailAddress
                binding.tvPhoneNumber.text = contact.phoneNumber
                myContact=contact
                if (contact.imageUrl.isNotEmpty()){
                    binding.ivIcon.setImageBitmap(BitmapFactory.decodeFile(contact.imageUrl))
                }
            })

           binding.ivIcon.setOnClickListener{
          val takePictureIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile= getPhoto("photo${System.currentTimeMillis()}")
        val fileProvider=FileProvider
            .getUriForFile(this,"com.example.recyclerview14.provider",photoFile)
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileProvider)
                cameraLauncher.launch(takePictureIntent)
   }

    }
    fun getPhoto(fileName:String):File{
        var storageDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return  File.createTempFile(fileName,"jpg",storageDir)
    }
    var  cameraLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
if (result.resultCode==Activity.RESULT_OK){
    val  takenPhoto=BitmapFactory.decodeFile(photoFile.absolutePath)
    binding.ivIcon.setImageBitmap(takenPhoto)
    myContact.imageUrl=photoFile.absolutePath
    contactViewModel.saveContact(myContact)


}

    }
}

























//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_contact_details)
//    //casting views
//    tvName=findViewById(R.id.tvName)
//    tvEmail=findViewById(R.id.tvEmail)
//    tvPhoneNumber=findViewById(R.id.tvPhoneNumber)
//    imgContact= findViewById(R.id.imgContact)
//
//
//    val nameIntent=intent.getStringExtra("jina")
//    val phoneNumberIntent=intent.getStringExtra("phoneNumber")
//    val emailIntent=intent.getStringExtra("email")
//    val imageIntent=intent.getStringExtra("imageUrl").toString()
//    Picasso.get()
//        .load(imageIntent)
//        .into(imgContact)
//
//    tvName.text=nameIntent
//    tvEmail.text=emailIntent
//    tvPhoneNumber.text=phoneNumberIntent
//
//}