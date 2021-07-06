package com.example.recyclerview14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonRvAdapter(var personList: List<com.example.recyclerview14.Person>):RecyclerView.Adapter<PersonViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.person_list_item,parent,false)
        return PersonViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
       var currentPerson=personList.get(position)
        holder.tvName.text=currentPerson.name
        holder.tvPhoneNumber.text=currentPerson.phoneNumber
        holder.tvEmailAddress.text=currentPerson.emailAddress

    }

    override fun getItemCount(): Int {
        return personList.size
    }
}
class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvPhoneNumber=itemView.findViewById<TextView>(R.id.tvPhoneNumber)
    var tvEmailAddress=itemView.findViewById<TextView>(R.id.tvEmailAddress)
}