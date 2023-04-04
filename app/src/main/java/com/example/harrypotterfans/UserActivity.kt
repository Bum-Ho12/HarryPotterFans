package com.example.harrypotterfans

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.harrypotterfans.databinding.ActivityUserBinding

class UserActivity: AppCompatActivity() {
    private lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val house = intent.getStringExtra("house")
        val alternateName = intent.getStringExtra("alternateName")
        val dateOfBirth = intent.getStringExtra("dateOfBirth")
        val species= intent.getStringExtra("species")
        val gender= intent.getStringExtra("gender")
        val ancestry= intent.getStringExtra("ancestry")
//        val hogwartsStudent= false
        val eyeColor = intent.getStringExtra("eyeColor")
        val hairColor = intent.getStringExtra("hairColor")
        val actor = intent.getStringExtra("actor")
//        val hogwartsStaff= false
//        val alive = true
        val imageId = intent.getIntExtra("imageId",R.drawable.first)

        binding.nameProfile.text = name
        binding.alternateName.text = alternateName
        binding.house.text = house
        binding.dateOfBirth.text = dateOfBirth
        binding.species.text = species
        binding.gender.text = gender
        binding.ancestry.text = ancestry
        binding.eyeColor.text = eyeColor
        binding.hairColor.text = hairColor
        binding.actor.text = actor
        binding.profileImage.setImageResource(imageId)
    }
}