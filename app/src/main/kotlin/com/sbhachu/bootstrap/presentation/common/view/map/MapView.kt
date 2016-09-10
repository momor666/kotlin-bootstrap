package com.sbhachu.bootstrap.presentation.common.view.map

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.sbhachu.bootstrap.R
import com.sbhachu.bootstrap.presentation.common.BaseView


class MapView : BaseView<MapPresenter>, IMapViewContract {

    private val TAG: String = this@MapView.javaClass.simpleName

    private var mapView: MapView? = null

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        super.initialise(R.layout.view_map)
    }

    override fun initialisePresenter(): MapPresenter {
        return MapPresenter(this)
    }

    override fun initialiseViews(view: View?) {
        mapView = view?.findViewById(R.id.gms_map_view) as MapView?

        mapView?.getMapAsync { map -> initialiseMap(map) }
    }

    override fun initialiseListeners() {

    }

    private fun initialiseMap(map : GoogleMap): Unit {
        Log.e(TAG, map.toString())

    }

    fun onCreate(bundle: Bundle?) {
        mapView?.onCreate(bundle)
    }

    fun onResume() {
        mapView?.onResume()
    }

    fun onPause() {
        mapView?.onPause()
    }

    override fun onDestroy() {
        mapView?.onDestroy()
        super.onDestroy()
    }

    fun onLowMemory() {
        mapView?.onLowMemory()
    }

    fun onSaveInstanceState(outState: Bundle?) {
        mapView?.onSaveInstanceState(outState)
    }
}