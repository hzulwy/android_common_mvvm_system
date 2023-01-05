package com.component.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.utils.LogUtil
import com.component.main.BR
import com.component.main.R
import com.component.main.databinding.FragmentMineBinding
import com.component.main.viewModel.MineFragmentVm
import com.mvvm.base.common.BaseViewPagerLazyFragment
import com.mvvm.base.common.ViewModelConfig



class MineFragment : BaseViewPagerLazyFragment<MineFragmentVm, FragmentMineBinding>() {

    companion object{
        fun get() = MineFragment()

        const val TAG = "MineFragment"
    }

    override fun init(savedInstanceState: Bundle?) {

        bd.textView.text = "MineFragment"

    }

    override fun getViewModelConfig(): ViewModelConfig {
        val config = ViewModelConfig(R.layout.fragment_mine)
        config.bindViewModel(BR.contentText)
        return config
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.e("=========MineFragment onCreate=========")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtil.e("=========MineFragment onAttach=========")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtil.e("=========MineFragment onDetach=========")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.e("=========MineFragment onCreateView=========")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.e("=========MineFragment onViewCreated=========")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.e("=========MineFragment onStart=========")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.e("=========MineFragment onResume=========")
        bd.contentText?.liveData?.observe(this){
            LogUtil.e("contentText is $it")
            bd.textView.text = it
        }
        bd.contentText?.liveData?.value = "MineFragment"
    }

    override fun onPause() {
        super.onPause()
        LogUtil.e("=========MineFragment onPause=========")
    }

    override fun onStop() {
        super.onStop()
        LogUtil.e("=========MineFragment onStop=========")
    }

    override fun onFirstShow() {
        LogUtil.e("=========MineFragment onFirstShow=========")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.e("=========MineFragment onDestroy=========")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtil.e("=========MineFragment onDestroyView=========")
    }


}