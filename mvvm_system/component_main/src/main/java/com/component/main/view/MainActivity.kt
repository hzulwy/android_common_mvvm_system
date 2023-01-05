package com.component.main.view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.component.main.R
import com.component.main.adapter.MainPageStateAdapter
import com.component.main.databinding.ActivityMainBinding
import com.component.main.viewModel.MainVm
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mvvm.base.common.BaseActivity
import com.mvvm.base.common.BaseLazyFragment
import com.mvvm.base.common.BaseViewModel
import com.mvvm.base.common.BaseViewPagerLazyFragment
import com.mvvm.base.common.ViewModelConfig

class MainActivity : BaseActivity<MainVm, ActivityMainBinding>() {
    override val viewModelConfig: ViewModelConfig
        get() = ViewModelConfig(R.layout.activity_main)

    override fun initialize() {

        initView()
    }

    private fun initView() {

        val title = arrayOf(
            getString(R.string.component_main_tab_1),
            getString(R.string.component_main_tab_2),
            getString(R.string.component_main_tab_3),
            getString(R.string.component_main_tab_4)
        )

        val list: MutableList<BaseViewPagerLazyFragment<out BaseViewModel, out ViewDataBinding>> =
            mutableListOf(
                BlankFragment.get(),
                SecondFragment.get(),
                ThirdFragment.get(),
                MineFragment.get()
            )

        //-1:默认关闭预加载
        //可以不设置，默认是-1,因此默认情况下viewpager2相当于是懒加载,但是这样会导致fragment频繁销毁创建
        //如果不关闭预加载，假设设置为4，4个fragment的生命周期都会按照顺序被调用到onstart这个状态,可以借此实现懒加载,让ViewPager2预先创建出所有的Fragment，防止切换造成的频繁销毁和创建
        //无论fragment是否被预先创建,只有可见的时候,才会调用onresume,可以在onresume中实现懒加载,详情看BaseLazyFragment和BaseViewPagerLazyFragment类
        //这种方案当app退到后台的时候,所有的fragment都会调用onstop,回到前台时,所有的fragment都会调用onstart
        bd.viewPage.offscreenPageLimit = list.size

        val adapter = MainPageStateAdapter(this, title, list)
        bd.viewPage.adapter = adapter
        for (i in list.indices) {
            bd.homeTabLayout.addTab(bd.homeTabLayout.newTab())
            val tab = bd.homeTabLayout.getTabAt(i)
            tab?.customView = adapter.getTabView(this, i)
        }
        bd.homeTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                bd.viewPage.setCurrentItem(tab?.position ?: 0, false)//禁止滑动动画
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        //禁止viewpager滚动
        bd.viewPage.isUserInputEnabled = false

        //在没有禁止viewpager滚动的情况下，下面这两个可以禁止预加载,如果禁止了viewpager滚动,那么设置与否效果都一样
        //在没有禁止viewpgaer滚动的情况下,如果只设置第一句,不设置第二句,在点击tab的情况下还是会预加载
        (bd.viewPage.getChildAt(0) as RecyclerView).layoutManager?.isItemPrefetchEnabled =false
        (bd.viewPage.getChildAt(0) as RecyclerView).setItemViewCacheSize(0)

        //当viewpager左右滑动时，tablayout和viewpager可以联动，前提是不要禁止viewpager滑动
        TabLayoutMediator(
            bd.homeTabLayout,
            bd.viewPage,
            true,
            false
        ) { tab, position -> tab?.customView = adapter.getTabView(this@MainActivity, position) }.attach()
    }

}