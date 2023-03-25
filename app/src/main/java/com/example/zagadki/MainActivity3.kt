package com.example.zagadki

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.widget.Button


class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        ra1 = findViewById(R.id.radioButton)
        ra2 = findViewById(R.id.radioButton2)
        ra3 = findViewById(R.id.radioButton3)
        ra4 = findViewById(R.id.radioButton4)
        ra5 = findViewById(R.id.radioButton5)
        ra6 = findViewById(R.id.radioButton6)
        ra7 = findViewById(R.id.radioButton7)
        ra8 = findViewById(R.id.radioButton8)
        ra9 = findViewById(R.id.radioButton9)
        ra10= findViewById(R.id.radioButton10)
        ra11= findViewById(R.id.radioButton11)
        ra12= findViewById(R.id.radioButton12)
        ra13= findViewById(R.id.radioButton13)
        ra14= findViewById(R.id.radioButton14)
        ra15= findViewById(R.id.radioButton15)
        Otvet= findViewById(R.id.otvet)
        Rdg = findViewById(R.id.RadGr)

        Name()
    }
    lateinit var ra1: RadioButton
    lateinit var ra2: RadioButton
    lateinit var ra3: RadioButton
    lateinit var ra4: RadioButton
    lateinit var ra5: RadioButton
    lateinit var ra6: RadioButton
    lateinit var ra7: RadioButton
    lateinit var ra8: RadioButton
    lateinit var ra9: RadioButton
    lateinit var ra10: RadioButton
    lateinit var ra11: RadioButton
    lateinit var ra12: RadioButton
    lateinit var ra13: RadioButton
    lateinit var ra14: RadioButton
    lateinit var ra15: RadioButton
    lateinit var Rdg: RadioGroup
    lateinit var Otvet: Button
    var namezag=""
    var RadBtn= listOf("Рубашка","Утюг","Чайник","Год","Луна","Водопровод","Патефон","Иголка с ниткой","Ночь","Дождь","Cолнечный луч","Тень","Ёлка","Замок","Дом")
    var rand=RadBtn.shuffled()
    fun Name(){
        ra1.text=rand[0]
        ra2.text=rand[1]
        ra3.text=rand[2]
        ra4.text=rand[3]
        ra5.text=rand[4]
        ra6.text=rand[5]
        ra7.text=rand[6]
        ra8.text=rand[7]
        ra9.text=rand[8]
        ra10.text=rand[9]
        ra11.text=rand[10]
        ra12.text=rand[11]
        ra13.text=rand[12]
        ra14.text=rand[13]
        ra15.text=rand[14]
    }
    fun Poisk(){
        when(Rdg.checkedRadioButtonId){
           ra1.id-> namezag=ra1.text.toString()
           ra2.id-> namezag=ra2.text.toString()
           ra3.id-> namezag=ra3.text.toString()
           ra4.id-> namezag=ra4.text.toString()
           ra5.id-> namezag=ra5.text.toString()
           ra6.id-> namezag=ra6.text.toString()
           ra7.id-> namezag=ra7.text.toString()
           ra8.id-> namezag=ra8.text.toString()
           ra9.id-> namezag=ra9.text.toString()
           ra10.id-> namezag=ra10.text.toString()
           ra11.id-> namezag=ra11.text.toString()
           ra12.id-> namezag=ra12.text.toString()
           ra13.id-> namezag=ra13.text.toString()
           ra14.id-> namezag=ra14.text.toString()
           ra15.id-> namezag=ra15.text.toString()
        }
        if (namezag!=""){
            var idOtv = RadBtn.indexOf(namezag)
            intent.putExtra("put",idOtv.toString())
            intent.putExtra("Rad",namezag)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
    fun otvet(view: View){
        Poisk()



    }


}