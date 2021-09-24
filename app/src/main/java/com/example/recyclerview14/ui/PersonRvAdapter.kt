package com.example.recyclerview14

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview14.ui.ContactDetailsActivity
import com.example.recyclerview14.ui.MainActivity.ContactClickLister

import com.example.recyclerview14.models.Person
import com.squareup.picasso.Picasso

class PersonRvAdapter(var personList: List<Person>,var context: Context, var contactClickListener: ContactClickLister):RecyclerView.Adapter<PersonViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.person_list_item,parent,false)
       return PersonViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currentPerson=personList.get(position)
        holder.tvName.text=currentPerson.name
        holder.tvPhoneNumber.text=currentPerson.phoneNumber
        holder.tvEmailAddress.text=currentPerson.emailAddress
        if(currentPerson.imageUrl.isNotEmpty()) {
            Picasso.get()
                .load(currentPerson.imageUrl)
//            .resize(80,80)
//            .centerCrop()
//            .placeholder(R.drawable.placeholder)
                .into(holder.ivContact)
        }
  holder.cvContact.setOnClickListener{
    val intent=Intent(context, ContactDetailsActivity::class.java)
     intent.putExtra("ContactId",currentPerson.contactId)
     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
     context.startActivity(intent)
}
        holder.ivContact.setOnClickListener {
        Toast.makeText(context,"You clicked my face",Toast.LENGTH_LONG)
        }

        holder.ivDeleteContact.setOnClickListener {
            contactClickListener.onClickDeletContact(currentPerson)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}
class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvPhoneNumber=itemView.findViewById<TextView>(R.id.tvPhoneNumber)
    var tvEmailAddress=itemView.findViewById<TextView>(R.id.tvEmailAddress)
    var ivContact=itemView.findViewById<ImageView>(R.id.ivContact)
    var cvContact=itemView.findViewById<CardView>(R.id.cvContact)
    var ivDeleteContact=itemView.findViewById<ImageView>(R.id.ivDeleteContact)

}








































//
//holder.cvContact.setOnClickListener{
//    val intent=Intent(context, ContactDetailsActivity::class.java)
//    intent.putExtra("jina",currentPerson.name)
//    intent.putExtra("phoneNumber",currentPerson.phoneNumber)
//    intent.putExtra("email",currentPerson.emailAddress)
//    intent.putExtra("imageUrl",currentPerson.imageUrl)
//    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//    context.startActivity(intent)
//}