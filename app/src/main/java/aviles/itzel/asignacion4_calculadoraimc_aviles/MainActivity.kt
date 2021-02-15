package aviles.itzel.asignacion4_calculadoraimc_aviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        var campo_estatura: TextView = findViewById(R.id.editTxtEstatura)
        var campo_peso: TextView = findViewById(R.id.editTxtPeso)
        var campo_imc: TextView = findViewById(R.id.txtIMC)
        var campo_rango: TextView = findViewById(R.id.txtRango)

        btnCalcular.setOnClickListener{
            var estatura: Double = campo_estatura.text.toString().toDouble()
            var peso: Double = campo_peso.text.toString().toDouble()
            var imc: Double = peso / Math.pow(2.0, estatura)

            campo_imc.setText("$imc")

            when(imc){
                in 0.0..18.5 ->{
                    campo_rango.setText("Bajo peso")
                    campo_rango.setBackgroundResource(R.color.colorGreenish)
                }
                in 18.5..24.9 -> {
                    campo_rango.setText("Normal")
                    campo_rango.setBackgroundResource(R.color.colorGreen)
                }
                in 25.0..29.9 -> {
                    campo_rango.setText("Sobrepeso")
                    campo_rango.setBackgroundResource(R.color.colorYellow)
                }
                in 30.0..34.9 -> {
                    campo_rango.setText("Obesidad grado 1")
                    campo_rango.setBackgroundResource(R.color.colorOrange)
                }
                in 35.0..39.9 -> {
                    campo_rango.setText("Obesidad grado 2")
                    campo_rango.setBackgroundResource(R.color.colorRed)
                }
                else -> {
                    campo_rango.setText("Obesidad grado 3")
                    campo_rango.setBackgroundResource(R.color.colorBrown)
                }

            }
        }
    }

}