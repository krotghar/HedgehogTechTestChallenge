package com.example.hedgehogtechtestchallenge.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hedgehogtechtestchallenge.R
import com.example.hedgehogtechtestchallenge.view.utils.JokesRecyclerAdapter
import com.example.hedgehogtechtestchallenge.view.utils.RecyclerViewMargin
import com.example.hedgehogtechtestchallenge.viewmodel.JokesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

class JokesFragment : Fragment() {

    companion object {
        fun newInstance() = JokesFragment()
    }

    private lateinit var adapter: JokesRecyclerAdapter
    private val viewModel: JokesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.jokes_fragment, container, false)

    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = JokesRecyclerAdapter()
        val list: RecyclerView = view.findViewById(R.id.joke_rv)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val editText: EditText = view.findViewById(R.id.joke_counter)
        val btn: Button = view.findViewById(R.id.button)

        btn.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                Log.d(JokesFragment::class.java.simpleName, "${editText.text.toString().toInt()}")
                viewModel.refresh(editText.text.toString().toInt())
            } else {
                Toast.makeText(context, "Enter count", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.jokes.observe(viewLifecycleOwner, { jokes -> adapter.submitList(jokes) })
        val itemDecoration = RecyclerViewMargin(requireActivity().resources.getDimension(R.dimen.recycler).toInt())
        list.layoutManager = layoutManager
        list.addItemDecoration(itemDecoration)
        list.adapter = adapter

    }





}