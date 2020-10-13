package jp.techacademy.chika.kaburagi.aisatsuapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import jp.techacademy.chika.kaburagi.aisatsuapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val time = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                    returnGreetingToTextView(hour,minute)
                    Log.d("UI_PARTS", "$hour:$minute")
                },
                13, 0, true)

        time.show()
    }

    // 時間ごとの挨拶を返す
    private fun returnGreetingToTextView(hour: Int, minute: Int){
        var greeting = when (hour) {
            in 2..9 -> getString(R.string.greeting_1) // おはよう　string.xmlを使ってみる・・
            in 10..17 -> "こんにちは"
            in 18..23,0,1 -> "こんばんは"
            else ->{}
        }
        // **課題とは関係ないですが・・・
        //　選んだ時間が表示されるよう調整
        var m = minute.toString().padStart(2,'0')
        var time = "入力時刻：$hour 時 $m 分 \n"
        textView.text="$time$greeting"

        // 分の判定は必要な場合はif?
        /*
        if (hour in 2..9 && minute in 0..59){
             greeting = "おはよう"
        } else if(hour in 10..17 && minute in 0..59){
            greeting = "こんにちは"
        } else if((hour in 18..23 || hour in 0..1) && minute in 0..59){
            greeting = "こんばんは"
        }

        */
    }
}