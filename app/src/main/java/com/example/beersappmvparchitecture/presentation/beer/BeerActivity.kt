package com.example.beersappmvparchitecture.presentation.beer

import android.os.Bundle
import com.example.beersappmvparchitecture.databinding.ActivityBeerBinding
import com.example.beersappmvparchitecture.presentation.base.BaseActivity
import com.example.beersappmvparchitecture.utils.setFragment

class BeerActivity : BaseActivity() {
    private lateinit var binding: ActivityBeerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            setFragment(BeerFragment.newInstance(), frameLayout.id)
        }
    }
}