package br.edu.utfpr.IMC

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btCalcular: Button
    private lateinit var btLimpar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResultado = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)



        btCalcular.setOnClickListener {
            btCalcularOnClick()
        }
    }

    private fun btCalcularOnClick() {

        if (etPeso.text.isEmpty()) {
            etPeso.setError("Peso deve ser informado.")
            return
        } else if (etAltura.text.isEmpty()) {
            etAltura.setError("Altura deve ser informado.")
            return
        }
        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()
        var  resultado = 0.0

        if(!Locale.getDefault().getLanguage().equals("en")){
             resultado = peso / (altura * altura)
        }else{
             resultado = 703 * (peso / (altura.pow(2)))
        }

        val numberFormat: NumberFormat = NumberFormat.getNumberInstance(Locale.US)

        tvResultado.setText(numberFormat.format(resultado))

        // Toast.makeText(this, "Botão calcular pressionado!", Toast.LENGTH_LONG).show()


    }
    fun btLimparOnClick(view: View) {
        etPeso.setText("")
        etAltura.setText("")
        tvResultado.setText("0.0")
        etPeso.requestFocus()
    }
    }