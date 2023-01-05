package com.component.main.viewModel

import androidx.lifecycle.MutableLiveData
import com.mvvm.base.common.BaseViewModel

class MainVm:BaseViewModel() {

    var test = MutableLiveData<Boolean>()
}