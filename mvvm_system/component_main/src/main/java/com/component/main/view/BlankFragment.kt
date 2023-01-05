package com.component.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.utils.LogUtil
import com.component.main.BR
import com.component.main.R
import com.component.main.databinding.FragmentBlankBinding
import com.component.main.viewModel.BlankFragmentVm
import com.mvvm.base.common.BaseViewPagerLazyFragment
import com.mvvm.base.common.ViewModelConfig


class BlankFragment : BaseViewPagerLazyFragment<BlankFragmentVm, FragmentBlankBinding>() {

    companion object{
        fun get() = BlankFragment()
        const val TAG = "BlankFragment"
    }

    override fun init(savedInstanceState: Bundle?) {

    }

    override fun getViewModelConfig(): ViewModelConfig {
        val config = ViewModelConfig(R.layout.fragment_blank)
        config.bindViewModel(BR.contentText)

        return config
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.e("=========BlankFragment onCreate=========")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtil.e("=========BlankFragment onAttach=========")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtil.e("=========BlankFragment onDetach=========")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.e("=========BlankFragment onCreateView=========")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.e("=========BlankFragment onViewCreated=========")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.e("=========BlankFragment onStart=========")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.e("=========BlankFragment onResume=========")
        bd.contentText?.liveData?.observe(this){
            LogUtil.e("contentText is $it")
            bd.textView.text = it
        }
        bd.contentText?.liveData?.value = "BlankFragment"
    }

    override fun onPause() {
        super.onPause()
        LogUtil.e("=========BlankFragment onPause=========")
    }

    override fun onStop() {
        super.onStop()
        LogUtil.e("=========BlankFragment onStop=========")
    }

    override fun onFirstShow() {
        LogUtil.e("=========BlankFragment onFirstShow=========")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.e("=========BlankFragment onDestroy=========")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtil.e("=========BlankFragment onDestroyView=========")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        LogUtil.e("=========BlankFragment onHiddenChanged=========")
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        LogUtil.e("=========BlankFragment setUserVisibleHint=========")
    }


}