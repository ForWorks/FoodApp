package com.example.test.presentation.ui.view.menu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryAdapter = CategoryAdapter(resources.getStringArray(R.array.categories)) {

        }
        binding.categories.adapter = categoryAdapter
        binding.banners.adapter = BannerAdapter()

        viewModel.getProductsList()
        viewModel.productsList.observe(viewLifecycleOwner) {
            binding.positions.adapter = MenuAdapter(it)
        }
    }
}