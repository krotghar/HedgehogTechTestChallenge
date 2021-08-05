package com.example.hedgehogtechtestchallenge.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hedgehogtechtestchallenge.R
import com.example.hedgehogtechtestchallenge.viewmodel.JokesViewModel

class JokesFragment : Fragment() {

    companion object {
        fun newInstance() = JokesFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.jokes_fragment, container, false)
    }

}