package com.akashraje.zoomhorizontallist.View

import android.content.Context
import android.support.v17.leanback.widget.HorizontalGridView
import android.util.AttributeSet
import android.view.MotionEvent
import com.akashraje.zoomhorizontallist.Adapter.GridAdapter
import com.akashraje.zoomhorizontallist.`interface`.ButtonType
import com.akashraje.zoomhorizontallist.`interface`.ClickListener

/**
 * Created by akashraje on 05/12/17.
 */

class HorizontalList(context: Context, attrs: AttributeSet): HorizontalGridView(context, attrs), ClickListener {

    init {
        //Send list of images here.
        adapter = GridAdapter(listOf("1", "2", "3", "4", "5", "6", "7", "8"), context, this)
    }

    // Stop drag scroll
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_MOVE) {
            return true;
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onPositionClicked(btnType: ButtonType, position: Int) {

        if (btnType == ButtonType.Right && (position != (adapter.itemCount - 1))) {
            var holder:GridElementHolder? =  findViewHolderForAdapterPosition(position + 1) as GridElementHolder
            holder?.imgView?.requestFocusFromTouch()
        } else if (btnType == ButtonType.Left && (position != 0)){
            var holder:GridElementHolder? =  findViewHolderForAdapterPosition(position - 1) as GridElementHolder
            holder?.imgView?.requestFocusFromTouch()
        }

    }
}