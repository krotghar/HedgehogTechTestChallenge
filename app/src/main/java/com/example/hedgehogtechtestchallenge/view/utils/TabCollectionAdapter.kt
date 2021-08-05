package com.example.hedgehogtechtestchallenge.view.utils

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hedgehogtechtestchallenge.view.JokesFragment
import com.example.hedgehogtechtestchallenge.view.WebViewFragment

class TabCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        lateinit var fragment: Fragment
        when (position) {
            0 -> fragment = JokesFragment()
            1 -> fragment = WebViewFragment()
        }
        return  fragment
    }

}