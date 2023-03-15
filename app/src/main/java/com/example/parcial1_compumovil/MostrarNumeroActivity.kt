package com.example.parcial1_compumovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcial1_compumovil.databinding.ActivityMostrarNumeroBinding

class MostrarNumeroActivity : AppCompatActivity()
{
    private lateinit var bindingMostrarNumero : ActivityMostrarNumeroBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMostrarNumero = ActivityMostrarNumeroBinding.inflate(layoutInflater)
        setContentView(bindingMostrarNumero.root)

        var numeroDeLaLista = intent.getIntExtra("numeroPresionado", 0)

        bindingMostrarNumero.numero.text = numeroDeLaLista.toString()
    }
}