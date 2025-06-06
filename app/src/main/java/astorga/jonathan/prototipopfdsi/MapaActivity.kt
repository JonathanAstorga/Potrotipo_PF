package astorga.jonathan.prototipopfdsi

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mapa)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val animScale = AnimationUtils.loadAnimation(this, R.anim.anim_press_button)

        val btnHome: ImageButton = findViewById(R.id.btnHome)
        val btnMap: ImageButton = findViewById(R.id.btnMap)
        val btnRese: ImageButton = findViewById(R.id.btnRese)
        val btnPerfil: ImageButton = findViewById(R.id.btnPerfil)

        btnHome.setOnClickListener{
            var intent = Intent(this, PrincipalActivity::class.java) as Intent
            startActivity(intent)
        }

        btnMap.setOnClickListener{
            Toast.makeText(this, "Ya estas en esta ventana", Toast.LENGTH_SHORT).show()
        }

        btnRese.setOnClickListener{
            var intent = Intent(this, ResenasActivity::class.java) as Intent
            startActivity(intent)
        }

        btnPerfil.setOnClickListener{
            var intent = Intent(this, AccountActivity::class.java) as Intent
            startActivity(intent)
        }

        btnHome.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.startAnimation(animScale)
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.clearAnimation()
            }
            false
        }

        btnMap.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.startAnimation(animScale)
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.clearAnimation()
            }
            false
        }

        btnRese.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.startAnimation(animScale)
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.clearAnimation()
            }
            false
        }

        btnPerfil.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.startAnimation(animScale)
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.clearAnimation()
            }
            false
        }
    }
}