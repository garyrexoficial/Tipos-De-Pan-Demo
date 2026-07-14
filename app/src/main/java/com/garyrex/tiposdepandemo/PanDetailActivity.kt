package com.garyrex.tiposdepandemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.garyrex.tiposdepandemo.databinding.ActivityPanDetailBinding

class PanDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPanDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPanDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            binding.textViewPanNombre.text = savedInstanceState.getString("PAN_NOMBRE")
            binding.textViewPanDescripcion.text = savedInstanceState.getString("PAN_DESCRIPCION")
            val imagenResId = savedInstanceState.getInt("PAN_IMAGEN", 0)
            if (imagenResId != 0) {
                binding.imageViewPan.setImageResource(imagenResId)
            }
        } else {
            val nombre = intent.getStringExtra("PAN_NOMBRE")
            val descripcion = intent.getStringExtra("PAN_DESCRIPCION")
            val imagenResId = intent.getIntExtra("PAN_IMAGEN", 0)

            binding.textViewPanNombre.text = nombre
            binding.textViewPanDescripcion.text = descripcion
            if (imagenResId != 0) {
                binding.imageViewPan.setImageResource(imagenResId)
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("PAN_NOMBRE", binding.textViewPanNombre.text.toString())
        outState.putString("PAN_DESCRIPCION", binding.textViewPanDescripcion.text.toString())
        outState.putInt("PAN_IMAGEN", intent.getIntExtra("PAN_IMAGEN", 0))
    }

}

