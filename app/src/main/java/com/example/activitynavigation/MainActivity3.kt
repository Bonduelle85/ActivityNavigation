package com.example.activitynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitynavigation.databinding.ActivityMain3Binding
import com.example.activitynavigation.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {

    private lateinit var _binding: ActivityMain3Binding
    val binding
        get() = _binding


    val personBob = Person("Bob", "Dylan", 60)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToSecond.setOnClickListener {
            val intent = Intent()
            intent.putExtra(TO_SECOND, "from 3")
            intent.putExtra(MainActivity.PERSON, personBob)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.toFirst.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.PERSON, personBob)
            startActivity(intent)
        }
    }
    companion object{
        const val TO_SECOND = "data"
        const val PERSON = "Person"
    }
}