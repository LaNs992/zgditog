package com.example.zagadki

import android.annotation.SuppressLint
import android.app.UiModeManager.MODE_NIGHT_NO
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Zagadki=findViewById<TextView>(R.id.TextZagadki)
        Zbtn=findViewById(R.id.Zagadka)
        sch=findViewById(R.id.schet)
        Obtn=findViewById(R.id.Otvet)
        itog=findViewById(R.id.Itog)
        txt=findViewById(R.id.textView2)
        Musik=findViewById(R.id.Musik)
        Musik2=findViewById(R.id.musik2)
        Musik3=findViewById(R.id.musik3)
        Musik4=findViewById(R.id.musik4)
        them=findViewById(R.id.them)
        them2=findViewById(R.id.them2)
        Sbtn=findViewById(R.id.Stats)
        Clone.shuffle()

    }
    lateinit var Zagadki:TextView
    lateinit var Mus:MediaPlayer
    lateinit var Mus2:MediaPlayer
    lateinit var txt:TextView
    lateinit var itog:TextView
    lateinit var sch:TextView
    lateinit var Zbtn:Button
    lateinit var Obtn:Button
    lateinit var Sbtn:Button
    lateinit var Musik:Button
    lateinit var Musik2:Button
    lateinit var Musik3:Button
    lateinit var Musik4:Button
    lateinit var them:Button
    lateinit var them2:Button
    var i=0
    var Schetchik=0
    var tr=0
    var fl=0

    fun Musik(view: View){
        Mus=MediaPlayer.create(this,R.raw.m)
        Mus.start()
        Musik.isVisible=false
        Musik2.isVisible=true
    }
    fun Musik2(view: View){
        Mus.stop()
        Musik2.isVisible=false
        Musik.isVisible=true
    }
    fun Musik4(view: View){
        Musik4.isVisible=false
        Mus2=MediaPlayer.create(this,R.raw.f)
        Mus2.start()
        Musik3.isVisible=true
    }
    fun Musik3(view: View){
        Mus2.stop()
        Musik3.isVisible=false
        Musik4.isVisible=true
    }
    fun them(view: View){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        them.isVisible=false
        them2.isVisible=true

    }
    fun them2(view: View){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        them2.isVisible=false
        them.isVisible=true
    }


    fun Otvet(view: View){
        val intentNum=Intent(this,MainActivity3::class.java)
        startActivityForResult(intentNum,100)
        Zbtn.isEnabled=true
        Obtn.isEnabled=false
        prov()
    }
    val ZagadArr= arrayOf("Я с шеей, но без головы, с двумя руками и без рук.",
    "В Полотняной стране\n" +
            "По реке Простыне\n" +
            "Плывет пароход\n" +
            "То назад, то вперед,\n" +
            "А за ним такая гладь —\n" +
            "Ни морщинки не видать.",
                "В брюшке — баня,\n" +
                "В носу — решето,\n" +
                "Нос — хоботок,\n" +
                "На голове — пупок,\n" +
                "Всего одна рука\n" +
                "Без пальчиков,\n" +
                "И та — на спине\n" +
                "Калачиком.",
                "Стоит дуб,\n" +
                "В нем двенадцать гнезд,\n" +
                "В каждом гнезде\n" +
                "По четыре яйца,\n" +
                "В каждом яйце\n" +
                "По семи цыпленков.",
                "В синем небе светляки —\n" +
                "Не дотянешь к ним руки.\n" +
                "А один большой светляк\n" +
                "Изогнулся, как червяк.",
                "Речка спятила с ума —\n" +
                 "По домам пошла сама.",
                "Музыкант, певец, рассказчик —\n" +
                "А всего труба да ящик.","Конь стальной, хвост льняной","Чёрная корова весь мир поборола","Шёл долговяз, во сыру землю увяз","Из окна в окно золотое веретено",
        "Мету, мету — не вымету; несу, несу — не вынесу; пора придёт, сама уйдет","Зимой и летом одним цветом","Не лает, не кусает, а в дом не пускает","Стоит бычище поклёваны бочища")
    val Clone= copyArray(ZagadArr)
    fun Zagadka(view: View) {
        Schetchik++
        sch.text="${Schetchik}/15"
        Zagadki.text="${Clone[i]}"
        i++
        Zbtn.isEnabled=false
        Obtn.isEnabled=true
        itog.text=""
        itog.setBackgroundColor(Color.WHITE)
    }
    fun copyArray(source: Array<String>): Array<String?> {
        return source.copyOf(source.size)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100&&resultCode== RESULT_OK&&data!=null){
           val indexMas= ZagadArr.indexOf(Clone[i-1])
           if(indexMas.toString()==data.getStringExtra("put")){
               tr++
                    itog.text=data.getStringExtra("Rad")
                    itog.setBackgroundColor(Color.GREEN)
            }
            if(indexMas.toString()!=data.getStringExtra("put")){
                fl++
                itog.text=data.getStringExtra("Rad")
                itog.setBackgroundColor(Color.RED)
            }
        }
    }
    fun prov(){
   if(i==15){
    Sbtn.isEnabled=true
    Zbtn.isEnabled=false }
    }
    fun Stats(view: View){
        intent=Intent(this,MainActivity2::class.java)
        intent.putExtra("fl",fl.toString())
        intent.putExtra("tr",tr.toString())
        startActivityForResult(intent,100)
    }


}


