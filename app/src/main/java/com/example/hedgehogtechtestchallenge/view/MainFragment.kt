package com.example.hedgehogtechtestchallenge.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.hedgehogtechtestchallenge.R
import com.example.hedgehogtechtestchallenge.view.utils.TabCollectionAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private lateinit var demoCollectionAdapter: TabCollectionAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val tabText = arrayOf("Jokes", "Web")
    private val tabIcon: Array<Int> = arrayOf(R.drawable.ic_buffoon, R.drawable.ic_web)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragmnet, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionAdapter = TabCollectionAdapter(this)
        viewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = demoCollectionAdapter
        tabLayout = view.findViewById(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabText[position]
            tab.icon = resources.getDrawable(tabIcon[position], requireActivity().application.theme)
        }.attach()
    }


    companion object {
        fun newInstance() = MainFragment()
    }
}