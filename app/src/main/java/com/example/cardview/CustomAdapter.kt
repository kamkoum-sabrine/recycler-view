package com.example.cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(private var data: ArrayList<Pair<String,Int>>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }


    internal  inner class MyViewHolder (view : View, listener: onItemClickListener) : RecyclerView.ViewHolder(view){
        var name : TextView = view.findViewById(R.id.governorat)
        var imageSrc : ImageView = view.findViewById(R.id.imageView)
        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ligne,parent,false)
        return MyViewHolder(itemView, mListener)

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val item = data.get(position)
        holder.name.text = item.first
        holder.imageSrc.setImageResource(item.second)
       /* holder.itemView.setOnClickListener { view ->
            var id = this.getItemId(position)
            println(position)
            data.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, data.size)
            notifyDataSetChanged()
           // data.removeAt(id.toInt())
        }*/
       /* holder.itemView.setOnClickListener{
            data.remove(data.get(position))
        }*/
        /*holder.itemView.setOnClickListener{

            holder.name.text = ""
            holder.imageSrc.setImageResource(0)

            data
        }*/

       /* holder.float_button.setOnClickListener{
            this.getItemId(position)

        }*/

    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


}