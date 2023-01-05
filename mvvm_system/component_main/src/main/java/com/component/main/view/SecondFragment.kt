package com.component.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.utils.LogUtil
import com.component.main.BR
import com.component.main.R
import com.component.main.databinding.FragmentSecondBinding
import com.component.main.viewModel.SecondFragmentVm
import com.mvvm.base.common.BaseViewPagerLazyFragment
import com.mvvm.base.common.ViewModelConfig



class SecondFragment : BaseViewPagerLazyFragment<SecondFragmentVm, FragmentSecondBinding>() {

    companion object{
        fun get() = SecondFragment()

        const val TAG = "SecondFragment"
    }

    override fun init(savedInstanceState: Bundle?) {

        bd.textView.text = "SecondFragment"

    }

    override fun getViewModelConfig(): ViewModelConfig {
        val config = ViewModelConfig(R.layout.fragment_second)
        config.bindViewModel(BR.contentText)
        return config
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.e("=========SecondFragment onCreate=========")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtil.e("=========SecondFragment onAttach=========")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtil.e("=========SecondFragment onDetach=========")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.e("=========SecondFragment onCreateView=========")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.e("=========SecondFragment onViewCreated=========")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.e("=========SecondFragment onStart=========")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.e("=========SecondFragment onResume=========")
        bd.contentText?.liveData?.observe(this){
            LogUtil.e("contentText is $it")
            bd.textView.text = it
        }
        bd.contentText?.liveData?.value = "SecondFragment"
    }

    override fun onPause() {
        super.onPause()
        LogUtil.e("=========SecondFragment onPause=========")
    }

    override fun onStop() {
        super.onStop()
        LogUtil.e("=========SecondFragment onStop=========")
    }

    override fun onFirstShow() {
        LogUtil.e("=========SecondFragment onFirstShow=========")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.e("=========SecondFragment onDestroy=========")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtil.e("=========SecondFragment onDestroyView=========")
    }

}