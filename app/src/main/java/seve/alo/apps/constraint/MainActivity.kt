package seve.alo.apps.constraint


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Declaramos una variable para cada uno de los botones
    val editTextNumeros = findViewById<EditText>(R.id.editTextNumeros)
    val btnCero = findViewById<Button>(R.id.btnCero)
    val btnUno = findViewById<Button>(R.id.btnUno)
    val btnDos = findViewById<Button>(R.id.btnDos)
    val btnTres = findViewById<Button>(R.id.btnTres)
    val btnCuatro = findViewById<Button>(R.id.btnCuatro)
    val btnCinco = findViewById<Button>(R.id.btnCinco)
    val btnSeis = findViewById<Button>(R.id.btnSeis)
    val btnSiete = findViewById<Button>(R.id.btnSiete)
    val btnOcho = findViewById<Button>(R.id.btnOcho)
    val btnNueve = findViewById<Button>(R.id.btnNueve)
    val btnPunto = findViewById<Button>(R.id.btnPunto)
    val btnMasMenos = findViewById<Button>(R.id.btnMasMenos)
    val btnDividir = findViewById<Button>(R.id.btnDivision)
    val btnMultiplicacion = findViewById<Button>(R.id.btnMultiplicacion)
    val btnSuma = findViewById<Button>(R.id.btnSuma)
    val btnResta = findViewById<Button>(R.id.btnResta)

    // Declaramos tres variables que nos ayudaran a poder hacer las operaciones
    var operacion = "*"
    var numeroPrevio = ""
    var nuevaOperacion = true

    fun eventosBtn(view: View) {
        if (nuevaOperacion) {
            editTextNumeros.setText("")
        }

        nuevaOperacion = false
        val btnCliqueado = view as Button
        var valorDelBoton: String = editTextNumeros.text.toString()

        when (btnCliqueado.id) {
            btnCero.id -> valorDelBoton += "0"
            btnUno.id -> valorDelBoton += "1"
            btnDos.id -> valorDelBoton += "2"
            btnTres.id -> valorDelBoton += "3"
            btnCuatro.id -> valorDelBoton += "4"
            btnCinco.id -> valorDelBoton += "5"
            btnSeis.id -> valorDelBoton += "6"
            btnSiete.id -> valorDelBoton += "7"
            btnOcho.id -> valorDelBoton += "8"
            btnNueve.id -> valorDelBoton += "9"
            btnPunto.id -> valorDelBoton += "."
            btnMasMenos.id -> valorDelBoton = "-" + valorDelBoton
        }
        editTextNumeros.setText(valorDelBoton)
    }

    fun operaciones(view: View) {

        val btnCliqueado = view as Button

        when (btnCliqueado.id) {
            btnDividir.id ->  operacion = "/"
            btnMultiplicacion.id -> operacion = "*"
            btnSuma.id -> operacion = "+"
            btnResta.id -> operacion = "-"
        }

        numeroPrevio = editTextNumeros.text.toString()
        nuevaOperacion = true
    }

    fun porcentaje(view: View) {
        val numero:Double = editTextNumeros.text.toString().toDouble() / 100
        editTextNumeros.setText(numero.toString())
        nuevaOperacion = true
    }

    fun limpiar(view: View) {
        editTextNumeros.setText("0")
        nuevaOperacion = true
    }

    fun resultado(view: View) {
        val nuevoNumero = editTextNumeros.text.toString()
        var numeroFinal:Double? = null

        when (operacion) {
            "*" -> numeroFinal = numeroPrevio.toDouble() * nuevoNumero.toDouble()
            "/" -> numeroFinal = numeroPrevio.toDouble() / nuevoNumero.toDouble()
            "+" -> numeroFinal = numeroPrevio.toDouble() + nuevoNumero.toDouble()
            "-" -> numeroFinal = numeroPrevio.toDouble() - nuevoNumero.toDouble()
        }

        editTextNumeros.setText(numeroFinal.toString())
        nuevaOperacion = true
    }
}