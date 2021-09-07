package com.example.frasesdodia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var texto: TextView
    val frases = arrayOf(
        "A persistência é o caminho do êxito.",
        "O sucesso nasce do querer, da determinação e persistência em se chegar a um objetivo. Mesmo não atingindo o alvo, quem busca e vence obstáculos, no mínimo fará coisas admiráveis.",
        "Só existe um êxito: a capacidade de levar a vida que se quer.",
        "Uma autoimagem forte e positiva é a melhor preparação possível para o sucesso.",
        "Não deixe que as pessoas te façam desistir daquilo que você mais quer na vida. Acredite. Lute. Conquiste. E acima de tudo, seja feliz!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById(R.id.textoFrase) as TextView
    }

    fun gerarFrase(view: View) {
        val totalItensArray = frases.size
        val numeroAleatorio = Random.nextInt(totalItensArray)
        texto.setText(frases[numeroAleatorio])
    }
}