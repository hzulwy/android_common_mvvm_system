package com.component.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.utils.LogUtil
import com.component.main.BR
import com.component.main.R
import com.component.main.databinding.FragmentThirdBinding
import com.component.main.viewModel.ThirdFragmentVm
import com.mvvm.base.common.BaseViewPagerLazyFragment
import com.mvvm.base.common.ViewModelConfig



class ThirdFragment : BaseViewPagerLazyFragment<ThirdFragmentVm, FragmentThirdBinding>() {

    companion object{
        fun get() = ThirdFragment()

        const val TAG = "ThirdFragment"
    }

    override fun init(savedInstanceState: Bundle?) {

        bd.textView.text = "ThirdFragment"

    }

    override fun getViewModelConfig(): ViewModelConfig {
        val config = ViewModelConfig(R.layout.fragment_third)
        config.bindViewModel(BR.contentText)
        return config
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.e("=========ThirdFragment onCreate=========")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtil.e("=========ThirdFragment onAttach=========")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtil.e("=========ThirdFragment onDetach=========")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.e("=========ThirdFragment onCreateView=========")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.e("=========ThirdFragment onViewCreated=========")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.e("=========ThirdFragment onStart=========")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.e("=========ThirdFragment onResume=========")
        bd.contentText?.liveData?.observe(this){
            bd.textView.text = it
            LogUtil.e("contentText is $it")
        }
        bd.contentText?.liveData?.value = "ThirdFragment"
    }

    override fun onPause() {
        super.onPause()
        LogUtil.e("=========ThirdFragment onPause=========")
    }

    override fun onStop() {
        super.onStop()
        LogUtil.e("=========ThirdFragment onStop=========")
    }

    override fun onFirstShow() {
        LogUtil.e("=========ThirdFragment onFirstShow=========")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.e("=========ThirdFragment onDestroy=========")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtil.e("=========ThirdFragment onDestroyView=========")
    }


}