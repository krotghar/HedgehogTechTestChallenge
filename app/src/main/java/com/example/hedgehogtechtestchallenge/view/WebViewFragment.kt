package com.example.hedgehogtechtestchallenge.view

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.example.hedgehogtechtestchallenge.R

class WebViewFragment : Fragment() {
    private lateinit var webView: WebView

    companion object {
        fun newInstance() = WebViewFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.web_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.web_view)
        webView.webViewClient = MyWebViewClient()
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState.getBundle("webView")!!)
        } else {
            webView.loadUrl("https://www.icndb.com/api/")
        }

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if(webView.canGoBack()) {
                        isEnabled = false
                        webView.goBack()
                    } else {
                        isEnabled = true
                    }
                    if (isEnabled) {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
            })

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val bundle = Bundle()
        webView.saveState(bundle)
        outState.putBundle("webView", bundle)
    }

    private class MyWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }


}