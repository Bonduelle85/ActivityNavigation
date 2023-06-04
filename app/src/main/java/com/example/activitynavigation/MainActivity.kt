package com.example.activitynavigation

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.activitynavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    val binding
        get() = _binding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exit.setOnClickListener { finish() }

        binding.nextToSecond.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(MainActivity2.FROM_FIRST, "data from Activity1")
            startActivity(intent)
        }
//        val fromThird = intent.getParcelableExtra<Person>(MainActivity3.PERSON) ?: Person()
//        binding.firstActivity.text = "First Activity\nFirst name: ${fromThird?.firstName}" +
//                "\nLast name: ${fromThird?.lastName}" +
//                "\nAge: ${fromThird?.age}"
        val fromThird = intent.getParcelableExtra(MainActivity3.PERSON, Person::class.java) ?: Person()
        binding.firstActivity.text = "First Activity\nFirst name: ${fromThird?.firstName}" +
                "\nLast name: ${fromThird?.lastName}" +
                "\nAge: ${fromThird?.age}"

    }
    companion object{
        const val PERSON = "Person"
    }
}