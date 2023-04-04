package com.example.harrypotterfans

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PostAdapter(val postModel:MutableList<PostModel>):RecyclerView.Adapter<PostViewHolder>() {
    var onItemClick: ((PostModel) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(postModel[position])
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(postModel[position])}
    }

    override fun getItemCount(): Int {
        return postModel.size
    }
}

class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    private val imageProfile: ImageView = itemView.findViewById(R.id.profile_pic)
    private val personName: TextView = itemView.findViewById(R.id.personName)
    private val house: TextView = itemView.findViewById(R.id.house)
    private val dateOfBirth: TextView = itemView.findViewById(R.id.dateOfBirth)
    fun bindView(postModel: PostModel){
        val url = postModel.image
        Picasso.get().load(url).into(imageProfile)
        personName.text = postModel.name
        house.text = postModel.house
    dateOfBirth.text = postModel.dateOfBirth
    }

}