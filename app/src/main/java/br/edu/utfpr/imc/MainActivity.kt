package br.edu.utfpr.imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.IMC.R
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
            etPeso.error = "Peso deve ser informado."
            return
        } else if (etAltura.text.isEmpty()) {
            etAltura.error = "Altura deve ser informado."
            return
        }
        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        val resultado: Double = if(!Locale.getDefault().language.equals("en")){
            peso / (altura * altura)
        }else{
            703 * (peso / (altura.pow(2)))
        }

        val numberFormat: NumberFormat = NumberFormat.getNumberInstance(Locale.US)

        tvResultado.text = numberFormat.format(resultado)

        // Toast.makeText(this, "Botão calcular pressionado!", Toast.LENGTH_LONG).show()


    }
    fun btLimparOnClick() {
        etPeso.setText("")
        etAltura.setText("")
        tvResultado.text = ("0.0")
        etPeso.requestFocus()
    }
    }