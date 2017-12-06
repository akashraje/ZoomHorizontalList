package com.akashraje.zoomhorizontallist.View

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.akashraje.zoomhorizontallist.R

/**
 * Created by akashraje on 06/12/17.
 */
class GridElementHolder(v : View) : RecyclerView.ViewHolder(v), View.OnFocusChangeListener {

    val view : View = v
    var imgView: ImageView? = null
    var txtView: TextView? = null
    var btnLeft: Button? = null
    var btnRight: Button? = null

    init {

        imgView = view.findViewById(R.id.imgView)
        txtView = view.findViewById(R.id.textView)

        btnLeft = view.findViewById(R.id.btnLeft)

        btnRight = view.findViewById(R.id.btnRight)

        imgView?.setOnFocusChangeListener(this)
    }

    override fun onFocusChange(viewArg: View?, b: Boolean) {
        if (b) { // Has Focus
            scaleUp()
        } else { // Focus gone
            scaleDown()
        }
    }

    fun scaleUp() {
        val scalingFactor = 1.8f
        imgView?.scaleX = scalingFactor
        imgView?.scaleY = scalingFactor
    }

    fun  scaleDown() {
        val scalingFactor = 1.0f
        imgView?.scaleX = scalingFactor
        imgView?.scaleY = scalingFactor
    }

}