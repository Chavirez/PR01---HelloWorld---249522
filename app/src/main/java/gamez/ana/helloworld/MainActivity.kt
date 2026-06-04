package gamez.ana.helloworld

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val title = findViewById<TextView>(R.id.tvTitle)
        val image = findViewById<ImageView>(R.id.imPokemon)
        val name = findViewById<TextView>(R.id.etName)
        val password = findViewById<TextView>(R.id.etPassword)
        val age = findViewById<TextView>(R.id.etEdad)
        val submit = findViewById<TextView>(R.id.btnEnviar)
        val result = findViewById<TextView>(R.id.tvResult)

        submit.setOnClickListener {

            val nameValue = name.text.toString()
            val ageValue = age.text.toString().toInt()

            val resultText = submitInformation(nameValue, ageValue)

            result.text = resultText

            title.text = "Hola $nameValue, esta es mi primera app"

        }

    }

    private fun submitInformation(name: String, age: Int): String {

        val result = "Hola, ${name}! Tienes $age años."

        return result

    }
}