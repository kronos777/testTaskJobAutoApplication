package com.example.workautoapplication.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.workautoapplication.R
import com.example.workautoapplication.databinding.FragmentListAutoBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class AutoItemListFragment: Fragment() {


    private var _binding: FragmentListAutoBinding? = null
    private val binding: FragmentListAutoBinding
        get() = _binding ?: throw RuntimeException("FragmentListAutoBinding = null")

    private val navController by lazy {
        (activity?.supportFragmentManager?.findFragmentById(com.example.workautoapplication.R.id.fragment_item_container) as NavHostFragment).navController
    }

    private val viewModel: AutoListViewModel by viewModels()

    @Inject
    lateinit var adapterAuto: AutoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListAutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickItemMenu()
        setupRecyclerView()
        setDataRecyclerView()
        addAutoItem()

    }

    private fun onClickItemMenu() {
        val toolBar = (activity as AppCompatActivity).findViewById<Toolbar>(R.id.tool_bar)
        toolBar.visibility = View.VISIBLE
        toolBar.title = "Ваш авто"
        toolBar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.option_1 -> {
                    viewModel.autoList.observe(viewLifecycleOwner) {
                        val sortedPrice = it.sortedByDescending { it.price }
                        adapterAuto.submitList(sortedPrice)
                    }
                }
                R.id.option_2 -> {
                    viewModel.autoList.observe(viewLifecycleOwner) {
                        val sortedPrice = it.sortedByDescending { it.brand }
                        adapterAuto.submitList(sortedPrice)
                    }
                }
                R.id.option_3 -> {
                    viewModel.autoList.observe(viewLifecycleOwner) {
                        val sortedPrice = it.sortedByDescending { it.model }
                        adapterAuto.submitList(sortedPrice)
                    }
                }
            }
            true
        }
    }

    private fun setDataRecyclerView() {
          viewModel.autoList.observe(viewLifecycleOwner) {
              adapterAuto.submitList(it)
          }
    }


    private fun addAutoItem() {
        binding.buttonAddAutoItem.setOnClickListener {
           //navController.navigate(AutoItemListFragmentDirections.actionAutoItemListFragmentToAutoItemFragment())
            navController.navigate(AutoItemListFragmentDirections.actionAutoItemListFragmentToAutoItemFragment(-1))
        }
    }

    private fun setupRecyclerView() {
        with(binding.autoList) {
            adapter = adapterAuto
            recycledViewPool.setMaxRecycledViews(
                AutoListAdapter.VIEW_TYPE_ENABLED,
                AutoListAdapter.MAX_POOL_SIZE
            )

        }

        setupClickListener()
    }

    private fun setupClickListener() {
        adapterAuto.onAutoItemClickListener = {
            //Toast.makeText(activity, "this auto " + it.id, Toast.LENGTH_SHORT).show()
            navController.navigate(AutoItemListFragmentDirections.actionAutoItemListFragmentToAutoItemFragment(it.id))
        }
    }




}