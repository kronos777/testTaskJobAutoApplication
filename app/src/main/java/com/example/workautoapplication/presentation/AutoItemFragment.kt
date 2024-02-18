package com.example.workautoapplication.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.workautoapplication.R
import com.example.workautoapplication.databinding.FragmentAutoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AutoItemFragment: Fragment() {

    private lateinit var onEditingFinishedListener: OnEditingFinishedListener
    private var _binding: FragmentAutoBinding? = null
    private val binding: FragmentAutoBinding
        get() = _binding ?: throw RuntimeException("FragmentListAutoBinding = null")

    private val viewModel: AutoViewModel by viewModels()
    /*by lazy {
        ViewModelProvider(this)[AutoViewModel::class.java]
    }*/
    private val args by navArgs<AutoItemFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).findViewById<Toolbar>(R.id.tool_bar).visibility = View.GONE
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        chooseModel()
        observeViewModel()
        addAuto()
    }

    private fun chooseModel() {
        if(args.id == -1) {
            addAuto()
        } else {
            setAuto()
            editAuto()
        }
    }

    private fun editAuto() {
        binding.saveButton.text = "Изменить"
        binding.saveButton.setOnClickListener {
            val brand = binding.etBrand.text.toString()
            val model = binding.etModel.text.toString()
            val price = binding.etPrice.text.toString()

            viewModel.editAutoItem(brand, model, price.toInt())
        }
    }

    private fun setAuto() {
        viewModel.getAutoItem(args.id)
    }

    private fun observeViewModel() {
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            onEditingFinishedListener.onEditingFinished()
        }
    }


    fun addAuto() {
        binding.saveButton.setOnClickListener {
            val brand = binding.etBrand.text.toString()
            val model = binding.etModel.text.toString()
            val price = binding.etPrice.text.toString()

            viewModel.addAutoItem(brand, model, price.toInt())
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnEditingFinishedListener) {
            onEditingFinishedListener = context
        } else {
            throw RuntimeException("Activity must implement OnEditingFinishedListener")
        }
    }


    interface OnEditingFinishedListener {
        fun onEditingFinished()
    }

}