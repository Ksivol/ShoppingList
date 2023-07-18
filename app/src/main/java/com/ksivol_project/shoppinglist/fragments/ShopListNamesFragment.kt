package com.ksivol_project.shoppinglist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ksivol_project.shoppinglist.activities.MainApp
import com.ksivol_project.shoppinglist.databinding.FragmentShopListNamesBinding
import com.ksivol_project.shoppinglist.db.MainViewModel

class ShopListNamesFragment : BaseFragment() {

    private lateinit var binding: FragmentShopListNamesBinding

    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }

    override fun onClickNew() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopListNamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        observer()
    }

    private fun initRcView() = with(binding) {

    }

    private fun observer() {
        mainViewModel.allNotes.observe(viewLifecycleOwner, {

        })
    }


    companion object {
        @JvmStatic
        fun newInstance() = ShopListNamesFragment()
    }
}