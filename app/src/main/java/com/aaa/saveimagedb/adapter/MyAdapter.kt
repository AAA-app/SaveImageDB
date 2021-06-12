package com.aaa.saveimagedb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aaa.saveimagedb.R
import com.aaa.saveimagedb.data.Person
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.raw_card.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var person = emptyList<Person>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.raw_card, parent, false))
    }

    override fun getItemCount(): Int {
        return person.size
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
       holder.itemView.tvName.text = person[position].firstName
        holder.itemView.tvEmail.text = person[position].lastName
        holder.itemView.tvImage.load(person[position].profilePhoto)
    }

    fun setData(person: List<Person>) {
        this.person = person
        notifyDataSetChanged()
    }
}