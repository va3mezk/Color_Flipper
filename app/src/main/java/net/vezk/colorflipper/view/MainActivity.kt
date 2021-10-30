package net.vezk.colorflipper.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import net.vezk.colorflipper.databinding.ActivityMainBinding
import net.vezk.colorflipper.viewmodel.ViewModelHex

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val hexViewModel: ViewModelHex by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //VIEW
        hexViewModel.hexModel.observe(this, {
            binding.tvHex.text = it.hex
            binding.constraintBackground.setBackgroundColor(Color.rgb(it.red,it.green,it.blue))
        })

        binding.bvRandom.setOnClickListener{hexViewModel.randomHex()}

        //COPIAR A PORTAPAPELES
        binding.tvHex.setOnClickListener{
            val clipboard: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("clipBoard", binding.tvHex.text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "${binding.tvHex.text} copiado al portapapeles", Toast.LENGTH_SHORT).show()
        }
    }
}