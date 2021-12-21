package com.example.hometask_44

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Locale
import java.util.Locale.UNICODE_LOCALE_EXTENSION

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        savedInstanceState?.getString(svGraphics.isChecked.toString())
        savedInstanceState?.getString(edNickName.toString())


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // add into build.gradle code  debug { pseudoLocalesEnabled true }

        val toastoff = Toast.makeText(applicationContext, "AutoSave is OFF", Toast.LENGTH_SHORT) as Toast
        val toaston = Toast.makeText(applicationContext, "AutoSave is ON", Toast.LENGTH_SHORT) as Toast

        val prefs = getSharedPreferences("app_settings", Context.MODE_PRIVATE)


        //val prefs = SharedPrefs(this)
        //Log.d("MyLog44", prefs.setColor("").toString())
        //Log.d("MyLog44", prefs.getColor())
        //Log.d("MyLog44", prefs.setUser("").toString())
        //Log.d("MyLog44", prefs.getUser())
        //Log.d("MyLog44", prefs.setNickName("").toString())
        //Log.d("MyLog44", prefs.getNickName().toString())

                /*Log.d("Mylog44",Locale.getDefault().getLanguage()   )    //-> en
                Log.d("Mylog44",Locale.getDefault().getISO3Language())   //-> eng
                Log.d("Mylog44",Locale.getDefault().getCountry() )       //-> US
                Log.d("Mylog44",Locale.getDefault().getISO3Country() )   //-> USA
                Log.d("Mylog44",Locale.getDefault().getDisplayCountry()) //-> United States
                Log.d("Mylog44",Locale.getDefault().getDisplayName())    //-> English (United States)
                Log.d("Mylog44",Locale.getDefault().toString()     )     //-> en_US
                Log.d("Mylog44",Locale.getDefault().getDisplayLanguage())//-> English
                Log.d("Mylog44",Locale.getDefault().toLanguageTag()  )  //-> en-US*/



        svLanguage.setOnClickListener {
            if (svLanguage.isChecked){

                tvLanguage.setText("Язык")
                tvNick.setText("НикНэйм")
                tvGraphics.setText("Качество Графики")
                tvAutoSave.setText("Автосохранение")

                prefs.edit().putString("Language", "RUS").apply()


                /*val config = resources.configuration
                val locale = Locale("ru") // needed language
                Locale.setDefault(locale)
                config.setLocale(locale)

                createConfigurationContext(config)
                resources.updateConfiguration(config, resources.displayMetrics)

                this.setContentView(R.layout.activity_main)*/

            }
            else{

                tvLanguage.setText("Language")
                tvNick.setText("Gamer NickName")
                tvGraphics.setText("Graphics")
                tvAutoSave.setText("Autosave")

                prefs.edit().putString("Language", "EN").apply()


                /*val config2 = resources.configuration
                val locale2 = Locale("en") // needed language
                Locale.setDefault(locale2)
                config2.setLocale(locale2)

                createConfigurationContext(config2)
                resources.updateConfiguration(config2, resources.displayMetrics)

                this.setContentView(R.layout.activity_main)*/
            }

 }

        svGraphics.setOnClickListener {
            if (svGraphics.isChecked){
                clMain.setBackgroundColor(Color.WHITE)
                prefs.edit().putString("BackgroundColor", "High").apply()
            }
            else{
                clMain.setBackgroundColor(Color.DKGRAY)
                prefs.edit().putString("BackgroundColor", "Low").apply()
            }
        }


        svAutoSave.setOnClickListener {
            if (svAutoSave.isChecked){
                toastoff.show()
                prefs.edit().putString("AutoSave", "Off").apply()
            }
            else{
                toaston.show()
                prefs.edit().putString("AutoSave", "On").apply()
            }
        }




        val language: String =
            if (prefs.getString("Language", "default") != null)
                prefs.getString("Language", "default")!!
            else "default"

        Log.d("MyLog44", language)




        val backgroundColor: String =
            if (prefs.getString("BackgroundColor", "default") != null)
                prefs.getString("BackgroundColor", "default")!!
            else "default"

        Log.d("MyLog44", backgroundColor)




        val autoSave: String =
            if (prefs.getString("AutoSave", "default") != null)
                prefs.getString("AutoSave", "default")!!
            else "default"

        Log.d("MyLog44", autoSave)


        /*val Result: Boolean =
            (if(language=="RUS") {
                svLanguage.isChecked
            } else if (backgroundColor=="High") {
                svLanguage.isChecked
            } else if (autoSave=="Off") {
                svAutoSave.isChecked
            } else {
                "default"
            }) as Boolean


        val Result: Unit =
            if(language=="RUS") {
                svLanguage.isChecked=true   //setOnCheckedChangeListener
            }  else {
                svLanguage.isChecked=false
            }


        Log.d("MyLog44", Result.toString())*/


    }



}