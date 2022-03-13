package com.example.beersappmvparchitecture.presentation.beer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.beersappmvparchitecture.databinding.FragmentBeerBinding
import com.example.beersappmvparchitecture.domain.model.BeerDomain
import com.example.beersappmvparchitecture.presentation.base.BaseFragment
import com.example.beersappmvparchitecture.presentation.beer.model.BeerView
import com.example.beersappmvparchitecture.utils.onScrollHitBottom
import com.example.beersappmvparchitecture.utils.visible
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class BeerFragment : BaseFragment(), BeerContract.View {
    private lateinit var binding: FragmentBeerBinding
    private lateinit var adapter: BeerListAdapter
    private val presenter by inject<BeerContract.Presenter> { parametersOf(this) }

    companion object {
        const val GRID_SPAN_COUNT = 2

        fun newInstance(): BeerFragment {
            return BeerFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeerBinding.inflate(layoutInflater)
        presenter.initView()
        return binding.root
    }

    override fun showError(message: String) {
        binding.run {
            textViewEmpty.text = message
            textViewEmpty.visible()
            buttonTryAgain.visible()
        }
    }

    override fun onClickTryAgain() {
        binding.run {
            buttonTryAgain.setOnClickListener {
                presenter.loadAll()
            }
        }
    }

    override fun updateList(list: List<BeerView>) {
        adapter.list = list
        adapter.notifyDataSetChanged()
    }

    override fun configureRecyclerView() {
        binding.run {
            val layoutManager =
                StaggeredGridLayoutManager(GRID_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
            recyclerView.onScrollHitBottom {
                presenter.loadMore()
            }
        }
    }

    override fun setAdapter() {
        adapter = BeerListAdapter(requireContext())
    }

    override fun onResume() {
        super.onResume()
        presenter.loadAll()
    }
}