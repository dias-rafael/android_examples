package com.example.rafaeldias.filmescoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainReposiory) : ViewModel() { //injeção dependecia repository para não gerar acoplamento

    val filmesLiveData = MutableLiveData<List<Filmes>>()

    fun getFilmes() {
        repository.getFilmes { filmes ->
            //filmesLiveData.value = filmes //entrega o resultado na thread atual
            filmesLiveData.postValue(filmes) //entrega o resultado na thread principal
        }
    }

    fun getFilmesCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val filmes = withContext(Dispatchers.Default) {
                repository.getFilmesCoroutines()
            }

            filmesLiveData.value = filmes
        }
    }

    class MainViewModelFactory (  //criado factory para que ele possa ser passado ao fragmento
        private val repository: MainReposiory
            ): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }
}