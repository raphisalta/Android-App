package net.nonejara.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.nonejara.myapplication.R.id.editText
import net.nonejara.myapplication.R.id.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<View>(R.id.textView) as TextView
        textView.text = "問題：[a,b,c,d,e,f,g,h]"

        val message = findViewById<View>(R.id.message) as TextView
        message.text = ""

        val button: Button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            var index = editText.text.toString()
            var retVal: String
            try{
                retVal = arrayShift().shift(index.toInt())
                message.text = ""
                message.setTextColor(Color.BLACK)
            }catch(e : NumberFormatException){
                message.text = "正の整数を入力してください"
                message.setTextColor(Color.RED)
            }
            Log.d("MainActivity", "index is $index")
        }
    }
}
