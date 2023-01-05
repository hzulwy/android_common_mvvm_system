package com.component.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.base.utils.LogUtil
import com.component.main.R
import com.component.main.databinding.FragmentBlankBinding
import com.mvvm.base.common.BaseLazyFragment
import com.mvvm.base.common.BaseViewModel
import com.mvvm.base.common.BaseViewPagerLazyFragment

class MainPageStateAdapter(
    private val activity: FragmentActivity,
    private val titles: Array<String>,
    private val list: MutableList<BaseViewPagerLazyFragment<out BaseViewModel, out ViewDataBinding>>
) :
    FragmentStateAdapter(activity) {

    private val images = intArrayOf(
        R.drawable.selector_component_home_tab_1,
        R.drawable.selector_component_home_tab_2,
        R.drawable.selector_component_home_tab_3,
        R.drawable.selector_component_home_tab_4
    )

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun createFragment(position: Int): Fragment {
        LogUtil.e("position is $position,list is ${list[position]}")
        return list[position]
    }

    fun getTabView(context: Context, position: Int): View {
        val v = LayoutInflater.from(context).inflate(R.layout.home_tablayout_icon, null)
        val textView = v.findViewById<TextView>(R.id.tlText)
        val imageView = v.findViewById<ImageView>(R.id.tlIcon)
        textView.text = titles[position]
        imageView.setImageResource(images[position])
        return v
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        //只会调用一次
        LogUtil.e("===MainPageStateAdapter onAttachedToRecyclerView===")
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        LogUtil.e("===MainPageStateAdapter onDetachedFromRecyclerView===")
    }

    override fun onViewDetachedFromWindow(holder: FragmentViewHolder) {
        super.onViewDetachedFromWindow(holder)
        //每次点击tab时都会调用
        LogUtil.e("===MainPageStateAdapter onViewDetachedFromWindow===")
    }
}