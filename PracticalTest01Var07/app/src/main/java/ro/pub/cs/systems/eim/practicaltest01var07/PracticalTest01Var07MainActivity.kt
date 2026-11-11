package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var07MainActivity : AppCompatActivity() {
    private lateinit var setButton: Button
    private lateinit var randomButton: Button
    private lateinit var topRightText: EditText
    private lateinit var topLeftText: EditText
    private lateinit var bottomLeftText: EditText
    private lateinit var bottomRightText: EditText

    private var sum: Int = 0
    private var prod: Int = 0

    private val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            if (result.data?.getIntExtra("sum", 0) != null)
                sum = result.data?.getIntExtra("sum", 0)!!
            Toast.makeText(this, "Sum " + sum, Toast.LENGTH_SHORT).show()
        } else if (result.resultCode == RESULT_CANCELED) {
            if (result.data?.getIntExtra("prod", 0) != null)
                prod = result.data?.getIntExtra("prod", 0)!!
            Toast.makeText(this, "Prod " + result.data?.getIntExtra("prod", 0), Toast.LENGTH_SHORT).show()
        }
    }


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

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("sum")) {
                sum = savedInstanceState.getInt("sum")
            }
            if (savedInstanceState.containsKey("prod")) {
                prod = savedInstanceState.getInt("prod")
            }
        }
        Toast.makeText(this, "Sum " + sum, Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Prod " + prod, Toast.LENGTH_SHORT).show()
        Log.i("verificare", "Sum " + sum)
        Log.i("verificare", "Prod " + prod)
    }

    fun getObj() {
        setButton = findViewById(R.id.setButton)
        randomButton = findViewById(R.id.randomButton)
        topRightText = findViewById(R.id.topRightText)
        topLeftText = findViewById(R.id.topLeftText)
        bottomLeftText = findViewById(R.id.bottomLeftText)
        bottomRightText = findViewById(R.id.bottomRightText)

        randomButton.setOnClickListener {
            checkField(topRightText)
            checkField(topLeftText)
            checkField(bottomLeftText)
            checkField(bottomRightText)
        }

        setButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java)
            intent.putExtra("topRight", topRightText.text.toString())
            intent.putExtra("topLeft", topLeftText.text.toString())
            intent.putExtra("bottomLeft", bottomLeftText.text.toString())
            intent.putExtra("bottomRight", bottomRightText.text.toString())
            activityResultLauncher.launch(intent)
        }
    }

    fun checkField(textView: TextView) {
        if (textView.text.toString().toDoubleOrNull() == null) {
            var randomVal = (0..100).random()
            textView.text = randomVal.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("sum", sum)
        outState.putInt("prod", prod)
    }
}