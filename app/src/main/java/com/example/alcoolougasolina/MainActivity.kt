package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var editPrecoAlcool: TextInputEditText
    lateinit var editPrecoGasolina: TextInputEditText
    lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool)
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina)
        textResultado = findViewById(R.id.textResultado)
    }

    fun calcularPreco(view: View) {

        //Recuperadno os valores digitados
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        if (validandoCampos(precoAlcool, precoGasolina) == true) {

            //Convertendo os valores para Double
            var valorAlcool = precoAlcool.toDouble()
            var valorGasolina = precoGasolina.toDouble()

            //Calculo
            if ((valorAlcool / valorGasolina) >= 0.7) {
                textResultado.setText("Resultado: Melhor utilizar gasolina")
            } else textResultado.setText("Resultado: Melhor utilizar alcool")
        }
    }

    fun validandoCampos(precoAlcool: String, precoGasolina: String): Boolean {

        //Validando os campos
        if (precoGasolina == null || precoGasolina.equals("") || precoAlcool.equals("") || precoAlcool == null) {
            Toast.makeText(
                this,
                "Favor validar se os campos foram inseridos corretamente",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }
}