package com.mvvm.base.common

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var bd: DB

    protected abstract val viewModelConfig: ViewModelConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewDataBinding()
        initialize()
    }

    abstract fun initialize()

    private fun initViewDataBinding() {
        val config = viewModelConfig
        bd = DataBindingUtil.setContentView(this, config.getLayout())
        val variableId = config.getVmVariableId()
        getViewModel()
        if (variableId != ViewModelConfig.VM_NO_BIND) {
            //setVariable,当value改变时候，会自动在view更改
            bd.setVariable(variableId, viewModel)
        }
        val bindingParams = config.getBindingParams()
        run {
            var i = 0
            val length = bindingParams.size()
            while (i < length) {
                bd.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i))
                i++
            }
        }
    }

    private fun getViewModel() {
        val type = javaClass.genericSuperclass
        viewModel = if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[0]
            val tClass = tp as? Class<VM> ?: BaseViewModel::class.java
            ViewModelProvider(this)[tClass] as VM
        } else {
            viewModels<BaseViewModel>().value as VM
        }
    }
}