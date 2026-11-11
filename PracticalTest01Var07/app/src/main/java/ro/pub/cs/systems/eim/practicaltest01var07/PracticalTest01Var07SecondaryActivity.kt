package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {
    private lateinit var sumButton: Button
    private lateinit var productButton: Button
    private lateinit var topRightTextView: TextView
    private lateinit var topLeftTextView: TextView
    private lateinit var bottomLeftTextView: TextView
    private lateinit var bottomRightTextView: TextView

    private var prod: Int = 0
    private var sum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getObj()
    }

    fun getObj() {
        sumButton = findViewById(R.id.sumButton)
        productButton = findViewById(R.id.productButton)
        topRightTextView = findViewById(R.id.topRightTextView)
        topLeftTextView = findViewById(R.id.topLeftTextView)
        bottomLeftTextView = findViewById(R.id.bottomLeftTextView)
        bottomRightTextView = findViewById(R.id.bottomRightTextView)

        if (intent != null) {
            val topRight = intent.getStringExtra("topRight")
            val topLeft = intent.getStringExtra("topLeft")
            val bottomRight = intent.getStringExtra("bottomRight")
            val bottomLeft = intent.getStringExtra("bottomLeft")

            topRightTextView.text = topRight.toString()
            topLeftTextView.text = topLeft.toString()
            bottomLeftTextView.text = bottomRight.toString()
            bottomRightTextView.text = bottomLeft.toString()

            var r1 = topRight.toString().toIntOrNull()
            var r2 = topLeft.toString().toIntOrNull()
            var l1 = bottomRight.toString().toIntOrNull()
            var l2 = bottomLeft.toString().toIntOrNull()
            if (r1 != null && r2 != null && l1 != null && l2 != null) {
                prod = r1 * r2 * l1 * l2
                sum = r1 + r2 + l1 + l2
            }
        }

        sumButton.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra("sum", sum))
            finish()
        }
        productButton.setOnClickListener {
            setResult(RESULT_CANCELED, Intent().putExtra("prod", prod))
            finish()
        }

    }
}