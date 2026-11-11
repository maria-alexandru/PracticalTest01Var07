package ro.pub.cs.systems.eim.practicaltest01var07

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var07MainActivity : AppCompatActivity() {
    private lateinit var setButton: Button
    private lateinit var randomButton: Button
    private lateinit var topRightText: TextView
    private lateinit var topLeftText: TextView
    private lateinit var bottomLeftText: TextView
    private lateinit var bottomRightText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getObj()
    }

    fun getObj() {
        setButton = findViewById(R.id.setButton)
        randomButton = findViewById(R.id.randomButton)
        topRightText = findViewById(R.id.topRightText)
        topLeftText = findViewById(R.id.topLeftText)
        bottomLeftText = findViewById(R.id.bottomLeftText)
        bottomRightText = findViewById(R.id.bottomRightText)
    }
}