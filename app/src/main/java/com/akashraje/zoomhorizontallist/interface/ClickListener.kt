package com.akashraje.zoomhorizontallist.`interface`

/**
 * Created by akashraje on 05/12/17.
 */

enum class ButtonType {
    Left,
    Right
}
interface ClickListener {

    fun onPositionClicked(btnType: ButtonType, position: Int)
}