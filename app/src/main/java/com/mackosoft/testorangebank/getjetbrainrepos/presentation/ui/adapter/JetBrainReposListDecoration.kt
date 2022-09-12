package com.mackosoft.testorangebank.getjetbrainrepos.presentation.ui.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mackosoft.testorangebank.extensions.fromDipToPixel

class JetBrainReposListDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val marginTop       = context.fromDipToPixel(8f).toInt()
    private val marginStart     = context.fromDipToPixel(16f).toInt()
    private val marginEnd       = context.fromDipToPixel(16f).toInt()
    private val marginBottom    = context.fromDipToPixel(8f).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.apply {
            top = marginTop
            left = marginStart
            right = marginEnd
            bottom = marginBottom
        }
    }

}