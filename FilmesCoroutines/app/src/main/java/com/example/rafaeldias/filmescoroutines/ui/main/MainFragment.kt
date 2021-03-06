package com.example.rafaeldias.filmescoroutines.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.rafaeldias.filmescoroutines.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, MainViewModel.MainViewModelFactory(MainReposiory())).get(MainViewModel::class.java)

        viewModel.filmesLiveData.observe(viewLifecycleOwner, Observer { filmes ->
            view?.findViewById<TextView>(R.id.textViewFilmes)?.text = filmes[0].titulo
        })

        //viewModel.getFilmes()
        viewModel.getFilmesCoroutines()
    }

}