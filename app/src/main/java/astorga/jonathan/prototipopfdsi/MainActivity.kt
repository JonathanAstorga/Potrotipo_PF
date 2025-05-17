package astorga.jonathan.prototipopfdsi

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        val btnInicio: Button = findViewById(R.id.btnIniciar)
        val animScale = AnimationUtils.loadAnimation(this, R.anim.anim_press_button)

        val edtCorreo: EditText = findViewById(R.id.edtCorreo)
        val edtContra: EditText = findViewById(R.id.edtPassword)

        btnInicio.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.startAnimation(animScale)
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.clearAnimation()
            }
            false
        }

        btnInicio.setOnClickListener(){
            if (!edtContra.text.isBlank() || !edtCorreo.text.isBlank()) {
                if(edtContra.text.isBlank() && !edtCorreo.text.isBlank() || edtCorreo.text.isBlank() && !edtContra.text.isBlank()){
                    Toast.makeText(this, "Uno de tus campos es invalido", Toast.LENGTH_SHORT).show()
                }
                else{
                    var intent: Intent = Intent(this, PrincipalActivity::class.java)
                    startActivity(intent)
                }
            }
            else{
                Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}