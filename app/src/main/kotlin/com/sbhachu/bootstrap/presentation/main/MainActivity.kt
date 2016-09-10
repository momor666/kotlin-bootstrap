package com.sbhachu.bootstrap.presentation.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.sbhachu.bootstrap.R
import com.sbhachu.bootstrap.presentation.common.BaseActivity


class MainActivity : BaseActivity<MainPresenter>(), IMainViewContract, NavigationView.OnNavigationItemSelectedListener {

    private val TAG: String = "MainActivity"

    override var layoutId: Int = R.layout.activity_main

    private var navigationView: NavigationView? = null
    private var drawerLayout: DrawerLayout? = null
    private var toolbar: Toolbar? = null

    override fun initialisePresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun initialiseViews(): Unit {
        Log.d(TAG, "initialiseViews()")

        navigationView = findViewById(R.id.navigation_view) as NavigationView?
        drawerLayout = findViewById(R.id.navigation_drawer) as DrawerLayout?
        toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)

        supportActionBar?.setTitle(R.string.app_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun initialiseListeners(): Unit {
        Log.d(TAG, "initialiseListeners()")

        navigationView?.setNavigationItemSelectedListener(this)
    }

    override fun handleExtras(bundle: Bundle?): Unit {
        Log.d(TAG, "handleExtras()")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout?.closeDrawers()

        when (item.itemId) {
            R.id.screen_1 -> showSnackbar(getString(R.string.screen_1), Snackbar.LENGTH_LONG, getString(R.string.dismiss), hideSnackbar())
            R.id.screen_2 -> showSnackbar(getString(R.string.screen_2), Snackbar.LENGTH_LONG, getString(R.string.dismiss), hideSnackbar())
            R.id.screen_3 -> showSnackbar(getString(R.string.screen_3), Snackbar.LENGTH_LONG, getString(R.string.dismiss), hideSnackbar())
            else -> return false
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}