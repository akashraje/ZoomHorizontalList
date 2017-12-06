package com.akashraje.zoomhorizontallist.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akashraje.zoomhorizontallist.R
import com.akashraje.zoomhorizontallist.View.GridElementHolder
import com.akashraje.zoomhorizontallist.`interface`.ButtonType
import com.akashraje.zoomhorizontallist.`interface`.ClickListener


/**
 * Created by akashraje on 05/12/17.
 */

class GridAdapter(val list: List<String>, val context: Context, listener: ClickListener) : RecyclerView.Adapter<GridElementHolder>() {

    var listener: ClickListener = listener

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GridElementHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)

        return GridElementHolder(view)
    }

    override fun onBindViewHolder(holder: GridElementHolder?, position: Int) {
        if (position == 0) {
            holder?.imgView?.requestFocus()
        }

        holder?.txtView?.text = list[position]

        holder?.btnLeft?.setOnClickListener {
            listener.onPositionClicked(ButtonType.Left, position)
        }

        holder?.btnRight?.setOnClickListener {
            listener.onPositionClicked(ButtonType.Right, position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

