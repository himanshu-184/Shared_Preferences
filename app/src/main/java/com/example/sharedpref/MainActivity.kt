package com.example.sharedpref

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpref.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var spref = getPreferences(Context.MODE_PRIVATE)
        var color = spref.getInt("COLOR",Color.WHITE)
        binding.llBackground.setBackgroundColor(color)

        fun saveColor(color: Int){
            var editor = spref.edit()
            editor.putInt("COLOR",color)
            editor.apply()
        }


        binding.btnred.setOnClickListener {binding.llBackground.setBackgroundColor(Color.RED)
        saveColor(Color.RED)}
        binding.btnblue.setOnClickListener {binding.llBackground.setBackgroundColor(Color.BLUE)
        saveColor(Color.RED)}
        binding.btngreen.setOnClickListener {binding.llBackground.setBackgroundColor(Color.GREEN)
        saveColor(Color.GREEN)}
    }

}