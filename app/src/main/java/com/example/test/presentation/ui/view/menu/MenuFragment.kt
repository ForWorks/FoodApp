package com.example.test.presentation.ui.view.menu

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.test.R
import com.example.test.databinding.FragmentMenuBinding
import com.example.test.presentation.ui.view.menu.adapters.BannerAdapter
import com.example.test.presentation.ui.view.menu.adapters.CategoryAdapter
import com.example.test.presentation.ui.view.menu.adapters.MenuAdapter
import com.example.test.presentation.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private val binding by lazy { FragmentMenuBinding.inflate(layoutInflater) }
    private val handler by lazy { Handler(Looper.getMainLooper()) }
    companion object {
        private var getDataFromDatabase = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryAdapter = CategoryAdapter(resources.getStringArray(R.array.categories)) {
            // changing products
        }

        binding.categories.adapter = categoryAdapter
        binding.banners.adapter = BannerAdapter()

        viewModel.productsList.observe(viewLifecycleOwner) {
            binding.positions.adapter = MenuAdapter(it)
        }
    }

    override fun onPause() {
        handler.removeCallbacks(checkConnection)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        handler.post(checkConnection)
    }

    private val checkConnection = object : Runnable {
        override fun run() {

            if(viewModel.productsList.value.isNullOrEmpty()) {

                if (isOnline()) {
                    viewModel.getProductsList()
                }
                else {
                    if(!getDataFromDatabase) {
                        viewModel.getDataFromDatabase()
                        Toast.makeText(binding.root.context, resources.getString(R.string.check_connection), Toast.LENGTH_LONG).show()
                        getDataFromDatabase = true
                    }
                }

                handler.postDelayed(this, 3000)
            }
        }
    }

    private fun isOnline(): Boolean {
        val connectivityManager =
            activity
                ?.applicationContext
                ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetwork != null
    }
}