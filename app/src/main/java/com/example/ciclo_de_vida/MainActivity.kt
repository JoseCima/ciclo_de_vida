package com.example.ciclo_de_vida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Antes de ejecutarse
    var nombre = "José"
    val NOMBRE = nombre //Clave para identificar la clave que vamos a guardar

    //Se ejecuta en cuanto cargue la app
    override fun onCreate(savedInstanceState: Bundle?) {//El saved permite recuperar los estados de las variables o datos
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.boton)


        //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()


        boton.setOnClickListener {
            //Al girar la pantalla Android detecta que es un cambio de estado. Destruyendo la actividad inicial
            nombre = "Guillermo"
            Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        }
    }

    //Metodo para volver a restaurar el valor  de las variables

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //Obteniendo el valor de mi objeto
        nombre = savedInstanceState?.getString(NOMBRE)!!
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
    }
     //Guardando el estado de nuestras variables
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
         outState?.putString(NOMBRE, nombre)
    }
}