package com.carroza.logistics.carroza_app.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.carroza.logistics.carroza_app.R

class DestinationLine @JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0, defRes: Int = 0)
    : LinearLayout(context, attributeSet, defStyle, defRes){

        init {
            orientation = LinearLayout.VERTICAL

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.destination_line, this)
        }
}