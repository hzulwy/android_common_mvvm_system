package com.mvvm.base.common

import android.util.SparseArray

class ViewModelConfig(private var layout: Int) {

    companion object {
        //viewmodel与layout没有绑定的默认值
        const val VM_NO_BIND = -10000
    }

    private val bindingParams : SparseArray<Any> = SparseArray()

    private var vmVariableId: Int = VM_NO_BIND

    fun getLayout(): Int {
        return layout
    }

    fun getVmVariableId(): Int {
        return vmVariableId
    }

    fun getBindingParams(): SparseArray<Any> {
        return bindingParams
    }

    fun bindingParam(variableId: Int, obj: Any): ViewModelConfig {
        if (bindingParams[variableId] == null) {
            bindingParams.put(variableId, obj)
        }
        return this
    }

    fun bindViewModel(vmVariableId: Int): ViewModelConfig {
        this.vmVariableId = vmVariableId
        return this
    }
}