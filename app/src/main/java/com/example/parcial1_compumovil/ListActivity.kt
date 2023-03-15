package com.example.parcial1_compumovil

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.parcial1_compumovil.databinding.ActivityListBinding
import kotlin.math.pow

class ListActivity : AppCompatActivity()
{
    private lateinit var bindingList : ActivityListBinding
    private lateinit var listaNumeros: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingList = ActivityListBinding.inflate(layoutInflater)
        setContentView(bindingList.root)

        var numeroRecibido = intent.getIntExtra("numeroIngresado", 0)

        //bindingList.textView.text = numeroRecibido.toString()
        listaNumeros = ArrayList<Int>()

        var numerosRestantes = 0
        var exponente = 3
        var resultado = 0

        while (numerosRestantes != numeroRecibido)
        {
            resultado = numerosRestantes.toDouble().pow(exponente.toDouble()).toInt()
            listaNumeros.add(resultado)

            numerosRestantes += 1
        }

        val adaptadorDeNumeros = ArrayAdapter(this, R.layout.simple_list_item_1, listaNumeros)
        bindingList.listaNumeros.adapter = adaptadorDeNumeros



        bindingList.listaNumeros.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->

                val numeroPresionado = listaNumeros[i]

                val pasarAMostrarNumeroActivity = Intent(this, MostrarNumeroActivity:: class.java)
                pasarAMostrarNumeroActivity.putExtra("numeroPresionado", numeroPresionado)

                startActivity(pasarAMostrarNumeroActivity)
            }
    }
}