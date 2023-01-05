package com.component.main.viewModel;

import androidx.lifecycle.MutableLiveData;

import com.mvvm.base.common.BaseViewModel;

public class BlankFragmentVm extends BaseViewModel {

    public MutableLiveData<String> getLiveData() {
        return liveData;
    }

    public void setLiveData(MutableLiveData<String> liveData) {
        this.liveData = liveData;
    }

    MutableLiveData<String> liveData = new MutableLiveData();


}
