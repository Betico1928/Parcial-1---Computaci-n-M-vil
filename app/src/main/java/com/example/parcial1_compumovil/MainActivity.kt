package com.example.parcial1_compumovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.parcial1_compumovil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        tomarNumero()
    }

    private fun tomarNumero()
    {
        bindingMain.ListaButton.setOnClickListener {

            val numeroIngresado = bindingMain.numeroIngresado.text.toString().toInt()

            if (numeroIngresado in 0..20)
            {
                Toast.makeText(baseContext, "El numero ingresado es correcto", Toast.LENGTH_SHORT).show()

                val pasarAListActivity = Intent(this, ListActivity:: class.java)
                pasarAListActivity.putExtra("numeroIngresado", numeroIngresado)

                startActivity(pasarAListActivity)
            }
            else
            {
                Log.i("MainActivity", "El numero ingresado es incorrecto")
                Toast.makeText(baseContext, "El numero ingresado es incorrecto", Toast.LENGTH_LONG).show()
            }
        }
    }
}