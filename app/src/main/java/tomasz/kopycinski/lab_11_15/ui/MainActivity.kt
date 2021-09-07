package tomasz.kopycinski.lab_11_15.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import tomasz.kopycinski.lab_11_15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setAlert(text: String) {
        binding.alertText.text = text
        binding.alertRoot.visibility = View.VISIBLE
    }
}