package com.example.randomfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var films: MutableList<String>

    private lateinit var txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.text)
        loadFilms(null)
    }

    fun getFilm(view: View) {
        if (films.size == 0) {
            txt.text = "БОЛЬШЕ ФИЛЬМОВ НЕ СУЩЕСТВУЕТ"
            return
        }
        val idx = Random.nextInt(films.size)
        txt.text = films[idx]
        films.removeAt(idx)
    }

    fun loadFilms(view: View?) {
        txt.text = ""
        films = resources.getStringArray(R.array.films).toMutableList()
    }
}