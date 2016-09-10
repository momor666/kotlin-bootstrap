package com.sbhachu.bootstrap.extensions.listener

import android.support.v4.view.ViewPager


open class PageWatcher : ViewPager.SimpleOnPageChangeListener() {
    private var _onPageScrolled: ((position: Int, positionOffset: Float, positionOffsetPixels: Int) -> Unit)? = null
    private var _onPageScrollStateChanged: ((state: Int) -> Unit)? = null
    private var _onPageSelected: ((position: Int) -> Unit)? = null

    override fun onPageScrollStateChanged(state: Int) {
        _onPageScrollStateChanged?.invoke(state)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        _onPageScrolled?.invoke(position, positionOffset, positionOffsetPixels)
    }

    override fun onPageSelected(position: Int) {
        _onPageSelected?.invoke(position)
    }

    fun onPageScrollStateChanged(listener: (Int?) -> Unit) {
        _onPageScrollStateChanged = listener
    }

    fun onPageScrolled(listener: (Int?, Float?, Int?) -> Unit) {
        _onPageScrolled = listener
    }

    fun onPageSelected(listener: (Int?) -> Unit) {
        _onPageSelected = listener
    }
}