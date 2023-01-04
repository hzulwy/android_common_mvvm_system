package com.mvvm.system.main

import android.util.Log
import com.mvvm.base.common.BaseActivity
import com.mvvm.base.common.ViewModelConfig
import com.mvvm.system.BR
import com.mvvm.system.R
import com.mvvm.system.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainVm,ActivityMainBinding>() {
    override val viewModelConfig: ViewModelConfig
        get() = ViewModelConfig(R.layout.activity_main)
            .bindViewModel(BR.mainVm)

    override fun initialize() {
//        viewModel.test.observe(this){
//            Log.e("MainActivity","$it")
//        }
//        viewModel.test.value = true
    }

}