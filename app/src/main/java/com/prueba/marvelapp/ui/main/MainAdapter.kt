package com.prueba.marvelapp.ui.main

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.prueba.marvelapp.R
import com.prueba.marvelapp.models.Character
import com.prueba.marvelapp.ui.character.CharacterActivity
import com.prueba.marvelapp.util.ext.loadImageFromLink
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter()
    : RecyclerView.Adapter<MainAdapter.CharacterViewHolder>(){

    var characters = ArrayList<Character>()

    class CharacterViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list, parent, false)) {

        private var mImage: CircleImageView? = null
        private var mName: TextView? = null

        init {
            mImage = itemView.findViewById(R.id.img_list)
            mName = itemView.findViewById(R.id.name_character)
        }

        fun bind( character: Character) {

            mImage?.loadImageFromLink("${character.thumbnail.path}.${character.thumbnail.extension}")
            mName?.text = character.name


            itemView.setOnClickListener {
                val context = mName?.context
                val intent = Intent(context, CharacterActivity::class.java)
                intent.putExtra("OBJ_CHARACTER", character.id)
                Log.e("MAIN", "OBJ SEND-------${character.id}")
                context?.startActivity(intent)
            }

            itemView.setOnLongClickListener {
                val context = mName?.context
                Toast.makeText(context, "ARRASTRE", Toast.LENGTH_SHORT).show()
                true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = characters.size
}