package com.example.ceriakids.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ceriakids.R
import com.example.ceriakids.ui.detail.Food


class FoodAdapter(private  val foodlist: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {


    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView= itemView.findViewById(R.id.Ivgizi)
        val tvName: TextView = itemView.findViewById(R.id.name_food)
        val tvDescription: TextView = itemView.findViewById(R.id.desc_gizi)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val(name,description,photo) = foodlist [position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(foodlist[holder.adapterPosition])
            Toast.makeText(holder.itemView.context,"kamu memilih " + foodlist[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return foodlist.size
    }
    interface OnItemClickCallback{
        fun onItemClicked(data: Food)
    }

}