package com.example.login

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val imagelist = listOf<com.example.login.Image>(
            Image(R.drawable.detail,"Kimetsu No Yaiba","Kisah serial Demon Slayer: Kimetsu no Yaiba bermula saat umat manusia hidup di bawah teror iblis yang bersembunyi dalam kegelapan untuk melahap jiwa-jiwa yang malang. Iblis tersebut adalah manusia yang menjual jiwa mereka dengan imbalan kekuatan. Mereka memiliki kekuatan sihir serta regenerasi dan hidup dengan cara memakan manusia. Karena itu, manusia mulai membentuk kelompok rahasia bernama Demon Slayer Corps yang bertugas memburu dan membunuh iblis.)."),
            Image(R.drawable.img1,"Attack On Titan","Anime Attack on Titan bercerita tentang umat manusia yang dibantai sejak berabad-abad yang lalu hingga hampir punah oleh makhluk mengerikan menyerupai manusia yang disebut Titan. Hal ini memaksa manusia untuk bersembunyi dan diam dalam ketakutan di balik tembok konsentris yang sangat tinggi dan besar."),
            Image(R.drawable.img2,"Nanatsu No Taiza","Dunia yang mirip dengan Abad Pertengahan Eropa, ada sebuah wilayah bernama Britania. Disana terdapat para ksatria suci dari Britania yang hormati karena mempunyai kekuatan sihir yang sangat kuat untuk melindungi wilayah Britania dan kerajaannya."),
            Image(R.drawable.img3,"Boruto","mengisahkan setelah berakhirnya Perang Dunia Shinobi Keempat dengan sukses, Desa Konoha telah menikmati masa damai, kemakmuran, dan kemajuan teknologi yang luar biasa. Ini semua karena upaya Pasukan Sekutu Shinobi dan Hokage Ketujuh desa, Naruto Uzumaki (diisi suara oleh "))
        val recyclerView = findViewById<RecyclerView>(R.id._imageRecycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this , imagelist){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }
    }
}