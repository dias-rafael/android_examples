package com.example.rafaeldias.filmescoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainReposiory {

    fun getFilmes(callback: (filmes: List<Filmes>) -> Unit) { //retorno da função será o callback pois não é o thread principal
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filmes(1, "Titulo 1"),
                    Filmes(2, "Titulo 2")
                )
            )
        }).start()
    }

    suspend fun getFilmesCoroutines(): List<Filmes> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filmes(1, "Titulo 1"),
                Filmes(2, "Titulo 2")
            )
        }
    }
}