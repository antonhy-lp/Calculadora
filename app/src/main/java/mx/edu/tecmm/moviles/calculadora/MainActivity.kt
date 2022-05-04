package mx.edu.tecmm.moviles.calculadora

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    lateinit var txtNum0: TextView
    lateinit var txtNum1: TextView
    lateinit var txtNum2: TextView
    lateinit var txtNum3: TextView
    lateinit var txtNum4: TextView
    lateinit var txtNum5: TextView
    lateinit var txtNum6: TextView
    lateinit var txtNum7: TextView
    lateinit var txtNum8: TextView
    lateinit var txtNum9: TextView
    lateinit var txtNumC: TextView
    lateinit var txtNumSuma: TextView
    lateinit var txtNumResta: TextView
    lateinit var txtNumIgual: TextView
    lateinit var textView: TextView
    var num1: Int = 0
    var num2: Int = 0
    var op: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txtNum0 = findViewById(R.id.txtNum0)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        txtNum3 = findViewById(R.id.txtNum3)
        txtNum4 = findViewById(R.id.txtNum4)
        txtNum5 = findViewById(R.id.txtNum5)
        txtNum6 = findViewById(R.id.txtNum6)
        txtNum7 = findViewById(R.id.txtNum7)
        txtNum8 = findViewById(R.id.txtNum8)
        txtNum9 = findViewById(R.id.txtNum9)
        txtNumC = findViewById(R.id.txtNumC)
        txtNumSuma = findViewById(R.id.txtNumSuma)
        txtNumResta = findViewById(R.id.txtNumResta)
        txtNumIgual = findViewById(R.id.txtNumIgual)
        textView = findViewById(R.id.textView)

        txtNumSuma.setOnClickListener { Operacion(Sumar) }
        txtNumResta.setOnClickListener { Operacion(Restar) }

        txtNumC.setOnClickListener {
            num1 = 0
            num2 = 0
            textView.text = ""
            op = Sin_Operacion.toInt()
        }
        txtNumIgual.setOnClickListener {
            var resultado = when (op) {
                Sumar -> num1 + num2
                Restar -> num1 - num2
                else -> 0
            }
            textView.text= resultado.toString()
        }
    }


    fun precionaNumero(V: View) {
        val botonText = V as TextView
        Log.e("Boton", "Se Preciono ${botonText.text}")


        textView.text = "${textView.text}${botonText.text}"
        //textView.text = botonText.toString()
        if (op == Sin_Operacion) {
         num1 = textView.text.toString().toInt()
        }else{
            num2 = textView.text.toString().toInt()        }
    }

    fun Operacion(op: Int){
this.op = op


textView.text = ""
    }
    companion object{
        const val Sumar = 1
        const val Restar =2
        const val Sin_Operacion =0
    }
    }

