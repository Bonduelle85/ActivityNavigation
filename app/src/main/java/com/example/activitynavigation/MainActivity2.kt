package com.example.activitynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitynavigation.databinding.ActivityMain2Binding
import com.example.activitynavigation.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var _binding: ActivityMain2Binding
    val binding
        get() = _binding

    // using registerForActivityResult API
    val startActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {result ->
        val fromIntent = result.data?.getStringExtra(FROM_FIRST)
        binding.secondActivity.text = "Second Activity\n${fromIntent}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToFirst.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.nextToThird.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivityForResult.launch(intent)
        }

        val fromIntent = intent.getStringExtra(FROM_FIRST)
        binding.secondActivity.text = "Second Activity\n${fromIntent}"

    }
    companion object{
        const val FROM_FIRST = "data"
    }
}