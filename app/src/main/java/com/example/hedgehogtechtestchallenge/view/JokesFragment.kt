package com.example.hedgehogtechtestchallenge.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hedgehogtechtestchallenge.R
import com.example.hedgehogtechtestchallenge.view.utils.JokesRecyclerAdapter
import com.example.hedgehogtechtestchallenge.view.utils.RecyclerViewMargin
import com.example.hedgehogtechtestchallenge.viewmodel.JokesViewModel


class JokesFragment : Fragment() {

    private lateinit var itemDecoration: RecyclerViewMargin
    private lateinit var btn: Button
    private lateinit var editText: TextView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var list: RecyclerView
    private lateinit var adapter: JokesRecyclerAdapter
    private lateinit var progressBar: ProgressBar

    private val viewModel: JokesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.jokes_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewResource(view)
        btnSetOnClickListener()
        observeViewModel()
    }

    private fun btnSetOnClickListener() {
        btn.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                Log.d(JokesFragment::class.java.simpleName, "${editText.text.toString().toInt()}")
                viewModel.refresh(editText.text.toString().toInt())
            } else {
                Toast.makeText(context, "Enter count", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.jokes.observe(viewLifecycleOwner, { jokes -> adapter.submitList(jokes) })
        viewModel.loading.observe(viewLifecycleOwner, { loadingState ->
            if (loadingState) {
                btn.visibility = Button.INVISIBLE
                progressBar.visibility = ProgressBar.VISIBLE
            } else {
                btn.visibility = Button.VISIBLE
                progressBar.visibility = ProgressBar.INVISIBLE
            }
        })
        viewModel.loadError.observe(viewLifecycleOwner, { errorMsg ->
            if (errorMsg != null) Toast.makeText(context, errorMsg, Toast.LENGTH_SHORT).show()
        })
    }

    private fun initViewResource(view: View) {
        adapter = JokesRecyclerAdapter()
        list = view.findViewById(R.id.joke_rv)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        editText = view.findViewById(R.id.joke_counter)
        btn = view.findViewById(R.id.button)
        progressBar = view.findViewById(R.id.progress_bar)
        itemDecoration =
            RecyclerViewMargin(requireActivity().resources.getDimension(R.dimen.recycler).toInt())
        list.layoutManager = layoutManager
        list.addItemDecoration(itemDecoration)
        list.adapter = adapter
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.loadError.value = null
    }


}