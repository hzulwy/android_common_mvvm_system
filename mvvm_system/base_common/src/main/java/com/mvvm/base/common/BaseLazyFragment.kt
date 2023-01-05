package com.mvvm.base.common

import androidx.databinding.ViewDataBinding

abstract class BaseLazyFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseFragment<VM, DB>() {

    private var isVisibleToUser: Boolean = true
    private var hidden: Boolean = false
    private var isShow: Boolean = false


    //setUserVisibleHint()在Fragment创建时会先被调用一次，传入isVisibleToUser = false
    //如果当前Fragment可见，那么setUserVisibleHint()会再次被调用一次，传入isVisibleToUser = true
    //如果Fragment从可见->不可见，那么setUserVisibleHint()也会被调用，传入isVisibleToUser = false
    //总结：setUserVisibleHint()除了Fragment的可见状态发生变化时会被回调外，在new Fragment()时也会被回调
    //如果我们需要在 Fragment 可见与不可见时干点事，用这个的话就会有多余的回调了，那么就需要重新封装一个
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        onCustomUserVisibleHint(isVisibleToUser)
        dispatchUserVisibleToChild(isVisibleToUser)
    }

    private fun onCustomUserVisibleHint(isVisibleToUser: Boolean) {
        this.isVisibleToUser = isVisibleToUser
        if (isVisibleToUser) {
            triggerShow()
        } else {
            triggerHide()
        }

    }

    private fun dispatchUserVisibleToChild(isVisibleToUser: Boolean) {
        if (isAdded) {
            for (fragment in childFragmentManager.fragments) {
                if (fragment is BaseLazyFragment<*, *> && fragment.isAdded) {
                    fragment.onCustomUserVisibleHint(isVisibleToUser)
                }
            }
        }
    }

    private fun triggerHide() {
        if (!isVisibleToUser()) {
            hide()
        }
    }

    private fun hide() {
        if (!isShow){
            return
        }
        isShow = false
        onHide()
    }

    abstract fun onHide()

    private fun triggerShow() {
        if(isVisibleToUser()){
            show()
        }
    }

    private fun show() {
        if(isShow){
            return
        }
        isShow = true
        onShow()
    }

    abstract fun onShow()

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        onCustomHiddenChanged(hidden)
        dispatchHiddenChangedToChild(hidden)
    }

    private fun onCustomHiddenChanged(hidden: Boolean) {
        this.hidden = hidden
        if (hidden) {
            triggerHide()
        } else {
            triggerShow()
        }
    }

    private fun dispatchHiddenChangedToChild(isVisibleToUser: Boolean) {
        if (isAdded) {
            for (fragment in childFragmentManager.fragments) {
                if (fragment is BaseLazyFragment<*, *> && fragment.isAdded) {
                    fragment.onCustomUserVisibleHint(isVisibleToUser)
                }
            }
        }
    }

    private fun isVisibleToUser(): Boolean {
        return !hidden && isVisibleToUser && isAdded && (view != null)
    }
}